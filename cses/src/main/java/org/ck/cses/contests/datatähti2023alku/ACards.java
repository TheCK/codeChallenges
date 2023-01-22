package org.ck.cses.contests.datatähti2023alku;

import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 104301,
    name = "A - Cards",
    url = "https://cses.fi/430/task/A",
    category = "Contests",
    subCategory = "Datatähti 2023 alku")
public class ACards {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      long cards = in.nextLong();

      if (cards < 2) {
        System.out.println("NO");
      } else if (cards > 26) {
        System.out.println("YES");
      } else {
        System.out.println("MAYBE");
      }
    }
  }
}
