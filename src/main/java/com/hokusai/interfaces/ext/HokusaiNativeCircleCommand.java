package com.hokusai.interfaces.ext;

import org.graalvm.word.PointerBase;
import org.graalvm.nativeimage.c.CContext;
import org.graalvm.nativeimage.c.struct.CStruct;
import org.graalvm.nativeimage.c.struct.CField;

@CContext(HokusaiHeaderDirectives.class)
@CStruct(value = "hokusai_native_circle_command")
public interface HokusaiNativeCircleCommand extends PointerBase {
    @CField("x") double x();
    @CField("x") void x(double x);
    @CField("y") double y();
    @CField("y") void y(double y);
    @CField("radius") double radius();
    @CField("radius") void radius(double radius);
    @CField("color") HokusaiNativeColor color();
    @CField("color") void color(HokusaiNativeColor color);
    @CField("outline_color") HokusaiNativeColor outline_color();
    @CField("outline_color") void outline_color(HokusaiNativeColor color);
    @CField("outline") double outline();
    @CField("outline") void outline(double outline);
}
