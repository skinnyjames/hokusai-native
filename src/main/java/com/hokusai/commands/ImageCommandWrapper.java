package com.hokusai.commands;

import org.graalvm.polyglot.Value;
import com.hokusai.interfaces.*;

public class ImageCommandWrapper extends CommandWrapper {
  Value raw;

  public ImageCommandWrapper(Value raw) {
    this.raw = raw;
  }

  public String source() {
    return this.raw.as(ImageCommand.class).source();
  }

  public double x() {
    return this.raw.as(ImageCommand.class).x();
  }

  public double y() {
    return this.raw.as(ImageCommand.class).y();
  }

  public double width() {
    return this.raw.as(ImageCommand.class).width();
  }

  public double height() {
    return this.raw.as(ImageCommand.class).height();
  }

  public Color color() {
    return this.raw.as(ImageCommand.class).color();
  }

}
