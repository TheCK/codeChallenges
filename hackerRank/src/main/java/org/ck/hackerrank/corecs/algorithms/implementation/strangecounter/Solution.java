package org.ck.hackerrank.corecs.algorithms.implementation.strangecounter;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 10253,
    name = "Strange Counter",
    url = "https://www.hackerrank.com/challenges/strange-code",
    category = "Algorithms",
    subCategory = "Implementation")
public class Solution {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      long time = in.nextLong();
      long currentInital = 3;
      long timeRemaining = time;

      while (timeRemaining > currentInital) {
        timeRemaining -= currentInital;
        currentInital *= 2;
      }

      System.out.println(currentInital - timeRemaining + 1);
    }
  }
}
