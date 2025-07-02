package com.hokusai.commands;

import org.graalvm.polyglot.Value;
import com.hokusai.interfaces.*;

public class RectCommandWrapper extends CommandWrapper {
  Value raw;

  public RectCommandWrapper(Value raw) {
    this.raw = raw;
  }

  public double x() {
    return this.raw.as(RectCommand.class).x();
  }

  public double y() {
    return this.raw.as(RectCommand.class).y();
  }

  public double width() {
    return this.raw.as(RectCommand.class).width();
  }

  public double height() {
    return this.raw.as(RectCommand.class).height();
  }

  public double rounding() {
    return this.raw.as(RectCommand.class).rounding();
  }

  public Color color() {
    return this.raw.as(RectCommand.class).color();
  }

  public Outline outline() {
    return this.raw.as(RectCommand.class).outline();
  }

  public Color outline_color() {
    return this.raw.as(RectCommand.class).outline_color();
  }

  public Padding padding() {
    return this.raw.as(RectCommand.class).padding();
  }
}
