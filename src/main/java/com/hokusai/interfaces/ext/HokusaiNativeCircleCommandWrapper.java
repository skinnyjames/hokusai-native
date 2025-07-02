package com.hokusai.interfaces.ext;

import org.graalvm.nativeimage.StackValue;
import com.hokusai.commands.CircleCommandWrapper;

public class HokusaiNativeCircleCommandWrapper {
  HokusaiNativeCircleCommandCallback value;

  public HokusaiNativeCircleCommandWrapper(HokusaiNativeCircleCommandCallback v) {
    this.value = v;
  }

  public void call(CircleCommandWrapper command) {
    HokusaiNativeCircleCommand nativeCommand = StackValue.get(HokusaiNativeCircleCommand.class);
    HokusaiNativeColor color = StackValue.get(HokusaiNativeColor.class);// UnmanagedMemory.malloc(SizeOf.get(HokusaiNativeColor.class)); //
    HokusaiNativeColor outlineColor = StackValue.get(HokusaiNativeColor.class);//UnmanagedMemory.malloc(SizeOf.get(HokusaiNativeColor.class)); //

    color.red(command.color().red());
    color.green(command.color().green());
    color.blue(command.color().blue());
    color.alpha(command.color().alpha());

    outlineColor.red(command.outline_color().red());
    outlineColor.green(command.outline_color().green());
    outlineColor.blue(command.outline_color().blue());
    outlineColor.alpha(command.outline_color().alpha());

    nativeCommand.x(command.x());
    nativeCommand.y(command.y());
    nativeCommand.radius(command.radius());
    nativeCommand.color(color);
    nativeCommand.outline_color(outlineColor);
    nativeCommand.outline(command.outline());

    this.value.call(nativeCommand);
  }
}