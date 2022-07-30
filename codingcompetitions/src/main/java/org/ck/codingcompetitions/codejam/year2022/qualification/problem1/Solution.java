package org.ck.codingcompetitions.codejam.year2022.qualification.problem1;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 220220001,
    name = "Qualification Round - 1 - Punched Cards",
    url =
        "https://codingcompetitions.withgoogle.com/codejam/round/0000000000876ff1/0000000000a4621b",
    category = "Code Jam",
    subCategory = "2022")
public class Solution {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tests = in.nextInt();

      for (int test = 1; test <= tests; ++test) {
        int rows = in.nextInt();
        int columns = in.nextInt();

        StringBuilder builder = new StringBuilder();
        builder.append(generateFillerRow(columns, true, false));

        for (int row = 1; row <= rows; ++row) {
          builder.append(generateRow(columns, row == 1));
          builder.append(generateFillerRow(columns, false, row == rows));
        }

        System.out.printf("Case #%d:%n%s%n", test, builder);
      }
    }
  }

  private static StringBuilder generateRow(int columns, boolean first) {
    StringBuilder builder = new StringBuilder();
    builder.append(first ? '.' : '|');
    builder.append(".|".repeat(columns));
    builder.append(System.lineSeparator());

    return builder;
  }

  private static StringBuilder generateFillerRow(int columns, boolean first, boolean last) {
    StringBuilder builder = new StringBuilder();
    builder.append(first ? '.' : '+');

    for (int column = 0; column < columns; ++column) {
      builder.append(column == 0 && first ? ".+" : "-+");
    }

    if (!last) {
      builder.append(System.lineSeparator());
    }
    return builder;
  }
}
