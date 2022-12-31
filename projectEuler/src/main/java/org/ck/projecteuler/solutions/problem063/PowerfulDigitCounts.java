package org.ck.projecteuler.solutions.problem063;

import java.math.BigInteger;

public class PowerfulDigitCounts {
  private static int count = 0;

  public static void main(String[] args) {
    for (long i = 0; i <= 10; ++i) {
      for (int j = 0; j <= 20; ++j) {
        BigInteger power = BigInteger.valueOf(i).pow(j);

        if (power.toString().length() == j) {
          count++;
        }
      }
    }

    printResult();
  }

  private static void printResult() {
    System.out.println(count);
  }
}
