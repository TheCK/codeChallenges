package org.ck.hackerRank.contests.projecteuler.problem005;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 99990005,
    name = "Project Euler #5: Smallest multiple",
    url = "https://www.hackerrank.com/contests/projecteuler/challenges/euler005",
    category = "Contests",
    subCategory = "ProjectEuler+")
public class Solution {

  private static final int[] primes = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};
  private static final Map<Integer, Map<Integer, Integer>> primeFactors = new HashMap<>();

  public static void main(String[] args) {
    initPrimeFactors();

    try (Scanner in = new Scanner(System.in)) {
      int count = in.nextInt();

      while (count-- > 0) {
        int number = in.nextInt();

        Map<Integer, Integer> maxPrimeFactors = new HashMap<>();
        for (int prime : primes) {
          maxPrimeFactors.put(prime, 0);
          for (int i = 2; i <= number; ++i) {
            maxPrimeFactors.put(
                prime, Math.max(maxPrimeFactors.get(prime), primeFactors.get(i).get(prime)));
          }
        }

        System.out.println(
            maxPrimeFactors.entrySet().stream()
                .filter(entry -> entry.getValue() != 0)
                .map(entry -> (int) Math.pow(entry.getKey(), entry.getValue()))
                .reduce(1, (a, b) -> a * b));
      }
    }
  }

  private static void initPrimeFactors() {
    for (int i = 2; i <= 40; ++i) {
      final HashMap<Integer, Integer> currentPrimeFactors = new HashMap<>();

      int remains = i;
      for (int prime : primes) {
        int currentCount = 0;

        while (remains % prime == 0) {
          ++currentCount;
          remains /= prime;
        }

        currentPrimeFactors.put(prime, currentCount);
      }

      primeFactors.put(i, currentPrimeFactors);
    }
  }
}
