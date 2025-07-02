package com.hokusai.interfaces.ext;

import org.graalvm.word.PointerBase;
import org.graalvm.nativeimage.c.CContext;
import org.graalvm.nativeimage.c.struct.CStruct;
import org.graalvm.nativeimage.c.struct.CField;
import org.graalvm.nativeimage.c.type.CCharPointer;

@CContext(HokusaiHeaderDirectives.class)
@CStruct(value = "hokusai_native_text_command")
public interface HokusaiNativeTextCommand extends PointerBase {
  @CField("x") double x();
  @CField("x") void x(double x);
  @CField("y") double y();
  @CField("y") void y(double y);
  @CField("size") int size();
  @CField("size") void size(int size);
  @CField("bold") boolean bold();
  @CField("bold") void bold(boolean bold);
  @CField("italic") boolean italic();
  @CField("italic") void italic(boolean italic);
  @CField("content") CCharPointer content();
  @CField("content") void content(CCharPointer content);
  @CField("color") HokusaiNativeColor color();
  @CField("color") void color(HokusaiNativeColor color);
  @CField("padding") HokusaiNativeBoundary padding();
  @CField("padding") void padding(HokusaiNativeBoundary color);
}
