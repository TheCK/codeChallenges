package org.ck.hackerrank.corecs.algorithms.strings.strongpassword;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 10310,
    name = "Strong Password",
    url = "https://www.hackerrank.com/challenges/strong-password",
    category = "Algorithms",
    subCategory = "Strings")
public class Solution {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      in.nextLine();

      System.out.println(minimumNumber(in.nextLine()));
    }
  }

  public static int minimumNumber(String password) {
    int needed = 0;

    if (!password.matches(".*\\d.*")) {
      ++needed;
    }

    if (!password.matches(".*[a-z].*")) {
      ++needed;
    }

    if (!password.matches(".*[A-Z].*")) {
      ++needed;
    }

    if (!password.matches(".*[!@#$%^&*()\\-+].*")) {
      ++needed;
    }

    return Math.max(needed, 6 - password.length());
  }
}
