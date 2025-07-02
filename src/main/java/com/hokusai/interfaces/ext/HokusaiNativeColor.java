package com.hokusai.interfaces.ext;

import org.graalvm.word.PointerBase;
import org.graalvm.nativeimage.c.CContext;
import org.graalvm.nativeimage.c.struct.CStruct;
import org.graalvm.nativeimage.c.struct.CField;
import org.graalvm.nativeimage.c.struct.AllowNarrowingCast;
import org.graalvm.nativeimage.c.struct.AllowWideningCast;
import org.graalvm.nativeimage.c.struct.AllowNarrowingCast;
import org.graalvm.nativeimage.c.struct.AllowWideningCast;

@CContext(HokusaiHeaderDirectives.class)
@CStruct(value = "hokusai_native_color")
public interface HokusaiNativeColor extends PointerBase {
    @CField("red") int red();
    @CField("red") void red(int red);
    @CField("green") int green();
    @CField("green") void green(int green);
    @CField("blue") int blue();
    @CField("blue") void blue(int blue);
    @CField("alpha") int alpha();
    @CField("alpha") void alpha(int alpha);
}