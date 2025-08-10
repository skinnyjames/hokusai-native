#ifndef HOKUSAI_NATIVE_EXT
#define HOKUSAI_NATIVE_EXT

#include <stdbool.h>

typedef struct HokusaiNativeColor {
  int red;
  int green;
  int blue;
  int alpha;
} hokusai_native_color;

typedef struct HokusaiNativeBoundary {
  double top;
  double left;
  double right;
  double bottom;
} hokusai_native_boundary;

typedef struct HokusaiNativeCircleCommand {
  double x;
  double y;
  double radius;
  struct HokusaiNativeColor* color;
  struct HokusaiNativeColor* outline_color;
  double outline;
} hokusai_native_circle_command;

typedef struct HokusaiNativeRectCommand {
  double x;
  double y;
  double width;
  double height;
  double rounding;
  struct HokusaiNativeColor* color;
  struct HokusaiNativeBoundary* outline;
  struct HokusaiNativeColor* outline_color;
  struct HokusaiNativeBoundary* padding;
} hokusai_native_rect_command;

typedef struct HokusaiNativeImageCommand {
  double x;
  double y;
  double width;
  double height;
  char* source;
} hokusai_native_image_command;

typedef struct HokusaiNativeTextCommand {
  double x;
  double y;
  int size;
  bool bold;
  bool italic;
  char* content;
  struct HokusaiNativeColor* color;
  struct HokusaiNativeBoundary* padding;
} hokusai_native_text_command;

typedef struct HokusaiNativeScissorBeginCommand {
  double x;
  double y;
  double width;
  double height;
} hokusai_native_scissor_begin_command;


typedef enum HokusaiNativeKeyType
{
  HN_NULL,  HN_APOSTROPHE,  HN_COMMA,  HN_MINUS,  HN_PERIOD,
  HN_SLASH,  HN_ZERO,  HN_ONE,  HN_TWO,  HN_THREE,  HN_FOUR,
  HN_FIVE,  HN_SIX,  HN_SEVEN,  HN_EIGHT,  HN_NINE,  HN_SEMICOLON,  
  HN_EQUAL,  HN_A,  HN_B,  HN_C,  HN_D,  HN_E,  HN_F,  HN_G,  HN_H,  
  HN_I,  HN_J,  HN_K,  HN_L,  HN_M,  HN_N,  HN_O,  HN_P,  HN_Q,  HN_R,  
  HN_S,  HN_T,  HN_U,  HN_V,  HN_W,  HN_X,  HN_Y,  HN_Z,  HN_LEFT_BRACKET,  
  HN_BACKSLASH,  HN_RIGHT_BRACKET,  HN_GRAVE,  HN_SPACE,  HN_ESCAPE,  
  HN_ENTER,  HN_TAB,  HN_BACKSPACE,  HN_INSERT,  HN_DELETE,  HN_RIGHT,  
  HN_LEFT,  HN_DOWN,  HN_UP,  HN_PAGE_UP,  HN_PAGE_DOWN,  HN_HOME,  HN_END,  
  HN_CAPS_LOCK,  HN_SCROLL_LOCK,  HN_NUM_LOCK,  HN_PRINT_SCREEN,  HN_PAUSE,  
  HN_F1,  HN_F2,  HN_F3,  HN_F4,  HN_F5,  HN_F6,  HN_F7,  HN_F8,  
  HN_F9,  HN_F10,  HN_F11,  HN_F12,  HN_LEFT_SHIFT,  HN_LEFT_CONTROL,  
  HN_LEFT_ALT,  HN_LEFT_SUPER,  HN_RIGHT_SHIFT,  HN_RIGHT_CONTROL,  HN_RIGHT_ALT,  
  HN_RIGHT_SUPER,  HN_KB_MENU,  HN_KP_0,  HN_KP_1,  HN_KP_2,  HN_KP_3,  
  HN_KP_4,  HN_KP_5,  HN_KP_6,  HN_KP_7,  HN_KP_8,  HN_KP_9,  HN_KP_DECIMAL,  
  HN_KP_DIVIDE,  HN_KP_MULTIPLY,  HN_KP_SUBTRACT,  HN_KP_ADD,  HN_KP_ENTER,  
  HN_KP_EQUAL,  HN_BACK,  HN_MENU,  HN_VOLUME_UP,  HN_VOLUME_DOWN, HN_KEY_MAX
} hokusai_native_key_type;

typedef struct HokusaiNativeKey
{
  hokusai_native_key_type key;
  bool down;
} hokusai_native_key;

typedef struct HokusaiNativeMouse {
  bool clicked;
  bool down;
  bool released;
  bool up;
} hokusai_native_mouse;

typedef struct HokusaiNativeInput {
  hokusai_native_mouse left;
  hokusai_native_mouse middle;
  hokusai_native_mouse right;
  double mouse_x;
  double mouse_y;
  double delta_x;
  double delta_y;
  double scroll;
  hokusai_native_key keys[HN_KEY_MAX];
} hokusai_native_input;

typedef void (HokusaiNativeRectCommandCallback)(struct HokusaiNativeRectCommand* command);
typedef void (HokusaiNativeCircleCommandCallback)(struct HokusaiNativeCircleCommand* command);
typedef void (HokusaiNativeImageCommandCallback)(struct HokusaiNativeImageCommand* command);
typedef void (HokusaiNativeTextCommandCallback)(struct HokusaiNativeTextCommand* command);
typedef void (HokusaiNativeScissorBeginCommandCallback)(struct HokusaiNativeScissorBeginCommand* command);
typedef void (HokusaiNativeScissorEndCommandCallback)(void);

#endif