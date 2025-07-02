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

typedef void (HokusaiNativeRectCommandCallback)(struct HokusaiNativeRectCommand* command);
typedef void (HokusaiNativeCircleCommandCallback)(struct HokusaiNativeCircleCommand* command);
typedef void (HokusaiNativeImageCommandCallback)(struct HokusaiNativeImageCommand* command);
typedef void (HokusaiNativeTextCommandCallback)(struct HokusaiNativeTextCommand* command);
typedef void (HokusaiNativeScissorBeginCommandCallback)(struct HokusaiNativeScissorBeginCommand* command);
typedef void (HokusaiNativeScissorEndCommandCallback)(void);

#endif