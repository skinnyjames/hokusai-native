package com.hokusai.interfaces.ext;

import org.graalvm.nativeimage.c.function.CFunctionPointer;
import org.graalvm.nativeimage.c.function.InvokeCFunctionPointer;
import org.graalvm.nativeimage.c.type.VoidPointer;

public interface HokusaiNativeRectCommandCallback extends CFunctionPointer {
    @InvokeCFunctionPointer
    VoidPointer call(HokusaiNativeRectCommand command);
}