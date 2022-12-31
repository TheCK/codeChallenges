package org.ck.hackerrank.corecs.algorithms.warmup.comparethetriplets;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 10103,
    name = "Compare the Triplets",
    url = "https://www.hackerrank.com/challenges/compare-the-triplets",
    category = "Algorithms",
    subCategory = "Warmup")
public class Solution {
  private static int VECTOR_SIZE = 3;

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      List<Integer> alice = new ArrayList<>();
      for (int i = 0; i < VECTOR_SIZE; ++i) {
        alice.add(in.nextInt());
      }

      int aliceWins = 0;
      int bobWins = 0;
      for (int i = 0; i < VECTOR_SIZE; ++i) {
        int currentBob = in.nextInt();

        if (currentBob < alice.get(i)) {
          ++aliceWins;
        } else if (currentBob > alice.get(i)) {
          ++bobWins;
        }
      }

      System.out.println(String.format("%d %d", aliceWins, bobWins));
    }
  }
}
