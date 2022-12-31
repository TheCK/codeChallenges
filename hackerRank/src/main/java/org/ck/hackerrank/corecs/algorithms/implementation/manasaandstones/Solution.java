package org.ck.hackerrank.corecs.algorithms.implementation.manasaandstones;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 10250,
    name = "Manasa and Stones",
    url = "https://www.hackerrank.com/challenges/manasa-and-stones",
    category = "Algorithms",
    subCategory = "Implementation")
public class Solution {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int cases = in.nextInt();

      for (int i = 0; i < cases; ++i) {
        int stones = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();

        int min = Math.min(a, b);
        int max = Math.max(a, b);

        int lowerBoundary = (stones - 1) * min;
        int upperBoundary = (stones - 1) * max;
        int difference = max - min;

        if (difference != 0) {
          for (int j = lowerBoundary; j <= upperBoundary; j += difference) {
            System.out.print(j);

            if (j != upperBoundary) {
              System.out.print(" ");
            }
          }
        } else {
          System.out.print(lowerBoundary);
        }

        System.out.println("");
      }
    }
  }
}
