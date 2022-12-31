package org.ck.projecteuler.solutions.problem004;

import java.util.OptionalInt;
import java.util.stream.StreamSupport;
import org.ck.codechallengelib.annotation.Solution;
import org.ck.projecteuler.lib.MyMath;
import org.ck.projecteuler.lib.iterators.IntDoubleLoopSpliterator;

@Solution(
    id = 4,
    name = "Largest palindrome product",
    url = "https://projecteuler.net/problem=4",
    category = "Problems 1 - 50")
public class Problem {
  public static void main(String[] args) {
    OptionalInt result =
        StreamSupport.intStream(
                new IntDoubleLoopSpliterator(999, 99, 999, 99, x -> x - 1, (x, y) -> x * y), false)
            .filter(MyMath::isPalindrome)
            .max();

    System.out.println(result.getAsInt());
  }
}
