#ifndef HOKUSAI_NATIVE
#define HOKUSAI_NATIVE
#include "graal_isolate.h"
#include "hokusai-native-ext.h"
#include "libhokusai-native.h"
#include "raylib.h"
#include "hashmap.h"
#include "string.h"
#include <stdlib.h>
#include <stdio.h>

/**
 * 
 *  Declare caches
 */
typedef struct TextureCache
{
  char* key;
  Texture payload;
} texture_cache;

typedef struct ShaderCache
{
  char* key;
  Shader payload;
} shader_cache;

typedef struct FontCache
{
  char* key;
  Font payload;
  struct hashmap* char_cache;
} font_cache;

typedef struct MeasureCache
{
  char letter;
  float width;
} measure_cache;

static char default_chars[122] = "\x1b– —‘’“”…\r\n\t0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%%^&*(),.?/\\[]-_=+|~`{}<>;:\"'";
static struct hashmap* textures = NULL;
static struct hashmap* shaders = NULL;
static struct hashmap* fonts = NULL;
static Font active_font;
static char* active_font_key = NULL;
static double active_scissor[4] = {0.0, 0.0, 0.0, 0.0};
static int screenWidth;
static int screenHeight;
/**
 * Hashmaps
 */
uint64_t char_cache_hash(const void* item, uint64_t seed0, uint64_t seed1)
{
	measure_cache* cache = (measure_cache*) item;
	return hashmap_sip(&(cache->letter), 1, seed0, seed1);
}

int char_cache_compare(const void* a, const void* b, void* udata)
{
  const measure_cache* prop_a = (measure_cache*) a;
	const measure_cache* prop_b = (measure_cache*) b;
	return prop_a->letter > prop_b->letter;
}

void font_free(font_cache* font)
{
  free(font->char_cache);
  free(font->key);
  free(font);
}

int font_compare(const void* a, const void* b, void* udata)
{
	const font_cache* prop_a = (font_cache*) a;
	const font_cache* prop_b = (font_cache*) b;
	return strcmp(prop_a->key, prop_b->key);
}

uint64_t font_hash(const void* item, uint64_t seed0, uint64_t seed1)
{
	font_cache* font = (font_cache*) item;
	return hashmap_sip(font->key, strlen(font->key), seed0, seed1);
}

void texture_free(texture_cache* texture)
{
  free(texture->key);
  free(texture);
}

int texture_compare(const void* a, const void* b, void* udata)
{
	const texture_cache* prop_a = (texture_cache*) a;
	const texture_cache* prop_b = (texture_cache*) b;
	return strcmp(prop_a->key, prop_b->key);
}

uint64_t texture_hash(const void* item, uint64_t seed0, uint64_t seed1)
{
	texture_cache* texture = (texture_cache*) item;
	return hashmap_sip(texture->key, strlen(texture->key), seed0, seed1);
}

void shader_free(shader_cache* shader)
{
  free(shader->key);
  free(shader);
}

int shader_compare(const void* a, const void* b, void* udata)
{
	const shader_cache* prop_a = (shader_cache*) a;
	const shader_cache* prop_b = (shader_cache*) b;
	return strcmp(prop_a->key, prop_b->key);
}

uint64_t shader_hash(const void* item, uint64_t seed0, uint64_t seed1)
{
	shader_cache* shader = (shader_cache*) item;
	return hashmap_sip(shader->key, strlen(shader->key), seed0, seed1);
}

bool inside_scissor(double x, double y, double h)
{
  if (active_scissor[2] == 0.0) return true;
  return y + h >= active_scissor[1] && y <= active_scissor[1] + active_scissor[3];
}

/**
 * Start callbacks
 */
void on_load_font(char* key, char* path, int size)
{
  Font font = LoadFontEx(path, size, NULL, 0);
  GenTextureMipmaps(&(font.texture));
  SetTextureFilter(font.texture, TEXTURE_FILTER_BILINEAR);
  struct hashmap* measured = hashmap_new(sizeof(measure_cache), 0, 0, 0, char_cache_hash, char_cache_compare, NULL, free);

  for (int i=0; i<122; i++)
  {
    float w;
    char letter = default_chars[i];
    char str[2];
    sprintf(str, "%c", letter);
    int bcount;
    int cp = GetCodepoint(str, &bcount);
    GlyphInfo info = GetGlyphInfo(font, cp);
    if (info.advanceX > 0)
    {
      w = info.advanceX;
    }
    else
    {
      w = info.image.width + info.offsetX;
    }

    hashmap_set(measured, &(measure_cache){ .letter=letter, .width=w});
  }

  hashmap_set(fonts, &(font_cache){ .key=strdup(key), .payload=font, .char_cache=measured});
}

void on_activate_font(char* key)
{
  font_cache* cached = hashmap_get(fonts, &(font_cache){ .key=key });
  if (cached == NULL)
  {
    perror("no font with that name available");
    exit(1);
  }

  if (active_font_key != NULL)
  {
    free(active_font_key);
  }

  active_font = cached->payload;
  active_font_key = strdup(key);
}

float on_measure_text(char* text, int text_size, int size)
{
  if (active_font_key == NULL)
  {
    return 0.0f;
  }
  else
  {
    float total_width = 0.0f;
    font_cache* cached = hashmap_get(fonts, &(font_cache){ .key=active_font_key });
    for (int i=0; i<text_size; i++)
    {
      char letter = text[i];
      measure_cache* measured = hashmap_get(cached->char_cache, &(measure_cache){ .letter=letter });
      if (measured == NULL)
      {
        // measure manually
        char t[2] = {letter, '\0'};
        Vector2 vec2 = MeasureTextEx(active_font, t, (float) size, 1.0);
        total_width += vec2.x;
      }
      else
      {
        // use cache
        float w = measured->width;
        total_width += ((float)size / (float)active_font.baseSize) * w + 1.0;
      }
    }

    return total_width;
  }
}

void on_draw_rect(hokusai_native_rect_command* command)
{
  if (!inside_scissor(command->x, command->y, command->height)) return;
  Color color = (Color){ .r=command->color->red, .g=command->color->green, .b=command->color->blue, .a=command->color->alpha };
  DrawRectangle(command->x, command->y, command->width, command->height, color);
}

void on_draw_circle(hokusai_native_circle_command* command)
{
  if (!inside_scissor(command->x, command->y, command->radius)) return;
  Color color = (Color){ .r=command->color->red, .g=command->color->green, .b=command->color->blue, .a=command->color->alpha };
  DrawCircleV((Vector2){command->x, command->y}, command->radius, color);
}

static bool activeTexture = false;
static bool usingTexture = false;
static RenderTexture2D target;

void on_draw_text(hokusai_native_text_command* command)
{
  if (!inside_scissor(command->x, command->y, command->size)){
    return;
  }
  // if (usingTexture){
  //   return;
  // }

  // if (!activeTexture)
  // {
  //   target = LoadRenderTexture(screenWidth, screenHeight);
  //   BeginTextureMode(target);
  //   activeTexture = true;
  // }

  Color color = (Color){ .r=command->color->red, .g=command->color->green, .b=command->color->blue, .a=command->color->alpha };
  DrawTextEx(active_font, command->content, (Vector2){ command->x, command->y }, command->size, 1.0, color);
}

void on_draw_scissor_begin(hokusai_native_scissor_begin_command* command)
{
  active_scissor[0] = command->x;
  active_scissor[1] = command->y;
  active_scissor[2] = command->width;
  active_scissor[3] = command->height;
  BeginScissorMode(command->x, command->y, command->width, command->height);
}

void on_draw_scissor_end(void)
{
  // if (activeTexture)
  // {
  //   EndTextureMode();
  //   usingTexture = true;
  // }

  // if (usingTexture)
  // {
  //   Rectangle src = {0, 0, target.texture.width, -target.texture.height};
  //   BeginBlendMode(BLEND_ADD_COLORS);
  //   DrawTextureRec(target.texture,src, (Vector2){0, 0}, WHITE);
  //   EndBlendMode();
  // }

  active_scissor[0] = 0.0;
  active_scissor[1] = 0.0;
  active_scissor[2] = 0.0;
  active_scissor[3] = 0.0;
  EndScissorMode();
}

void on_draw_shader_begin(hokusai_native_shader_begin_command* command)
{
  Shader shad;
  int len = 0;
  char* fs = "";
  char* vs = "";
  if (command->fragment_shader) 
  {
    fs = command->fragment_shader;
    len += strlen(command->fragment_shader);
  }

  if (command->vertex_shader) 
  {
    vs = command->vertex_shader;
    len += strlen(command->vertex_shader);
  }

  char hash[len + 20];
  sprintf(hash, "%s-%s", fs, vs);
  const shader_cache* result = hashmap_get(shaders, &(shader_cache){ .key=hash });
  if (result == NULL)
  {
    Shader shader = LoadShaderFromMemory(command->vertex_shader, command->fragment_shader);
    hashmap_set(shaders, &(shader_cache){ .key=strdup(hash), .payload=shader});
    shad = shader;
  }
  else
  {
    shad = result->payload;
  }

  for (int i=0; i<command->uniforms_size; i++)
  {
    hokusai_native_shader_uniform uniform = command->uniforms[i];
    int loc = GetShaderLocation(shad, uniform.key);
    if (uniform.type < 4) 
    {
      float yo[uniform.dvalue_size];
      for (int d=0; d<uniform.dvalue_size; d++) {
        yo[d] = (float)uniform.dvalue[d];
      }
      SetShaderValue(shad, loc, yo, uniform.type);
    }
    else
    {
      SetShaderValue(shad, loc, uniform.ivalue, uniform.type);
    }
  }

  BeginShaderMode(shad);
}

void on_draw_shader_end()
{
  EndShaderMode(); 
}

void on_draw_image(hokusai_native_image_command* command)
{
  if (!inside_scissor(command->x, command->y, command->height)) return;
  Texture tex;
  int len = strlen(command->source) + 100; 
  char hash[len];
  sprintf(hash, "%s-%.2f-%.2f", command->source, command->width, command->height);
  const texture_cache* result = hashmap_get(textures, &(texture_cache){ .key=hash });
  if (result == NULL)
  {
    Image img = LoadImage(command->source);
    ImageResize(&img, command->width, command->height);
    Texture texture = LoadTextureFromImage(img);
    UnloadImage(img);
    GenTextureMipmaps(&texture);
    hashmap_set(textures, &(texture_cache){ .key=strdup(hash), .payload=texture});
    tex = texture;
  }
  else
  {
    tex = result->payload;
  }
  
  DrawTexture(tex, command->x, command->y, WHITE);
}

static int keys[110] = {
  0, 39, 44, 45, 46, 47, 48,
  49, 50, 51, 52, 53, 54, 55, 56, 57, 59, 61,
  65, 66, 67, 68, 69, 70, 71, 72, 73,
  74, 75, 76, 77, 78, 79, 80, 81,
  82, 83, 84, 85, 86, 87, 88, 89, 90, 91,
  92, 93, 96, 32, 256, 257, 258, 259,
  260, 261, 262, 263, 264, 265, 266,
  267, 268, 269, 280, 281, 282, 283, 284,
  290, 291, 292, 293, 294, 295, 296, 297,
  298, 299, 300, 301, 340, 341, 342, 343,
  344, 345, 346, 347, 348, 320, 321, 322, 323,
  324, 325, 326, 327, 328, 329, 330, 331,
  332, 333, 334, 335, 336, 4, 5, 24, 25
};

void process_input(long long int isolate)
{
  hokusai_native_input input;
  for (int i=0; i<110; i++)
  {
    input.keys[i] = (hokusai_native_key){.key=i, .down=IsKeyPressed(keys[i]) };
  }

  input.left = &(hokusai_native_mouse){.clicked = IsMouseButtonPressed(0), .down=IsMouseButtonDown(0), .released=IsMouseButtonReleased(0), .up=IsMouseButtonUp(0) };
  input.middle = &(hokusai_native_mouse){.clicked = IsMouseButtonPressed(1), .down=IsMouseButtonDown(1), .released=IsMouseButtonReleased(1), .up=IsMouseButtonUp(1) };
  input.right = &(hokusai_native_mouse){.clicked = IsMouseButtonPressed(2), .down=IsMouseButtonDown(2), .released=IsMouseButtonReleased(2), .up=IsMouseButtonUp(2) };
  input.mouse_x = GetMouseX();
  input.mouse_y = GetMouseY();
  Vector2 delta = GetMouseDelta();
  input.delta_x = delta.x;
  input.delta_y = delta.y;
  input.scroll = GetMouseWheelMove();

  processInput(isolate, &input);
}

static char* fslurp(FILE *fp)
{
  char* source =  NULL;
  if (fp != NULL) {
    /* Go to the end of the file. */
    if (fseek(fp, 0L, SEEK_END) == 0) {
        /* Get the size of the file. */
        long bufsize = ftell(fp);
        if (bufsize == -1) { /* Error */ }

        /* Allocate our buffer to that size. */
        source = malloc(sizeof(char) * (bufsize + 1));

        /* Go back to the start of the file. */
        if (fseek(fp, 0L, SEEK_SET) != 0) { /* Error */ }

        /* Read the entire file into memory. */
        size_t newLen = fread(source, sizeof(char), bufsize, fp);
        if (newLen == 0) {
            fputs("Error reading file", stderr);
        } else {
            source[newLen] = '\0'; /* Just to be safe. */
        }
    }
    fclose(fp);
  }

  return source;
}

int main(int argc, char* argv[])
{
  graal_isolatethread_t* isolate = createIsolate();

  char* filename = argv[1];
  FILE* fp = fopen(filename, "r");
  const char* buffer = fslurp(fp);
  screenWidth = 800;
  screenHeight = 450;

  textures = hashmap_new(sizeof(texture_cache), 0, 0, 0, texture_hash, texture_compare, NULL, texture_free);
  shaders = hashmap_new(sizeof(shader_cache), 0, 0, 0, shader_hash, shader_compare, NULL, shader_free);
  fonts = hashmap_new(sizeof(font_cache), 0, 0, 0, font_hash, font_compare, NULL, font_free);
  InitWindow(screenWidth, screenHeight, "Test");
  SetWindowState(FLAG_WINDOW_RESIZABLE);
  SetTargetFPS(60);

  onFontLoad((long long int)isolate, &on_load_font);
  onFontActivate((long long int)isolate, &on_activate_font);
  onFontMeasure((long long int)isolate, &on_measure_text);
  init((long long int)isolate, buffer);
  onDrawRect((long long int)isolate, &on_draw_rect);
  onDrawCircle((long long int)isolate, &on_draw_circle);
  onDrawText((long long int)isolate, &on_draw_text);
  onDrawScissorBegin((long long int)isolate, &on_draw_scissor_begin);
  onDrawScissorEnd((long long int) isolate, &on_draw_scissor_end);
  onDrawShaderBegin((long long int)isolate, &on_draw_shader_begin);
  onDrawShaderEnd((long long int)isolate, &on_draw_shader_end);
  onDrawImage((long long int)isolate, &on_draw_image);

  while (!WindowShouldClose())
  {
    process_input((long long int)isolate);
    BeginDrawing();
      if (IsWindowFocused())
      {
        DisableEventWaiting();
      }
      else
      {
        EnableEventWaiting();
      }

      screenWidth = GetScreenWidth();
      screenHeight = GetScreenHeight();

      ClearBackground(WHITE);
      update((long long int)isolate);
      render((long long int)isolate, (float)screenWidth, (float)screenHeight);
      DrawFPS(10, 10);
    EndDrawing();
  }

  free((void*)buffer);
  hashmap_free(textures);
  CloseWindow();
  return 0;
}

#endif