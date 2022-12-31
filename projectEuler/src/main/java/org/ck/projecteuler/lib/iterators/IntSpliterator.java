package org.ck.projecteuler.lib.iterators;

import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntUnaryOperator;

public class IntSpliterator extends Spliterators.AbstractIntSpliterator {
  private int end = Integer.MAX_VALUE;

  private IntUnaryOperator countFunction;
  private IntUnaryOperator generateFunction;

  private int i = 0;

  public IntSpliterator(
      int start, int end, IntUnaryOperator countFunction, IntUnaryOperator generateFunction) {
    super(Integer.MAX_VALUE, 0);

    this.i = start;
    this.end = end;

    this.countFunction = countFunction;
    this.generateFunction = generateFunction;
  }

  public IntSpliterator(int start, int end, IntUnaryOperator countFunction) {
    this(start, end, countFunction, x -> x);
  }

  public IntSpliterator(int start, int end) {
    this(start, end, x -> x + 1, x -> x);
  }

  @Override
  public boolean tryAdvance(IntConsumer action) {
    Integer result = getNextValue();

    if (result != null) {
      action.accept(result);
    }

    return result != null;
  }

  @Override
  public boolean tryAdvance(Consumer<? super Integer> action) {
    Integer result = getNextValue();

    if (result != null) {
      action.accept(result);
    }

    return result != null;
  }

  private Integer getNextValue() {
    if (this.i == this.end) {
      return null;
    }

    Integer result = this.generateFunction.applyAsInt(this.i);

    this.i = this.countFunction.applyAsInt(this.i);

    return result;
  }
}
