package com.hokusai.interfaces.ext;

import org.graalvm.nativeimage.c.type.CTypeConversion;
import org.graalvm.nativeimage.c.type.CFloatPointer;
import org.graalvm.polyglot.Value;

public class HokusaiNativeFontMeasureWrapper {
  HokusaiNativeFontMeasureCallback value;

  public HokusaiNativeFontMeasureWrapper(HokusaiNativeFontMeasureCallback v) {
    this.value = v;
  }

  public float call(Value toMeasure, Value size) {
    final CTypeConversion.CCharPointerHolder toMeasureHolder = CTypeConversion.toCString(toMeasure.asString());
    int len = toMeasure.asString().length();

    float width = this.value.call(toMeasureHolder.get(), len, size.asInt());
    toMeasureHolder.close();
    return width;
  }
}
