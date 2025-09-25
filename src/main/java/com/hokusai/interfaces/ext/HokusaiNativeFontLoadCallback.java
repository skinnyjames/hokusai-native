package com.hokusai.interfaces.ext;

import org.graalvm.word.PointerBase;
import org.graalvm.nativeimage.c.function.CFunctionPointer;
import org.graalvm.nativeimage.c.function.InvokeCFunctionPointer;
import org.graalvm.nativeimage.c.type.CCharPointer;
import org.graalvm.nativeimage.c.type.VoidPointer;

public interface HokusaiNativeFontLoadCallback extends CFunctionPointer {
    @InvokeCFunctionPointer
    VoidPointer call(CCharPointer name, CCharPointer path, int size);
}