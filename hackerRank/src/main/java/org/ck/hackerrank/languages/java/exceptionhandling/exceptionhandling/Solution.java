package org.ck.hackerrank.languages.java.exceptionhandling.exceptionhandling;

import java.util.Locale;
import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 40206002,
    name = "Java Exception Handling",
    url = "https://www.hackerrank.com/challenges/java-exception-handling",
    category = "Java",
    subCategory = "Exception Handling")
public class Solution {
  public static final MyCalculator my_calculator = new MyCalculator();

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in).useLocale(Locale.ENGLISH)) {
      while (in.hasNextInt()) {
        int n = in.nextInt();
        int p = in.nextInt();

        try {
          System.out.println(my_calculator.power(n, p));
        } catch (Exception e) {
          System.out.println(e);
        }
      }
    }
  }

  private static class MyCalculator {
    public int power(int n, int p) throws Exception {
      if (n < 0 || p < 0) {
        throw new Exception("n or p should not be negative.");
      } else if (n == 0 && p == 0) {
        throw new Exception("n and p should not be zero.");
      }

      return (int) Math.round(Math.pow(n, p));
    }
  }
}
