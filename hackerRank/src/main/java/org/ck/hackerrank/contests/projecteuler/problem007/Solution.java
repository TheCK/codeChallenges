package org.ck.hackerrank.contests.projecteuler.problem007;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 99990007,
    name = "Project Euler #7: 10001st prime",
    url = "https://www.hackerrank.com/contests/projecteuler/challenges/euler007",
    category = "Contests",
    subCategory = "ProjectEuler+")
public class Solution {

  private static final int MAX = 105000;

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int count = in.nextInt();

      boolean[] sieve = new boolean[MAX];

      int prime = 2;
      boolean end = false;
      while (!end) {
        for (int i = 2 * prime; i < MAX; i += prime) {
          sieve[i] = true;
        }

        for (int i = prime + 1; i <= MAX; ++i) {
          if (i == MAX - 1) {
            end = true;
            break;
          }

          if (!sieve[i]) {
            prime = i;
            break;
          }
        }
      }

      while (count-- > 0) {
        int n = in.nextInt();

        int current = 1;
        for (int i = 2; current <= n; ++i) {
          if (current == n && !sieve[i]) {
            System.out.println(i);
            break;
          } else if (!sieve[i]) {
            ++current;
          }
        }
      }
    }
  }
}
