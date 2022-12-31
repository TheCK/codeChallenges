package org.ck.spoj.classical.fctrl;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 1000011,
    name = "FCTRL - Factorial",
    url = "http://www.spoj.com/problems/FCTRL/",
    category = "classical",
    solved = false)
public class Main {
  private static final BigInteger FIVE = BigInteger.valueOf(5L);
  private static final BigInteger TWO = BigInteger.valueOf(2L);

  public static void main(String[] args) throws IOException {
    try (Scanner in = new Scanner(System.in)) {
      int numberOfTestCases = in.nextInt();

      for (int i = 0; i < numberOfTestCases; ++i) {
        BigInteger number = in.nextBigInteger();
        BigInteger temp = number;

        long zeros = getZeros(number);

        while (number.compareTo(BigInteger.ONE) == 1) {
          temp = temp.multiply(number.subtract(BigInteger.ONE));
          long tempZeros = getZeros(temp);

          zeros += tempZeros;

          while (tempZeros > 0) {
            temp = temp.divide(BigInteger.TEN);
            tempZeros--;
          }

          number = number.subtract(BigInteger.ONE);
        }

        System.out.println(zeros);
      }
    }
  }

  private static long getZeros(BigInteger number) {
    long fives = 0;
    long twoes = 0;

    BigInteger temp = number;
    while ((temp.divide(FIVE).multiply(FIVE)).equals(temp)) {
      fives++;
      temp = temp.divide(FIVE);
    }

    while ((temp.divide(TWO).multiply(TWO)).equals(temp)) {
      twoes++;
      temp = temp.divide(TWO);
    }

    return Math.min(twoes, fives);
  }
}
