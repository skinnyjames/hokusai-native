package com.hokusai.interfaces.ext;

import org.graalvm.nativeimage.StackValue;
import com.hokusai.commands.ShaderBeginCommandWrapper;
import com.hokusai.commands.ShaderBeginUniform;
import org.graalvm.nativeimage.c.type.CIntPointer;
import org.graalvm.nativeimage.c.type.CDoublePointer;
import org.graalvm.nativeimage.c.type.VoidPointer;
import org.graalvm.nativeimage.UnmanagedMemory;
import org.graalvm.nativeimage.c.struct.SizeOf;

import org.graalvm.nativeimage.c.type.CTypeConversion;
import java.util.List;
import java.util.ArrayList;

public class HokusaiNativeShaderBeginCommandWrapper {
  HokusaiNativeShaderBeginCommandCallback value;

  public HokusaiNativeShaderBeginCommandWrapper(HokusaiNativeShaderBeginCommandCallback v) {
    this.value = v;
  }

  public void call(ShaderBeginCommandWrapper command) {
    HokusaiNativeShaderBeginCommand nativeCommand = StackValue.get(HokusaiNativeShaderBeginCommand.class);
    nativeCommand.fragment_shader(null);
    nativeCommand.vertex_shader(null);
    nativeCommand.uniforms(null);
    nativeCommand.uniforms_size(0);

    if (command.fragmentShader() != null) {
      final CTypeConversion.CCharPointerHolder fsholder = CTypeConversion.toCString(command.fragmentShader());
      nativeCommand.fragment_shader(fsholder.get());
    }

    if (command.vertexShader() != null) {
      final CTypeConversion.CCharPointerHolder vsholder = CTypeConversion.toCString(command.vertexShader());
      nativeCommand.vertex_shader(vsholder.get());
    }

    Integer size = command.uniforms().size();
    Integer i = 0;
    int asize = SizeOf.get(HokusaiNativeShaderUniform.class) * size;
    HokusaiNativeShaderUniform nativeUniforms = UnmanagedMemory.malloc(asize);

    for (ShaderBeginUniform uniform : command.uniforms()) {
      final CTypeConversion.CCharPointerHolder ukeyholder = CTypeConversion.toCString(uniform.key);
      nativeUniforms.addressOf(i).key(ukeyholder.get());
      nativeUniforms.addressOf(i).type(uniform.type);
      // SHADER_UNIFORM_FLOAT,
      // SHADER_UNIFORM_VEC2,
      // SHADER_UNIFORM_VEC3,
      // SHADER_UNIFORM_VEC4,
      // SHADER_UNIFORM_INT,
      // SHADER_UNIFORM_IVEC2,
      // SHADER_UNIFORM_IVEC3,
      // SHADER_UNIFORM_IVEC4;
      if (uniform.type < 4) {
        if (uniform.type == 0) {
          int usize = SizeOf.get(CDoublePointer.class);
          CDoublePointer cvalue = UnmanagedMemory.malloc(usize);//StackValue.get(1, CDoublePointer.class);
          cvalue.addressOf(0).write(Double.class.cast(uniform.value));
          nativeUniforms.addressOf(i).dvalue(cvalue);
          nativeUniforms.addressOf(i).dvalue_size(1);
        }
        else 
        {
          List<Double> values = List.class.cast(uniform.value);
          int usize = SizeOf.get(CDoublePointer.class) * values.size();
          CDoublePointer cvalues = UnmanagedMemory.malloc(usize);
          Integer vi = 0;
          for (Double value : values) {
            cvalues.addressOf(vi).write(value);
            vi += 1;
          }
          nativeUniforms.addressOf(i).dvalue(cvalues);
          nativeUniforms.addressOf(i).dvalue_size(vi);
        }

        nativeUniforms.addressOf(i).ivalue_size(0);
      }
      else
      {
        // integer types
        if (uniform.type == 4)
        {
          int usize = SizeOf.get(CIntPointer.class);
          CIntPointer cvalue = UnmanagedMemory.malloc(usize);
          cvalue.addressOf(0).write(Integer.class.cast(uniform.value));
          nativeUniforms.addressOf(i).ivalue(cvalue);
          nativeUniforms.addressOf(i).ivalue_size(1);
        }
        else
        {
          List<Integer> values = List.class.cast(uniform.value);
          int usize = SizeOf.get(CIntPointer.class) * values.size();
          CIntPointer cvalues = UnmanagedMemory.malloc(usize);
          Integer vi = 0;
          for (Integer value : values) {
            cvalues.addressOf(vi).write(value);
            vi += 1;
          }
          nativeUniforms.addressOf(i).ivalue(cvalues);
          nativeUniforms.addressOf(i).ivalue_size(vi);
        }
        nativeUniforms.addressOf(i).dvalue_size(0);
      }

      nativeCommand.uniforms_size(size);
      nativeCommand.uniforms(nativeUniforms);
      
      i += 1;
    }

    this.value.call(nativeCommand);

    for (int a = 0; a < i; a++) {
      if (nativeUniforms.addressOf(a).ivalue_size() > 0) {
        UnmanagedMemory.free(nativeUniforms.addressOf(a).ivalue());
      }

      if (nativeUniforms.addressOf(a).dvalue_size() > 0) {
        UnmanagedMemory.free(nativeUniforms.addressOf(a).dvalue());
      }
    }

    UnmanagedMemory.free(nativeUniforms);
  }
}