#include <stdio.h>
#include <stddef.h>
#include <memory.h>

#include </Users/skinnyjames/repo/wip/hokusai-native-builder/hokusai-native-build/project/include/hokusai-native-ext.h>

int HokusaiHeaderDirectives() {
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_boundary:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(hokusai_native_boundary)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_boundary:StructFieldInfo:bottom:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_boundary *) 0)->bottom)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_boundary:StructFieldInfo:bottom:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_boundary, bottom)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_boundary:StructFieldInfo:left:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_boundary *) 0)->left)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_boundary:StructFieldInfo:left:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_boundary, left)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_boundary:StructFieldInfo:right:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_boundary *) 0)->right)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_boundary:StructFieldInfo:right:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_boundary, right)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_boundary:StructFieldInfo:top:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_boundary *) 0)->top)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_boundary:StructFieldInfo:top:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_boundary, top)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_circle_command:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(hokusai_native_circle_command)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_circle_command:StructFieldInfo:color:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_circle_command *) 0)->color)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_circle_command:StructFieldInfo:color:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_circle_command, color)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_circle_command:StructFieldInfo:outline:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_circle_command *) 0)->outline)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_circle_command:StructFieldInfo:outline:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_circle_command, outline)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_circle_command:StructFieldInfo:outline_color:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_circle_command *) 0)->outline_color)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_circle_command:StructFieldInfo:outline_color:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_circle_command, outline_color)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_circle_command:StructFieldInfo:radius:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_circle_command *) 0)->radius)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_circle_command:StructFieldInfo:radius:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_circle_command, radius)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_circle_command:StructFieldInfo:x:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_circle_command *) 0)->x)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_circle_command:StructFieldInfo:x:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_circle_command, x)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_circle_command:StructFieldInfo:y:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_circle_command *) 0)->y)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_circle_command:StructFieldInfo:y:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_circle_command, y)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_color:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(hokusai_native_color)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_color:StructFieldInfo:alpha:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_color *) 0)->alpha)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_color:StructFieldInfo:alpha:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_color, alpha)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        hokusai_native_color fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.alpha = all_bits_set;
        is_unsigned = fieldHolder.alpha > 0;
        printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_color:StructFieldInfo:alpha:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_color:StructFieldInfo:blue:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_color *) 0)->blue)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_color:StructFieldInfo:blue:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_color, blue)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        hokusai_native_color fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.blue = all_bits_set;
        is_unsigned = fieldHolder.blue > 0;
        printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_color:StructFieldInfo:blue:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_color:StructFieldInfo:green:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_color *) 0)->green)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_color:StructFieldInfo:green:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_color, green)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        hokusai_native_color fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.green = all_bits_set;
        is_unsigned = fieldHolder.green > 0;
        printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_color:StructFieldInfo:green:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_color:StructFieldInfo:red:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_color *) 0)->red)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_color:StructFieldInfo:red:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_color, red)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        hokusai_native_color fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.red = all_bits_set;
        is_unsigned = fieldHolder.red > 0;
        printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_color:StructFieldInfo:red:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_image_command:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(hokusai_native_image_command)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_image_command:StructFieldInfo:height:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_image_command *) 0)->height)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_image_command:StructFieldInfo:height:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_image_command, height)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_image_command:StructFieldInfo:source:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_image_command *) 0)->source)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_image_command:StructFieldInfo:source:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_image_command, source)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_image_command:StructFieldInfo:width:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_image_command *) 0)->width)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_image_command:StructFieldInfo:width:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_image_command, width)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_image_command:StructFieldInfo:x:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_image_command *) 0)->x)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_image_command:StructFieldInfo:x:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_image_command, x)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_image_command:StructFieldInfo:y:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_image_command *) 0)->y)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_image_command:StructFieldInfo:y:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_image_command, y)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_rect_command:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(hokusai_native_rect_command)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_rect_command:StructFieldInfo:color:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_rect_command *) 0)->color)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_rect_command:StructFieldInfo:color:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_rect_command, color)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_rect_command:StructFieldInfo:height:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_rect_command *) 0)->height)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_rect_command:StructFieldInfo:height:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_rect_command, height)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_rect_command:StructFieldInfo:outline:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_rect_command *) 0)->outline)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_rect_command:StructFieldInfo:outline:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_rect_command, outline)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_rect_command:StructFieldInfo:outline_color:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_rect_command *) 0)->outline_color)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_rect_command:StructFieldInfo:outline_color:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_rect_command, outline_color)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_rect_command:StructFieldInfo:padding:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_rect_command *) 0)->padding)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_rect_command:StructFieldInfo:padding:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_rect_command, padding)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_rect_command:StructFieldInfo:rounding:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_rect_command *) 0)->rounding)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_rect_command:StructFieldInfo:rounding:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_rect_command, rounding)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_rect_command:StructFieldInfo:width:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_rect_command *) 0)->width)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_rect_command:StructFieldInfo:width:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_rect_command, width)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_rect_command:StructFieldInfo:x:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_rect_command *) 0)->x)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_rect_command:StructFieldInfo:x:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_rect_command, x)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_rect_command:StructFieldInfo:y:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_rect_command *) 0)->y)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_rect_command:StructFieldInfo:y:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_rect_command, y)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_scissor_begin_command:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(hokusai_native_scissor_begin_command)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_scissor_begin_command:StructFieldInfo:height:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_scissor_begin_command *) 0)->height)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_scissor_begin_command:StructFieldInfo:height:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_scissor_begin_command, height)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_scissor_begin_command:StructFieldInfo:width:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_scissor_begin_command *) 0)->width)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_scissor_begin_command:StructFieldInfo:width:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_scissor_begin_command, width)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_scissor_begin_command:StructFieldInfo:x:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_scissor_begin_command *) 0)->x)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_scissor_begin_command:StructFieldInfo:x:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_scissor_begin_command, x)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_scissor_begin_command:StructFieldInfo:y:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_scissor_begin_command *) 0)->y)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_scissor_begin_command:StructFieldInfo:y:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_scissor_begin_command, y)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_text_command:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(hokusai_native_text_command)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_text_command:StructFieldInfo:bold:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_text_command *) 0)->bold)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_text_command:StructFieldInfo:bold:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_text_command, bold)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        hokusai_native_text_command fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.bold = all_bits_set;
        is_unsigned = fieldHolder.bold > 0;
        printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_text_command:StructFieldInfo:bold:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_text_command:StructFieldInfo:color:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_text_command *) 0)->color)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_text_command:StructFieldInfo:color:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_text_command, color)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_text_command:StructFieldInfo:content:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_text_command *) 0)->content)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_text_command:StructFieldInfo:content:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_text_command, content)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_text_command:StructFieldInfo:italic:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_text_command *) 0)->italic)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_text_command:StructFieldInfo:italic:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_text_command, italic)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        hokusai_native_text_command fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.italic = all_bits_set;
        is_unsigned = fieldHolder.italic > 0;
        printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_text_command:StructFieldInfo:italic:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_text_command:StructFieldInfo:padding:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_text_command *) 0)->padding)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_text_command:StructFieldInfo:padding:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_text_command, padding)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_text_command:StructFieldInfo:size:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_text_command *) 0)->size)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_text_command:StructFieldInfo:size:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_text_command, size)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        hokusai_native_text_command fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.size = all_bits_set;
        is_unsigned = fieldHolder.size > 0;
        printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_text_command:StructFieldInfo:size:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_text_command:StructFieldInfo:x:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_text_command *) 0)->x)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_text_command:StructFieldInfo:x:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_text_command, x)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_text_command:StructFieldInfo:y:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((hokusai_native_text_command *) 0)->y)));
    printf("NativeCodeInfo:HokusaiHeaderDirectives:StructInfo:hokusai_native_text_command:StructFieldInfo:y:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(hokusai_native_text_command, y)));
    return 0;
}

int main(void) {
    return HokusaiHeaderDirectives();
}
