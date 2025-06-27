package com.hokusai.commands;

import org.graalvm.polyglot.Value;
import com.hokusai.interfaces.*;

public class ScissorEndCommandWrapper {
  Value raw;

  public ScissorEndCommandWrapper(Value raw) {
    this.raw = raw;
  }
}