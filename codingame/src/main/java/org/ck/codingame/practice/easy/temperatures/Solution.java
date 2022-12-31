package org.ck.codingame.practice.easy.temperatures;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 101004,
    name = "Temperatures",
    url = "https://www.codingame.com/ide/puzzle/temperatures",
    category = "Practice",
    subCategory = "Easy")
public class Solution {
  public static void main(String args[]) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();

      Integer closest = null;
      for (int i = 0; i < n; i++) {
        int t = in.nextInt();

        if (closest == null
            || Math.abs(t) < Math.abs(closest)
            || (Math.abs(t) == Math.abs(closest) && t > closest)) {
          closest = t;
        }
      }

      System.out.println(closest != null ? closest : 0);
    }
  }
}
