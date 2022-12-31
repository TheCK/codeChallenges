package org.ck.codeeval.medium.alternativereality;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 223,
    name = "Alternative reality",
    description = "Count all alternative ways.",
    url = "https://www.codeeval.com/open_challenges/223/",
    category = "Moderate challenges")
public class Main {
  private static final int[] coins = new int[] {50, 25, 10, 5, 1};

  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        int value = Integer.parseInt(line);

        int realities = count(value, 50);

        System.out.println(realities);
      }
    }
  }

  private static int count(int value, int lastCoin) {
    if (value == 0) {
      return 1;
    }

    int realities = 0;

    for (int coin : coins) {
      if (coin <= value && coin <= lastCoin) {
        realities += count(value - coin, coin);
      }
    }

    return realities;
  }
}
