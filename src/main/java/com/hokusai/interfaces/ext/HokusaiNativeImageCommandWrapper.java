package com.hokusai.interfaces.ext;

import org.graalvm.nativeimage.StackValue;
import org.graalvm.nativeimage.c.type.CTypeConversion;

import com.hokusai.commands.ImageCommandWrapper;

public class HokusaiNativeImageCommandWrapper {
  HokusaiNativeImageCommandCallback value;

  public HokusaiNativeImageCommandWrapper(HokusaiNativeImageCommandCallback v) {
    this.value = v;
  }

  public void call(ImageCommandWrapper command) {
    HokusaiNativeImageCommand nativeCommand = StackValue.get(HokusaiNativeImageCommand.class);
    
    nativeCommand.x(command.x());
    nativeCommand.y(command.y());
    nativeCommand.width(command.width());
    nativeCommand.height(command.height());
    final CTypeConversion.CCharPointerHolder holder = CTypeConversion.toCString(command.source());
    nativeCommand.source(holder.get());

    this.value.call(nativeCommand);
  }
}