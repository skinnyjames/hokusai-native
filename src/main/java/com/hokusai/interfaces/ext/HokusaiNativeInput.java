package com.hokusai.interfaces.ext;

import org.graalvm.word.PointerBase;
import org.graalvm.nativeimage.c.CContext;
import org.graalvm.nativeimage.c.struct.CStruct;
import org.graalvm.nativeimage.c.struct.CField;

@CContext(HokusaiHeaderDirectives.class)
@CStruct("hokusai_native_input")
public interface HokusaiNativeInput extends PointerBase {
  @CField("left") HokusaiNativeMouse left();
  @CField("middle") HokusaiNativeMouse middle();
  @CField("right") HokusaiNativeMouse right();
  @CField("mouse_x") double mouse_x();
  @CField("mouse_y") double mouse_y();
  @CField("delta_x") double delta_x();
  @CField("delta_y") double delta_y();
  @CField("scroll") double scroll();
  @CFieldAddress("keys") HokusaiNativeKey addressOfKey();
}