package org.ck.hackerrank.contests.projecteuler.problem001;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 99990001,
    name = "Project Euler #1: Multiples of 3 and 5",
    url = "https://www.hackerrank.com/contests/projecteuler/challenges/euler001",
    category = "Contests",
    subCategory = "ProjectEuler+")
public class Solution {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int count = in.nextInt();

      while (count-- > 0) {
        long num = in.nextLong() - 1L;

        long numbersDivisibleBy3Count = (num / 3L);
        long sumOfNumbersDivisibleBy3 =
            (numbersDivisibleBy3Count * numbersDivisibleBy3Count + numbersDivisibleBy3Count) / 2;

        long numbersDivisibleBy5Count = (num / 5L);
        long sumOfNumbersDivisibleBy5 =
            (numbersDivisibleBy5Count * numbersDivisibleBy5Count + numbersDivisibleBy5Count) / 2;

        long numbersDivisibleBy15Count = (num / 15L);
        long sumOfNumbersDivisibleBy15 =
            (numbersDivisibleBy15Count * numbersDivisibleBy15Count + numbersDivisibleBy15Count) / 2;

        System.out.println(
            3L * sumOfNumbersDivisibleBy3
                + 5L * sumOfNumbersDivisibleBy5
                - 15L * sumOfNumbersDivisibleBy15);
      }
    }
  }
}
