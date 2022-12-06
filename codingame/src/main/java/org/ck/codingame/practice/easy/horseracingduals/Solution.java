package org.ck.codingame.practice.easy.horseracingduals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 101010,
    name = "Horse-racing Duals",
    url = "https://www.codingame.com/ide/puzzle/horse-racing-duals",
    category = "Practice",
    subCategory = "Easy")
public class Solution {
  public static void main(String args[]) {
    try (Scanner in = new Scanner(System.in)) {
      int horses = in.nextInt();
      List<Integer> powers = new ArrayList<>();
      for (int i = 0; i < horses; i++) {
        powers.add(in.nextInt());
      }

      Collections.sort(powers);

      int difference = Integer.MAX_VALUE;
      for (int i = 1; i < powers.size(); ++i) {
        if (powers.get(i) - powers.get(i - 1) < difference) {
          difference = powers.get(i) - powers.get(i - 1);
        }
      }

      System.out.println(difference);
    }
  }
}
