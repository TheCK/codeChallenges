package org.ck.hackerrank.contests.projecteuler.problem003;

import java.util.HashSet;
import java.util.OptionalLong;
import java.util.Scanner;
import java.util.Set;

@org.ck.codechallengelib.annotation.Solution(
    id = 99990003,
    name = "Project Euler #3: Largest prime factor",
    url = "https://www.hackerrank.com/contests/projecteuler/challenges/euler003",
    category = "Contests",
    subCategory = "ProjectEuler+")
public class Solution {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int count = in.nextInt();

      while (count-- > 0) {
        long number = in.nextLong();

        OptionalLong result =
            getDivisors(number).stream().mapToLong(x -> x).filter(Solution::isPrime).max();

        System.out.println(result.getAsLong());
      }
    }
  }

  public static Set<Long> getDivisors(Long number) {
    Set<Long> divisors = new HashSet<>();

    long limit = (long) Math.sqrt(number);
    for (long i = 1; i <= limit + 1; i++) {
      if (number % i == 0) {
        divisors.add(i);
        divisors.add(number / i);
      }
    }

    return divisors;
  }

  public static boolean isPrime(long num) {
    if (num == 2) {
      return true;
    }

    if (num <= 1 || num % 2 == 0) {
      return false;
    }

    long limit = (long) Math.sqrt(num);

    for (long i = 3; i <= limit; i += 2) {
      if (num % i == 0) {
        return false;
      }
    }

    return true;
  }
}
