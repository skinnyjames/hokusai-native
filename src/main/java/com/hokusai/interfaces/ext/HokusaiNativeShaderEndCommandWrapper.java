package com.hokusai.interfaces.ext;

public class HokusaiNativeShaderEndCommandWrapper {
  HokusaiNativeShaderEndCommandCallback value;

  public HokusaiNativeShaderEndCommandWrapper(HokusaiNativeShaderEndCommandCallback v) {
    this.value = v;
  }

  public void call() {
    this.value.call();
  }
}