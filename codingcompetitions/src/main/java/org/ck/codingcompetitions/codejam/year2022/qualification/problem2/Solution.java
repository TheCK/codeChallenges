package org.ck.codingcompetitions.codejam.year2022.qualification.problem2;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 220220002,
    name = "Qualification Round - 2 - 3D Printing",
    url =
        "https://codingcompetitions.withgoogle.com/codejam/round/0000000000876ff1/0000000000a4672b",
    category = "Code Jam",
    subCategory = "2022")
public class Solution {

  public static final int COLOUR_NEEDED = 1000000;

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tests = in.nextInt();

      for (int test = 1; test <= tests; ++test) {
        int c = Integer.MAX_VALUE;
        int m = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        int k = Integer.MAX_VALUE;

        for (int printer = 1; printer <= 3; ++printer) {
          c = Math.min(c, in.nextInt());
          m = Math.min(m, in.nextInt());
          y = Math.min(y, in.nextInt());
          k = Math.min(k, in.nextInt());
        }

        System.out.printf("Case #%d: %s%n", test, calculateColour(c, m, y, k));
      }
    }
  }

  private static String calculateColour(final int c, final int m, final int y, final int k) {
    if (c + m + y + k < COLOUR_NEEDED) {
      return "IMPOSSIBLE";
    }

    StringBuilder builder = new StringBuilder();

    int needed = COLOUR_NEEDED;

    int usedCyan = Math.min(c, needed);
    builder.append(usedCyan).append(" ");
    needed -= usedCyan;

    int usedMagenta = Math.min(m, needed);
    builder.append(usedMagenta).append(" ");
    needed -= usedMagenta;

    int usedYellow = Math.min(y, needed);
    builder.append(usedYellow).append(" ");
    needed -= usedYellow;

    int usedBlack = Math.min(k, needed);
    builder.append(usedBlack);

    return builder.toString();
  }
}
