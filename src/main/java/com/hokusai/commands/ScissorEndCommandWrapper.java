package com.hokusai.commands;

import org.graalvm.polyglot.Value;
import com.hokusai.interfaces.*;

public class ScissorEndCommandWrapper extends CommandWrapper {
  Value raw;

  public ScissorEndCommandWrapper(Value raw) {
    this.raw = raw;
  }
}