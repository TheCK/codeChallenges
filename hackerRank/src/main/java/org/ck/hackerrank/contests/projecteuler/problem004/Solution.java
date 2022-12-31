package org.ck.hackerrank.contests.projecteuler.problem004;

import java.util.OptionalInt;
import java.util.Scanner;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.StreamSupport;

@org.ck.codechallengelib.annotation.Solution(
    id = 99990004,
    name = "Project Euler #4: Largest palindrome product",
    url = "https://www.hackerrank.com/contests/projecteuler/challenges/euler004",
    category = "Contests",
    subCategory = "ProjectEuler+")
public class Solution {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int count = in.nextInt();

      while (count-- > 0) {
        int number = in.nextInt();

        OptionalInt result =
            StreamSupport.intStream(new IntCountDownSpliterator(number), false)
                .filter(Solution::isPalindrome)
                .filter(Solution::hasTwoThreeDigitDivisors)
                .findFirst();

        System.out.println(result.getAsInt());
      }
    }
  }

  public static boolean hasTwoThreeDigitDivisors(int number) {
    int limit = (int) Math.sqrt(number);
    for (long i = limit; i > 100; --i) {
      if (number % i == 0 && number / i > 99 && number / i < 1000) {
        return true;
      }
    }

    return false;
  }

  public static boolean isPalindrome(String number) {
    StringBuilder builder = new StringBuilder(number);

    return builder.reverse().toString().equals(number);
  }

  public static boolean isPalindrome(int number) {
    return isPalindrome(Integer.toString(number));
  }

  private static class IntCountDownSpliterator extends Spliterators.AbstractIntSpliterator {
    private int i;

    public IntCountDownSpliterator(int start) {
      super(start, 0);

      this.i = start;
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
      if (this.i == 0) {
        return null;
      }

      return --this.i;
    }
  }
}
