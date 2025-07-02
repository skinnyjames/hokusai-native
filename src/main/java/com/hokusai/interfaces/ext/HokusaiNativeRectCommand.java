package com.hokusai.interfaces.ext;

import org.graalvm.word.PointerBase;
import org.graalvm.nativeimage.c.CContext;
import org.graalvm.nativeimage.c.struct.CStruct;
import org.graalvm.nativeimage.c.struct.CField;

@CContext(HokusaiHeaderDirectives.class)
@CStruct("hokusai_native_rect_command")
public interface HokusaiNativeRectCommand extends PointerBase {
  @CField("x") double x();
  @CField("x") void x(double x);
  @CField("y") double y();
  @CField("y") void y(double y);
  @CField("width") double width();
  @CField("width") void width(double width);
  @CField("height") double height();
  @CField("height") void height(double height);
  @CField("rounding") double rounding();
  @CField("rounding") void rounding(double height);
  @CField("color") HokusaiNativeColor color();
  @CField("color") void color(HokusaiNativeColor color);
  @CField("outline") HokusaiNativeBoundary outline();
  @CField("outline") void outline(HokusaiNativeBoundary color);
  @CField("outline_color") HokusaiNativeColor outline_color();
  @CField("outline_color") void outline_color(HokusaiNativeColor color);
  @CField("padding") HokusaiNativeBoundary padding();
  @CField("padding") void padding(HokusaiNativeBoundary color);
}