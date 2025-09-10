package com.hokusai.commands;

import org.graalvm.polyglot.Value;
import com.hokusai.interfaces.*;

public class ShaderEndCommandWrapper extends CommandWrapper {
  Value raw;

  public ShaderEndCommandWrapper(Value raw) {
    this.raw = raw;
  }
}