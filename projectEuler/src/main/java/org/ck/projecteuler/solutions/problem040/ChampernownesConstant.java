package org.ck.projecteuler.solutions.problem040;

public class ChampernownesConstant {
  private static int result = 1;

  public static void main(String[] args) {
    StringBuilder concat = new StringBuilder();

    for (int i = 1; i <= 1000000; ++i) {
      concat.append(String.valueOf(i));

      if (concat.length() > 1000000) break;
    }

    for (int i = 1; i <= 1000000; i *= 10) {
      result *= Integer.parseInt(concat.substring(i - 1, i));
    }

    printResult();
  }

  private static void printResult() {
    System.out.println(result);
  }
}
