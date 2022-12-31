package org.ck.projecteuler.solutions.problem002;

import java.util.stream.StreamSupport;
import org.ck.codechallengelib.annotation.Solution;
import org.ck.projecteuler.lib.iterators.FibonacciSpliterator;

@Solution(
    id = 2,
    name = "Even Fibonacci numbers",
    url = "https://projecteuler.net/problem=2",
    category = "Problems 1 - 50")
public class Problem {
  public static void main(String[] args) {
    System.out.println(
        StreamSupport.longStream(new FibonacciSpliterator(4000000), false)
            .filter(x -> x % 2 == 0)
            .sum());
  }
}
