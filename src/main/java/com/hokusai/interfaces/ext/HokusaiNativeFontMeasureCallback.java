package com.hokusai.interfaces.ext;

import org.graalvm.word.PointerBase;
import org.graalvm.nativeimage.c.function.CFunctionPointer;
import org.graalvm.nativeimage.c.function.InvokeCFunctionPointer;
import org.graalvm.nativeimage.c.type.CCharPointer;
import org.graalvm.nativeimage.c.type.CFloatPointer;

public interface HokusaiNativeFontMeasureCallback extends CFunctionPointer {
    @InvokeCFunctionPointer
    float call(CCharPointer text, int text_size, int font_size);
}