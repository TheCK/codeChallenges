package org.ck.projecteuler.solutions.problem001;

import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 1,
    name = "Multiples of 3 and 5",
    url = "https://projecteuler.net/problem=1",
    category = "Problems 1 - 50")
public class Problem {
  public static void main(String[] args) {
    int numbersDivisibleBy3Count = (999 / 3);
    int sumOfNumbersDivisibleBy3 =
        (numbersDivisibleBy3Count * numbersDivisibleBy3Count + numbersDivisibleBy3Count) / 2;

    int numbersDivisibleBy5Count = (999 / 5);
    int sumOfNumbersDivisibleBy5 =
        (numbersDivisibleBy5Count * numbersDivisibleBy5Count + numbersDivisibleBy5Count) / 2;

    int numbersDivisibleBy15Count = (999 / 15);
    int sumOfNumbersDivisibleBy15 =
        (numbersDivisibleBy15Count * numbersDivisibleBy15Count + numbersDivisibleBy15Count) / 2;

    System.out.println(
        3 * sumOfNumbersDivisibleBy3
            + 5 * sumOfNumbersDivisibleBy5
            - 15 * sumOfNumbersDivisibleBy15);
  }
}
