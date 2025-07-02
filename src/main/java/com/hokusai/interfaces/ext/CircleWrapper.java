package com.hokusai.interfaces.ext;

import org.graalvm.nativeimage.StackValue;
import org.graalvm.nativeimage.UnmanagedMemory;
import org.graalvm.nativeimage.c.struct.SizeOf;
import com.hokusai.commands.CircleCommandWrapper;

public class CircleWrapper {
  HokusaiNativeCircleCommandCallback value;

  public CircleWrapper(HokusaiNativeCircleCommandCallback v) {
    this.value = v;
  }

  public void call(CircleCommandWrapper command) {
    // HokusaiNativeCircleCommand nativeCommand = UnmanagedMemory.malloc(SizeOf.get(HokusaiNativeCircleCommand.class));

    HokusaiNativeCircleCommand nativeCommand = StackValue.get(HokusaiNativeCircleCommand.class);
    HokusaiNativeColor color = StackValue.get(HokusaiNativeColor.class);// UnmanagedMemory.malloc(SizeOf.get(HokusaiNativeColor.class)); //
    HokusaiNativeColor outlineColor = StackValue.get(HokusaiNativeColor.class);//UnmanagedMemory.malloc(SizeOf.get(HokusaiNativeColor.class)); //

    System.out.println("in call");
    color.red(command.color().red());
    color.green(command.color().green());
    color.blue(command.color().blue());
    color.alpha(command.color().alpha());
    System.out.println("outline");
    outlineColor.red(command.outline_color().red());
    outlineColor.green(command.outline_color().green());
    outlineColor.blue(command.outline_color().blue());
    outlineColor.alpha(command.outline_color().alpha());

    nativeCommand.x(command.x());
    nativeCommand.y(command.y());
    nativeCommand.radius(command.radius());
        System.out.println("set color");

    nativeCommand.color(color);
            System.out.println("set outline color");

    nativeCommand.outline_color(outlineColor);
    nativeCommand.outline(command.outline());
                System.out.println("calling");

    this.value.call(nativeCommand);

    // UnmanagedMemory.free(nativeCommand);
    // UnmanagedMemory.free(outlineColor);
    // UnmanagedMemory.free(color);

    System.out.println("after call");
  }

  public HokusaiNativeCircleCommandCallback raw() {
    return this.value;
  }
}