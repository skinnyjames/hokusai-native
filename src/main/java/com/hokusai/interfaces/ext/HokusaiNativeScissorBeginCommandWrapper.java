package com.hokusai.interfaces.ext;

import org.graalvm.nativeimage.StackValue;
import com.hokusai.commands.ScissorBeginCommandWrapper;

public class HokusaiNativeScissorBeginCommandWrapper {
  HokusaiNativeScissorBeginCommandCallback value;

  public HokusaiNativeScissorBeginCommandWrapper(HokusaiNativeScissorBeginCommandCallback v) {
    this.value = v;
  }

  public void call(ScissorBeginCommandWrapper command) {
    HokusaiNativeScissorBeginCommand nativeCommand = StackValue.get(HokusaiNativeScissorBeginCommand.class);

    nativeCommand.x(command.x());
    nativeCommand.y(command.y());
    nativeCommand.width(command.width());
    nativeCommand.height(command.height());

    this.value.call(nativeCommand);
  }
}