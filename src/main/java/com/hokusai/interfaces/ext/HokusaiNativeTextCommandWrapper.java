package com.hokusai.interfaces.ext;

import org.graalvm.nativeimage.StackValue;
import com.hokusai.commands.TextCommandWrapper;
import org.graalvm.nativeimage.c.type.CTypeConversion;

public class HokusaiNativeTextCommandWrapper {
  HokusaiNativeTextCommandCallback value;

  public HokusaiNativeTextCommandWrapper(HokusaiNativeTextCommandCallback v) {
    this.value = v;
  }

  public void call(TextCommandWrapper command) {
    HokusaiNativeTextCommand nativeCommand = StackValue.get(HokusaiNativeTextCommand.class);
    HokusaiNativeColor color = StackValue.get(HokusaiNativeColor.class);
    HokusaiNativeBoundary padding = StackValue.get(HokusaiNativeBoundary.class);

    color.red(command.color().red());
    color.green(command.color().green());
    color.blue(command.color().blue());
    color.alpha(command.color().alpha());

    padding.top(command.padding().top());
    padding.right(command.padding().right());
    padding.bottom(command.padding().bottom());
    padding.left(command.padding().left());

    nativeCommand.x(command.x());
    nativeCommand.y(command.y());
    nativeCommand.size(command.size());
    nativeCommand.bold(command.bold());
    nativeCommand.italic(command.italic());
    final CTypeConversion.CCharPointerHolder holder = CTypeConversion.toCString(command.content());
    nativeCommand.content(holder.get());
    nativeCommand.color(color);
    nativeCommand.padding(padding);

    this.value.call(nativeCommand);

    holder.close();
  }
}