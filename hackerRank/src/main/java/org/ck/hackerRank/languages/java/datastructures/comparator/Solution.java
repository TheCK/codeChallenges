package org.ck.hackerRank.languages.java.datastructures.comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40204011,
    name = "Java Comparator",
    url = "https://www.hackerrank.com/challenges/java-comparator",
    category = "Java",
    subCategory = "Data Structures")
public class Solution {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();

      Player[] player = new Player[n];
      Checker checker = new Checker();

      for (int i = 0; i < n; i++) {
        player[i] = new Player(in.next(), in.nextInt());
      }

      Arrays.sort(player, checker);
      for (int i = 0; i < player.length; i++) {
        System.out.printf("%s %s\n", player[i].name, player[i].score);
      }
    }
  }

  private static class Player {
    String name;
    int score;

    Player(String name, int score) {
      this.name = name;
      this.score = score;
    }
  }

  private static class Checker implements Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2) {
      if (p1.score != p2.score) {
        return p2.score - p1.score;
      }

      return p1.name.compareTo(p2.name);
    }
  }
}
