package org.ck.hackerrank.corecs.mathematics.fundamentals.connectingtowns;

import java.math.BigInteger;
import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 30105,
    name = "Connecting Towns",
    url = "https://www.hackerrank.com/challenges/connecting-towns",
    category = "Mathematics",
    subCategory = "Fundamentals")
public class Solution {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      Integer cases = in.nextInt();

      for (Integer i = 0; i < cases; ++i) {
        Integer towns = in.nextInt();

        BigInteger totalPaths = new BigInteger("1");
        for (Integer j = 0; j < towns - 1; ++j) {
          BigInteger paths = in.nextBigInteger();

          totalPaths = totalPaths.multiply(paths);
        }

        System.out.println(totalPaths.mod(new BigInteger("1234567")));
      }
    }
  }
}
