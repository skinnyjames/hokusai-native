package com.hokusai.interfaces.ext;

import org.graalvm.nativeimage.c.type.CTypeConversion;
import org.graalvm.polyglot.Value;

public class HokusaiNativeFontLoadWrapper {
  HokusaiNativeFontLoadCallback value;

  public HokusaiNativeFontLoadWrapper(HokusaiNativeFontLoadCallback v) {
    this.value = v;
  }

  public void call(Value keyValue, Value pathValue, Value sizeValue) {
    final CTypeConversion.CCharPointerHolder keyHolder = CTypeConversion.toCString(keyValue.asString());
    final CTypeConversion.CCharPointerHolder pathHolder = CTypeConversion.toCString(pathValue.asString());

    this.value.call(keyHolder.get(), pathHolder.get(), sizeValue.asInt());
    keyHolder.close();
    pathHolder.close();
  }
}