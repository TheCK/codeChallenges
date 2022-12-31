package org.ck.hackerrank.contests.projecteuler.problem002;

import java.util.Scanner;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import java.util.stream.StreamSupport;

@org.ck.codechallengelib.annotation.Solution(
    id = 99990002,
    name = "Project Euler #2: Even Fibonacci numbers",
    url = "https://www.hackerrank.com/contests/projecteuler/challenges/euler002",
    category = "Contests",
    subCategory = "ProjectEuler+")
public class Solution {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int count = in.nextInt();

      while (count-- > 0) {
        long max = in.nextLong();

        System.out.println(
            StreamSupport.longStream(new FibonacciSpliterator(max), false)
                .filter(x -> x % 2 == 0)
                .sum());
      }
    }
  }

  private static class FibonacciSpliterator extends Spliterators.AbstractLongSpliterator {
    private long penultimate = 0;
    private long ultimate = 1;

    private long maxValue;

    public FibonacciSpliterator(long maxValue) {
      super(maxValue, 0);

      this.maxValue = maxValue;
    }

    @Override
    public boolean tryAdvance(LongConsumer action) {
      Long result = getNextValue();

      if (result != null) {
        action.accept(result);
      }

      return result != null;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Long> action) {
      Long result = getNextValue();

      if (result != null) {
        action.accept(result);
      }

      return result != null;
    }

    private Long getNextValue() {
      Long result = this.penultimate + this.ultimate;

      this.penultimate = this.ultimate;
      this.ultimate = result;

      if (result > this.maxValue) {
        return null;
      }

      return result;
    }
  }
}
