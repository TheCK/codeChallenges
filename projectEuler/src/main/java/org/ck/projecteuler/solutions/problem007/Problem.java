package org.ck.projecteuler.solutions.problem007;

import java.util.OptionalInt;
import java.util.stream.StreamSupport;
import org.ck.codechallengelib.annotation.Solution;
import org.ck.projecteuler.lib.iterators.PrimesSpliterator;

@Solution(
    id = 7,
    name = "10001st prime",
    url = "https://projecteuler.net/problem=7",
    category = "Problems 1 - 50")
public class Problem {
  public static void main(String[] args) {
    OptionalInt result =
        StreamSupport.intStream(new PrimesSpliterator(500000), false).limit(10001).max();

    System.out.println(result.getAsInt());
  }
}
