package com.hokusai.interfaces.ext;

import org.graalvm.nativeimage.c.function.CFunctionPointer;
import org.graalvm.nativeimage.c.function.InvokeCFunctionPointer;

public interface HokusaiNativeRectCommandCallback extends CFunctionPointer {
    @InvokeCFunctionPointer
    Void call(HokusaiNativeRectCommand command);
}