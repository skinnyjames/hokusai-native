package com.hokusai.commands;

import org.graalvm.polyglot.Value;
import com.hokusai.interfaces.*;

public class ScissorBeginCommandWrapper extends CommandWrapper {
  Value raw;

  public ScissorBeginCommandWrapper(Value raw) {
    this.raw = raw;
  }
  
  public double x() {
    return this.raw.as(ScissorBeginCommand.class).x();
  }

  public double y() {
    return this.raw.as(ScissorBeginCommand.class).y();
  }

  public double width() {
    return this.raw.as(ScissorBeginCommand.class).width();
  }

  public double height() {
    return this.raw.as(ScissorBeginCommand.class).height();
  }
}