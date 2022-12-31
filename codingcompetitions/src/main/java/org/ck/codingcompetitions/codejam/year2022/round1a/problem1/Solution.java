package org.ck.codingcompetitions.codejam.year2022.round1a.problem1;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 220220101,
    name = "Round A1 - 1 - Double or One Thing",
    url =
        "https://codingcompetitions.withgoogle.com/codejam/round/0000000000877ba5/0000000000aa8e9c",
    category = "Code Jam",
    subCategory = "2022")
public class Solution {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tests = in.nextInt();
      in.nextLine();

      for (int test = 1; test <= tests; ++test) {
        String line = in.nextLine();
        boolean[] used = new boolean[line.length()];

        int edited;
        do {
          edited = -1;
          StringBuilder builder = new StringBuilder();
          boolean[] newUsed = new boolean[line.length() + 1];

          for (int i = 0; i < line.length() - 1; ++i) {
            builder.append(line.charAt(i));

            int next = i + 1;
            while (next < line.length() && line.charAt(i) == line.charAt(next)) {
              ++next;
            }

            if (next < line.length()
                && line.charAt(i) < line.charAt(next)
                && !used[i]
                && edited == -1) {
              newUsed[i] = true;
              newUsed[i + 1] = true;
              builder.append(line.charAt(i));
              edited = i;
            } else {
              if (edited == -1) {
                newUsed[i] = used[i];
              } else {
                newUsed[i + 1] = used[i];
              }
            }
          }

          builder.append(line.charAt(line.length() - 1));

          if (edited >= 0) {
            line = builder.toString();
            used = newUsed;
          }
        } while (edited >= 0);

        System.out.printf("Case #%d: %s%n", test, line);
      }
    }
  }
}
