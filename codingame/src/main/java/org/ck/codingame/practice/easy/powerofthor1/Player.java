package org.ck.codingame.practice.easy.powerofthor1;

import org.ck.codechallengelib.annotation.Solution;

import java.util.Scanner;

@Solution(
    id = 101003,
    name = "Power of Thor - Episode 1",
    url = "https://www.codingame.com/ide/puzzle/power-of-thor-episode-1",
    category = "Practice",
    subCategory = "Easy")
public class Player {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int lightX = in.nextInt();
      int lightY = in.nextInt();
      int initialTx = in.nextInt();
      int initialTy = in.nextInt();

      int diffX = lightX - initialTx;
      int diffY = lightY - initialTy;

      while (true) {
        int remainingTurns = in.nextInt();

        StringBuilder direction = new StringBuilder();
        if (diffY < 0) {
          direction.append("N");
          ++diffY;
        } else if (diffY > 0) {
          direction.append("S");
          --diffY;
        }

        if (diffX < 0) {
          direction.append("W");
          ++diffX;
        } else if (diffX > 0) {
          direction.append("E");
          --diffX;
        }

        if (direction.length() > 0) {
          System.out.println(direction);
        }
      }
    }
  }
}
