package org.ck.projecteuler.solutions.problem027;

import org.ck.codechallengelib.annotation.Solution;
import org.ck.projecteuler.lib.MyMath;

@Solution(
    id = 27,
    name = "Quadratic primes",
    url = "https://projecteuler.net/problem=27",
    category = "Problems 1 - 50")
public class Problem {
  private static int nMax = 0;
  private static int aForMax = 0;
  private static int bForMax = 0;

  public static void main(String[] args) {
    for (int a = -999; a < 1000; ++a) {
      for (int b = -999; b < 1000; ++b) {
        int n = numberOfPrimes(a, b);
        updateMax(a, b, n);
      }
    }

    printResult();
  }

  private static int numberOfPrimes(int a, int b) {
    int i = 0;

    while (MyMath.isPrime(i * i + a * i + b)) {
      i++;
    }

    return i;
  }

  private static void updateMax(int a, int b, int n) {
    if (n > nMax) {
      nMax = n;
      aForMax = a;
      bForMax = b;
    }
  }

  private static void printResult() {
    System.out.println(aForMax * bForMax);
  }
}
