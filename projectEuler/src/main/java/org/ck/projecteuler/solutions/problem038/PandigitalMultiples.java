package org.ck.projecteuler.solutions.problem038;

import java.math.BigInteger;
import java.util.Set;
import org.ck.projecteuler.lib.MyMath;

public class PandigitalMultiples {
  private static BigInteger maxSum = BigInteger.ZERO;

  public static void main(String[] args) {
    for (int i = 1; i <= 100000; ++i) {
      String concatSum = "";

      for (int n = 1; n <= 10; ++n) {
        concatSum += String.valueOf(i * n);

        if (concatSum.length() < 9) continue;

        if (concatSum.length() > 9) break;

        Set<String> digits = MyMath.getUniqueDigits(concatSum);

        updateResult(digits, concatSum);
      }
    }

    printResult();
  }

  private static void updateResult(Set<String> digits, String concatSum) {
    if (digits.size() == 9 && !digits.contains("0")) {
      BigInteger sum = new BigInteger(concatSum);

      if (sum.compareTo(maxSum) == 1) {
        maxSum = sum;
      }
    }
  }

  private static void printResult() {
    System.out.println(maxSum);
  }
}
