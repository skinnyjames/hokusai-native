package com.hokusai.interfaces.ext;

import org.graalvm.word.PointerBase;
import org.graalvm.nativeimage.c.CContext;
import org.graalvm.nativeimage.c.struct.CStruct;
import org.graalvm.nativeimage.c.struct.CField;

@CContext(HokusaiHeaderDirectives.class)
@CStruct("hokusai_native_key")
public interface HokusaiNativeKey extends PointerBase {
  HokusaiNativeKey addressOf(int index);

  @CField("key") int key();
  @CField("down") boolean down();
}