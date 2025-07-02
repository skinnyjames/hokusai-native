package com.hokusai.commands;

import org.graalvm.polyglot.Value;
import com.hokusai.interfaces.*;

public class TextCommandWrapper extends CommandWrapper {
  Value raw;

  public TextCommandWrapper(Value raw) {
    this.raw = raw;
  }

  public double x() {
    return this.raw.as(TextCommand.class).x();
  }

  public double y() {
    return this.raw.as(TextCommand.class).y();
  }

  public double size() {
    return this.raw.as(TextCommand.class).size();
  }

  public Color color() {
    return this.raw.as(TextCommand.class).color();
  }

  public Boolean wrap() {
    return this.raw.as(TextCommand.class).wrap();
  }

  public String content() {
    return this.raw.as(TextCommand.class).content();
  }

  public String font() {
    return this.raw.as(TextCommand.class).font();
  }

  public Boolean bold() {
    return this.raw.as(TextCommand.class).bold();
  }

  public Boolean italic() {
    return this.raw.as(TextCommand.class).italic();
  }
}