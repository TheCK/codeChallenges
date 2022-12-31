package org.ck.hackerrank.corecs.algorithms.implementation.appleandorange;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 10202,
    name = "Apple and Orange",
    url = "https://www.hackerrank.com/challenges/apple-and-orange",
    category = "Algorithms",
    subCategory = "Implementation")
public class Solution {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int s = in.nextInt();
      int t = in.nextInt();

      int a = in.nextInt();
      int b = in.nextInt();

      int m = in.nextInt();
      int n = in.nextInt();

      int applesOnRoof = 0;
      for (int i = 0; i < m; ++i) {
        int position = a + in.nextInt();

        if (position >= s && position <= t) {
          ++applesOnRoof;
        }
      }
      System.out.println(applesOnRoof);

      int orangesOnRoof = 0;
      for (int i = 0; i < n; ++i) {
        int position = b + in.nextInt();

        if (position >= s && position <= t) {
          ++orangesOnRoof;
        }
      }
      System.out.println(orangesOnRoof);
    }
  }
}
