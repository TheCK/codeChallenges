package org.ck.hackerrank.languages.java.bignumber.bigdecimal;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40203001,
    name = "Java BigDecimal",
    url = "https://www.hackerrank.com/challenges/java-bigdecimal",
    category = "Java",
    subCategory = "BigNumber")
public class Solution {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();
      String[] s = new String[n + 2];
      for (int i = 0; i < n; i++) {
        s[i] = in.next();
      }

      s =
          Arrays.stream(s)
              .filter(Objects::nonNull)
              .sorted(Comparator.comparing(BigDecimal::new, Comparator.reverseOrder()))
              .toArray(String[]::new);

      for (int i = 0; i < n; i++) {
        System.out.println(s[i]);
      }
    }
  }
}
