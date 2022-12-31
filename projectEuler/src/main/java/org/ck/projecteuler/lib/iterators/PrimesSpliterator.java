package org.ck.projecteuler.lib.iterators;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class PrimesSpliterator extends Spliterators.AbstractIntSpliterator {
  private Queue<Integer> primes = new LinkedList<>();

  public PrimesSpliterator(int maxValue) {
    super(maxValue, 0);

    generatePrimes(maxValue);
  }

  private void generatePrimes(int maxValue) {
    double upperLimit = Math.sqrt(maxValue);

    boolean[] numbers = new boolean[maxValue + 1];
    for (int i = 2; i <= maxValue; ++i) {
      numbers[i] = true;
    }

    int i = 2;
    while (i <= upperLimit) {
      for (int j = 2 * i; j <= maxValue; j += i) {
        numbers[j] = false;
      }

      ++i;
      while (!numbers[i]) {
        ++i;
      }
    }

    for (int j = 2; j <= maxValue; ++j) {
      if (numbers[j]) {
        this.primes.add(j);
      }
    }
  }

  @Override
  public boolean tryAdvance(IntConsumer action) {
    if (this.primes.isEmpty()) {
      return false;
    }

    action.accept(this.primes.remove());

    return true;
  }

  @Override
  public boolean tryAdvance(Consumer<? super Integer> action) {
    if (this.primes.isEmpty()) {
      return false;
    }

    action.accept(this.primes.remove());

    return true;
  }
}
