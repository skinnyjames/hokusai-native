package com.hokusai.interfaces.ext;

import org.graalvm.word.PointerBase;
import org.graalvm.nativeimage.c.CContext;
import org.graalvm.nativeimage.c.struct.CStruct;
import org.graalvm.nativeimage.c.struct.CField;

@CContext(HokusaiHeaderDirectives.class)
@CStruct(value = "hokusai_native_boundary")
public interface HokusaiNativeBoundary extends PointerBase {
    @CField("top") double top();
    @CField("top") void top(double top);
    @CField("right") double right();
    @CField("right") void right(double right);
    @CField("bottom") double bottom();
    @CField("bottom") void bottom(double bottom);
    @CField("left") double left();
    @CField("left") void left(double left);
}