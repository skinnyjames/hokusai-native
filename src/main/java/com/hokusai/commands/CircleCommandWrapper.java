package com.hokusai.commands;

import org.graalvm.polyglot.Value;
import com.hokusai.interfaces.*;

public class CircleCommandWrapper extends CommandWrapper {
  Value raw;

  public CircleCommandWrapper(Value raw) {
    this.raw = raw;
  }

  public double x() {
    return this.raw.as(CircleCommand.class).x();
  }

  public double y() {
    return this.raw.as(CircleCommand.class).y();
  }

  public double radius() {
    return this.raw.as(CircleCommand.class).radius();
  }

  public Color color() {
    return this.raw.as(CircleCommand.class).color();
  }

  public Color outline_color() {
    return this.raw.as(CircleCommand.class).outline_color();
  }

  public double outline() {
    return this.raw.as(CircleCommand.class).outline();
  }
}
