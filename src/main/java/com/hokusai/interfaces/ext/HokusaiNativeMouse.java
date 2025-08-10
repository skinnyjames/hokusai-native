package com.hokusai.interfaces.ext;

import org.graalvm.word.PointerBase;
import org.graalvm.nativeimage.c.CContext;
import org.graalvm.nativeimage.c.struct.CStruct;
import org.graalvm.nativeimage.c.struct.CField;

@CContext(HokusaiHeaderDirectives.class)
@CStruct("hokusai_native_mouse")
public interface HokusaiNativeMouse extends PointerBase {
  @CField("clicked") boolean clicked();
  @CField("clicked") void clicked(boolean value);
  @CField("down") boolean down();
  @CField("down") void down(boolean value);
  @CField("released") boolean released();
  @CField("released") void released(boolean value);
  @CField("up") boolean up();
  @CField("up") void up(boolean value);
}