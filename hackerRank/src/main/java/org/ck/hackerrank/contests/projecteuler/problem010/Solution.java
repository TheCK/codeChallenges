package org.ck.hackerrank.contests.projecteuler.problem010;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 99990010,
    name = "Project Euler #10: Summation of primes",
    url = "https://www.hackerrank.com/contests/projecteuler/challenges/euler010",
    category = "Contests",
    subCategory = "ProjectEuler+")
public class Solution {

  private static List<Integer> primes = new ArrayList<Integer>();

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int t = in.nextInt();

      int[] ns = new int[t];
      for (int i = 0; i < t; ++i) {
        ns[i] = in.nextInt();
      }

      initSieve(Arrays.stream(ns).max().orElse(0) + 1);

      for (int n : ns) {
        System.out.println(getSum(n));
      }
    }
  }

  private static void initSieve(int max) {
    boolean[] sieve = new boolean[max];

    int prime = 2;
    boolean end = false;
    while (!end) {
      for (int i = 2 * prime; i < max; i += prime) {
        sieve[i] = true;
      }

      for (int i = prime + 1; i <= max; ++i) {
        if (i == max - 1) {
          end = true;
          break;
        }

        if (!sieve[i]) {
          prime = i;
          break;
        }
      }
    }

    for (int i = 2; i < max; ++i) {
      if (!sieve[i]) {
        primes.add(i);
      }
    }
  }

  private static long getSum(int n) {
    long sum = 0;

    for (int i : primes) {
      if (i > n) {
        break;
      }

      sum += i;
    }

    return sum;
  }
}
