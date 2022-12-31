package org.ck.codingcompetitions.codejam.year2018.practice.problem1;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 220180001,
    name = "Practice Session 2018 - 1 - Number Guessing",
    url =
        "https://codingcompetitions.withgoogle.com/codejam/round/0000000000000130/0000000000000523",
    category = "Code Jam",
    subCategory = "2018")
public class Solution {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tests = in.nextInt();

      for (int i = 0; i < tests; ++i) {
        int low = in.nextInt();
        int high = in.nextInt();
        in.nextInt(); // read limit
        in.nextLine();

        boolean solved = false;
        while (!solved) {
          int guess = (low + high) / 2;

          System.out.println(guess);
          System.out.flush();

          String result = in.nextLine();

          switch (result) {
            case "CORRECT":
              solved = true;
              break;
            case "TOO_SMALL":
              low = guess + 1;
              break;
            case "TOO_BIG":
              high = guess - 1;
              break;
            default:
              return;
          }
        }
      }
    }
  }
}
