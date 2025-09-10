package com.hokusai.commands;

import org.graalvm.polyglot.Value;
import com.hokusai.interfaces.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class ShaderBeginCommandWrapper extends CommandWrapper {

  Integer SHADER_UNIFORM_FLOAT = 0;
  Integer SHADER_UNIFORM_VEC2 = 1;
  Integer SHADER_UNIFORM_VEC3 = 2;
  Integer SHADER_UNIFORM_VEC4 = 3;
  Integer SHADER_UNIFORM_INT = 4;
  Integer SHADER_UNIFORM_IVEC2 = 5;
  Integer SHADER_UNIFORM_IVEC3 = 6;
  Integer SHADER_UNIFORM_IVEC4 = 7;

  Value raw;
  ArrayList<ShaderBeginUniform> uniforms = new ArrayList<ShaderBeginUniform>();

  public ShaderBeginCommandWrapper(Value raw) {
    this.raw = raw;

    if (!this.raw.as(ShaderBeginCommand.class).uniforms().isNull()) {
      Value uniforms = this.raw.as(ShaderBeginCommand.class).uniforms();
      List<String> keys = uniforms.getMember("keys").execute().as(List.class);
      
      for (String key : keys) {
        Value value = uniforms.getMember("[]").execute(key);
        Value shaderValue = value.getArrayElement(0);
        Integer utype = value.getArrayElement(1).asInt();

        if (utype == SHADER_UNIFORM_FLOAT)
        {
          this.uniforms.add(new ShaderBeginUniform(key, utype, shaderValue.asDouble()));
        }
        else if (utype == SHADER_UNIFORM_VEC2 || utype == SHADER_UNIFORM_VEC3 || utype == SHADER_UNIFORM_VEC4)
        {
          List<Double> values = shaderValue.as(List.class);
          this.uniforms.add(new ShaderBeginUniform(key, utype, values));
        }
        else if (utype == SHADER_UNIFORM_INT)
        {
          this.uniforms.add(new ShaderBeginUniform(key, utype, shaderValue.asInt()));
        }
        else if (utype == SHADER_UNIFORM_IVEC2 || utype == SHADER_UNIFORM_IVEC3 || utype == SHADER_UNIFORM_IVEC4)
        {
          List<Integer> values = shaderValue.as(List.class);
          this.uniforms.add(new ShaderBeginUniform(key, utype, values));
        }
      }
    }
  }

  public String vertexShader() {
    return this.raw.as(ShaderBeginCommand.class).vertex_shader();
  }

  public String fragmentShader() {
    return this.raw.as(ShaderBeginCommand.class).fragment_shader();
  }

  public ArrayList<ShaderBeginUniform> uniforms() {
    return this.uniforms;
  }
}