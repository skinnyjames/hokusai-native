package com.hokusai.interfaces.ext;

import org.graalvm.nativeimage.StackValue;
// import org.graalvm.nativeRect.c.type.CTypeConversion;
import com.hokusai.commands.RectCommandWrapper;

public class HokusaiNativeRectCommandWrapper {
  HokusaiNativeRectCommandCallback value;

  public HokusaiNativeRectCommandWrapper(HokusaiNativeRectCommandCallback v) {
    this.value = v;
  }

  public void call(RectCommandWrapper command) {
    HokusaiNativeRectCommand nativeCommand = StackValue.get(HokusaiNativeRectCommand.class);
    HokusaiNativeColor color = StackValue.get(HokusaiNativeColor.class);
    HokusaiNativeColor outlineColor = StackValue.get(HokusaiNativeColor.class);
    HokusaiNativeBoundary padding = StackValue.get(HokusaiNativeBoundary.class);
    HokusaiNativeBoundary outline = StackValue.get(HokusaiNativeBoundary.class);

    color.red(command.color().red());
    color.green(command.color().green());
    color.blue(command.color().blue());
    color.alpha(command.color().alpha());

    outlineColor.red(command.outline_color().red());
    outlineColor.green(command.outline_color().green());
    outlineColor.blue(command.outline_color().blue());
    outlineColor.alpha(command.outline_color().alpha());

    padding.top(command.padding().top());
    padding.right(command.padding().right());
    padding.bottom(command.padding().bottom());
    padding.left(command.padding().left());

    outline.top(command.outline().top());
    outline.right(command.outline().right());
    outline.bottom(command.outline().bottom());
    outline.left(command.outline().left());

    nativeCommand.x(command.x());
    nativeCommand.y(command.y());
    nativeCommand.width(command.width());
    nativeCommand.height(command.height());
    nativeCommand.rounding(command.rounding());
    nativeCommand.color(color);
    nativeCommand.outline(outline);
    nativeCommand.outline_color(outlineColor);
    nativeCommand.padding(padding);

    this.value.call(nativeCommand);
  }
}