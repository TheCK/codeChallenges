package org.ck.codingcompetitions.kickstart.year2020.rounda.problem2;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 120200102,
    name = "Round A - 2 - Plates",
    url =
        "https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ffc7/00000000001d40bb",
    category = "Kick Start",
    subCategory = "2020",
    solved = false)
public class Solution {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int cases = in.nextInt();

      for (int caze = 1; caze <= cases; ++caze) {
        int numberOfStacks = in.nextInt();
        int platesPerStack = in.nextInt();
        int platesWanted = in.nextInt();

        int[][] stacks = new int[numberOfStacks + 1][platesPerStack + 1];
        for (int stack = 1; stack <= numberOfStacks; ++stack) {
          for (int plate = 1; plate <= platesPerStack; ++plate) {
            stacks[stack][plate] = in.nextInt();
          }
        }

        int[][] sum = new int[numberOfStacks + 1][platesPerStack + 1];
        for (int stack = 1; stack <= numberOfStacks; ++stack) {
          for (int plate = 1; plate <= platesPerStack; ++plate) {
            sum[stack][plate] = stacks[stack][plate] + sum[stack][plate - 1];
          }
        }

        int[][] maxSum = new int[numberOfStacks + 1][platesWanted + 1];
        for (int stack = 1; stack <= numberOfStacks; ++stack) {
          for (int plate = 0; plate <= platesWanted; ++plate) {
            maxSum[stack][plate] = 0;
            for (int potentialPlates = 0;
                potentialPlates <= Math.min(plate, platesPerStack);
                ++potentialPlates) {
              maxSum[stack][plate] =
                  Math.max(
                      maxSum[stack][plate],
                      sum[stack][potentialPlates] + maxSum[stack - 1][plate - potentialPlates]);
            }
          }
        }

        System.out.printf("Case #%d: %d%n", caze, maxSum[numberOfStacks][platesWanted]);
      }
    }
  }
}
