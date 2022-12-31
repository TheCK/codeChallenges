package org.ck.spoj.classical.prime1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 1000002,
    name = "PRIME1 - Prime Generator",
    url = "http://www.spoj.com/problems/PRIME1/",
    category = "classical")
public class Main {
  private static List<Long> primes = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    initPrimes();

    try (Scanner in = new Scanner(System.in)) {
      long numberOfTestCases = in.nextLong();
      for (int i = 0; i < numberOfTestCases; ++i) {
        long begin = in.nextLong();
        long end = in.nextLong();

        for (long candidate = begin; candidate <= end; ++candidate) {
          if (isPrime(candidate)) {
            System.out.println(candidate);
          }
        }

        if (i + 1 < numberOfTestCases) {
          System.out.println();
        }
      }
    }
  }

  private static void initPrimes() {
    boolean[] candidates = new boolean[32000];

    Arrays.fill(candidates, true);

    candidates[0] = false;
    candidates[1] = false;

    for (int i = 2; i < 32000; ++i) {
      if (candidates[i]) {
        primes.add((long) i);

        for (int j = i + i; j < 32000; j += i) {
          candidates[j] = false;
        }
      }
    }
  }

  private static boolean isPrime(long candidate) {
    if (candidate == 1) {
      return false;
    }

    if (candidate == 2) {
      return true;
    }

    long limit = (long) Math.ceil(Math.sqrt(candidate));

    for (long prime : primes) {
      if (prime > limit) {
        return true;
      }

      if (candidate % prime == 0 && candidate / prime != 1) {
        return false;
      }
    }

    return true;
  }
}
