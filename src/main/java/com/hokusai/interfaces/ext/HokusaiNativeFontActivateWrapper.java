package com.hokusai.interfaces.ext;

import org.graalvm.nativeimage.c.type.CTypeConversion;
import org.graalvm.polyglot.Value;

public class HokusaiNativeFontActivateWrapper {
  HokusaiNativeFontActivateCallback value;

  public HokusaiNativeFontActivateWrapper(HokusaiNativeFontActivateCallback v) {
    this.value = v;
  }

  public void call(Value value) {
    String key = value.asString();
    final CTypeConversion.CCharPointerHolder keyHolder = CTypeConversion.toCString(key);
    this.value.call(keyHolder.get());
    keyHolder.close();
  }
}