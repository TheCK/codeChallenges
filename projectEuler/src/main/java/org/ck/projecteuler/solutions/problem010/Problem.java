package org.ck.projecteuler.solutions.problem010;

import java.util.stream.StreamSupport;
import org.ck.codeChallengeLib.annotation.Solution;
import org.ck.projecteuler.lib.iterators.PrimesSpliterator;

@Solution(
    id = 10,
    name = "Summation of primes",
    url = "https://projecteuler.net/problem=10",
    category = "Problems 1 - 50")
public class Problem {
  public static void main(String[] args) {
    long result =
        StreamSupport.intStream(new PrimesSpliterator(2000000), false).mapToLong(x -> x).sum();

    System.out.println(result);
  }
}
