package org.ck.hackerrank.contests.projecteuler.problem006;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 99990006,
    name = "Project Euler #6: Sum square difference",
    url = "https://www.hackerrank.com/contests/projecteuler/challenges/euler006",
    category = "Contests",
    subCategory = "ProjectEuler+")
public class Solution {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int count = in.nextInt();

      while (count-- > 0) {
        long number = in.nextLong();

        long sum = (number * (number + 1)) / 2;
        long squareSum = sum * sum;

        long sumOfSquares = number * (number + 1) * ((2 * number) + 1) / 6;

        System.out.println(squareSum - sumOfSquares);
      }
    }
  }
}
