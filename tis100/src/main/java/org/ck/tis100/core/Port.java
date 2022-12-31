package org.ck.tis100.core;

import java.util.OptionalInt;
import java.util.function.Consumer;

public class Port {
  private int stepOfValue = 0;
  private Integer value;

  private boolean anyMode;
  private Consumer<String> anyReadCallback;

  public boolean write(int value, int step) {
    if (this.value == null) {
      this.value = value;
      this.stepOfValue = step;
      return true;
    }

    return false;
  }

  public OptionalInt read(int step) {
    if (step > stepOfValue && value != null) {
      int temp = value;
      value = null;
      return OptionalInt.of(temp);
    }

    return OptionalInt.empty();
  }
}
