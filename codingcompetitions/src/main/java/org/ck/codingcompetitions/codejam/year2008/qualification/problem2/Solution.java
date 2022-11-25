package org.ck.codingcompetitions.codejam.year2008.qualification.problem2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 220080002,
    name = "Qualification Round - 2 - Saving the Universe",
    url =
        "https://codingcompetitions.withgoogle.com/codejam/round/0000000000432b79/000000000043290d",
    category = "Code Jam",
    subCategory = "2008")
public class Solution {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tests = in.nextInt();

      for (int test = 1; test <= tests; ++test) {
        int engines = in.nextInt();
        in.nextLine();

        for (int engine = 0; engine < engines; ++engine) {
          in.nextLine();
        }

        int queries = in.nextInt();
        in.nextLine();

        int switches = 0;
        Set<String> pastSearches = new HashSet<>();
        for (int query = 0; query < queries; ++query) {
          String search = in.nextLine();

          pastSearches.add(search);
          if (pastSearches.size() == engines) {
            ++switches;
            pastSearches = new HashSet<>();
            pastSearches.add(search);
          }
        }

        System.out.printf("Case #%d: %d%n", test, switches);
      }
    }
  }
}
