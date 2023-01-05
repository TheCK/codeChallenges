package org.ck.hackerrank.corecs.algorithms.implementation.acmicpcteam;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 10235,
    name = "ACM ICPC Team",
    url = "https://www.hackerrank.com/challenges/acm-icpc-team",
    category = "Algorithms",
    subCategory = "Implementation")
public class Solution {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int persons = in.nextInt();
      int topics = in.nextInt();
      in.nextLine();

      boolean[][] personCapabilities = new boolean[persons][topics];

      for (int i = 0; i < persons; ++i) {
        String person = in.nextLine();

        for (int j = 0; j < person.length(); ++j) {
          personCapabilities[i][j] = person.charAt(j) == '1';
        }
      }

      int groupsThatCoverMax = 0;
      int maxTopicCount = 0;

      for (int i = 0; i < persons - 1; ++i) {
        for (int j = i + 1; j < persons; ++j) {
          Integer currentTopicCount = 0;

          for (int k = 0; k < topics; ++k) {
            if (personCapabilities[i][k] || personCapabilities[j][k]) {
              ++currentTopicCount;
            }
          }

          if (currentTopicCount > maxTopicCount) {
            groupsThatCoverMax = 1;
            maxTopicCount = currentTopicCount;
          } else if (currentTopicCount.equals(maxTopicCount)) {
            groupsThatCoverMax++;
          }
        }
      }

      System.out.println(maxTopicCount);
      System.out.println(groupsThatCoverMax);
    }
  }
}
