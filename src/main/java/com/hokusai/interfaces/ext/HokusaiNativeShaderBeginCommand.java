package com.hokusai.interfaces.ext;

import org.graalvm.word.PointerBase;
import org.graalvm.nativeimage.c.CContext;
import org.graalvm.nativeimage.c.struct.CStruct;
import org.graalvm.nativeimage.c.struct.CField;
import org.graalvm.nativeimage.c.type.CCharPointer;
import org.graalvm.nativeimage.c.struct.CFieldAddress;

@CContext(HokusaiHeaderDirectives.class)
@CStruct("hokusai_native_shader_begin_command")
public interface HokusaiNativeShaderBeginCommand extends PointerBase {
  @CField("fragment_shader") CCharPointer fragment_shader();
  @CField("fragment_shader") void fragment_shader(CCharPointer content);
  @CField("vertex_shader") CCharPointer vertex_shader();
  @CField("vertex_shader") void vertex_shader(CCharPointer content);
  @CField("uniforms") HokusaiNativeShaderUniform uniforms();
  @CField("uniforms") void uniforms(HokusaiNativeShaderUniform uniforms);
  @CField("uniforms_size") int uniforms_size();
  @CField("uniforms_size") void uniforms_size(int value); 
}