package org.ck.projecteuler.solutions.problem016;

import java.math.BigInteger;
import java.util.stream.Stream;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 16,
    name = "Power Digit Sum",
    url = "https://projecteuler.net/problem=16",
    category = "Problems 1 - 50")
public class Problem {
  public static void main(String[] args) {
    System.out.println(
        Stream.of(BigInteger.TWO.pow(1000).toString().split("")).mapToInt(Integer::parseInt).sum());
  }
}
