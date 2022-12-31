package org.ck.projecteuler.solutions.problem006;

import java.util.stream.StreamSupport;
import org.ck.codechallengelib.annotation.Solution;
import org.ck.projecteuler.lib.iterators.IntSpliterator;

@Solution(
    id = 6,
    name = "Sum square difference",
    url = "https://projecteuler.net/problem=6",
    category = "Problems 1 - 50")
public class Problem {
  public static void main(String[] args) {
    int sumOfQuares =
        StreamSupport.intStream(new IntSpliterator(1, 101, x -> x + 1, x -> x * x), false).sum();

    int sum = (100 + 1) * 50;
    int squareOfSums = sum * sum;

    System.out.println(Math.abs(sumOfQuares - squareOfSums));
  }
}
