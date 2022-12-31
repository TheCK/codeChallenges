package org.ck.projecteuler.solutions.problem029;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 29,
    name = "Distinct powers",
    url = "https://projecteuler.net/problem=29",
    category = "Problems 1 - 50")
public class Problem {
  private static final Set<BigInteger> powers = new HashSet<>();

  public static void main(String[] args) {
    for (int a = 2; a <= 100; ++a) {
      BigInteger bigA = BigInteger.valueOf(a);

      for (int b = 2; b <= 100; ++b) {
        powers.add(bigA.pow(b));
      }
    }

    System.out.println(powers.size());
  }
}
