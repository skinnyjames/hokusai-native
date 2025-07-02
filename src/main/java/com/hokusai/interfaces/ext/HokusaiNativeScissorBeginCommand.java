package com.hokusai.interfaces.ext;

import org.graalvm.word.PointerBase;
import org.graalvm.nativeimage.c.CContext;
import org.graalvm.nativeimage.c.struct.CStruct;
import org.graalvm.nativeimage.c.struct.CField;

@CContext(HokusaiHeaderDirectives.class)
@CStruct("hokusai_native_scissor_begin_command")
public interface HokusaiNativeScissorBeginCommand extends PointerBase {
  @CField("x") double x();
  @CField("x") void x(double x);
  @CField("y") double y();
  @CField("y") void y(double y);
  @CField("width") double width();
  @CField("width") void width(double width);
  @CField("height") double height();
  @CField("height") void height(double height);
}