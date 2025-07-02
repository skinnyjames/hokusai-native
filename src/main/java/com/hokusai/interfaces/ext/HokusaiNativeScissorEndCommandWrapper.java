package com.hokusai.interfaces.ext;

public class HokusaiNativeScissorEndCommandWrapper {
  HokusaiNativeScissorEndCommandCallback value;

  public HokusaiNativeScissorEndCommandWrapper(HokusaiNativeScissorEndCommandCallback v) {
    this.value = v;
  }

  public void call() {
    this.value.call();
  }
}