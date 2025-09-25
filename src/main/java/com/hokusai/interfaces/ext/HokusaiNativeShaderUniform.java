package com.hokusai.interfaces.ext;

import org.graalvm.word.PointerBase;
import org.graalvm.nativeimage.c.CContext;
import org.graalvm.nativeimage.c.struct.CStruct;
import org.graalvm.nativeimage.c.struct.CField;
import org.graalvm.nativeimage.c.type.CIntPointer;
import org.graalvm.nativeimage.c.type.CDoublePointer;
import org.graalvm.nativeimage.c.type.CCharPointer;
import org.graalvm.nativeimage.c.type.VoidPointer;

import org.graalvm.nativeimage.c.struct.CFieldAddress;


@CContext(HokusaiHeaderDirectives.class)
@CStruct("hokusai_native_shader_uniform")
public interface HokusaiNativeShaderUniform extends PointerBase {  
  HokusaiNativeShaderUniform addressOf(int index);

  @CField("key") CCharPointer key();
  @CField("key") void key(CCharPointer content);
  
  @CField("type") int type();
  @CField("type") void type(int type);

  @CField("dvalue") CDoublePointer dvalue();
  @CField("dvalue") void dvalue(CDoublePointer value);
  @CField("dvalue_size") int dvalue_size();
  @CField("dvalue_size") void dvalue_size(int size);

  @CField("ivalue") CIntPointer ivalue();
  @CField("ivalue") void ivalue(CIntPointer value);
  @CField("ivalue_size") int ivalue_size();
  @CField("ivalue_size") void ivalue_size(int size);
}