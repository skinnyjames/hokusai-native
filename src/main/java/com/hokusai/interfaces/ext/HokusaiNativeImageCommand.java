package com.hokusai.interfaces.ext;

import org.graalvm.word.PointerBase;
import org.graalvm.nativeimage.c.CContext;
import org.graalvm.nativeimage.c.struct.CStruct;
import org.graalvm.nativeimage.c.struct.CField;
import org.graalvm.nativeimage.c.type.CCharPointer;

@CContext(HokusaiHeaderDirectives.class)
@CStruct(value = "hokusai_native_image_command")
public interface HokusaiNativeImageCommand extends PointerBase {
  @CField("x") double x();
  @CField("x") void x(double x);
  @CField("y") double y();
  @CField("y") void y(double y);
  @CField("width") double width();
  @CField("width") void width(double width);
  @CField("height") double height();
  @CField("height") void height(double height);
  @CField("source") CCharPointer source();
  @CField("source") void source(CCharPointer content);
}
