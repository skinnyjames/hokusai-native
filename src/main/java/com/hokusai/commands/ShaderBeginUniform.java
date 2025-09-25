package com.hokusai.commands;

import org.graalvm.polyglot.Value;
import com.hokusai.interfaces.*;

public class ShaderBeginUniform {
  public String key;
  public Integer type;
  public Object value;

  public ShaderBeginUniform(String key, Integer type, Object value) {
    this.key = key;
    this.type = type;
    this.value = value;
  }
}