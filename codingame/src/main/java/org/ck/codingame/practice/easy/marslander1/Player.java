package org.ck.codingame.practice.easy.marslander1;

import org.ck.codechallengelib.annotation.Solution;

import java.util.Scanner;

@Solution(
    id = 101005,
    name = "Mars Lander - Episode 1",
    url = "https://www.codingame.com/ide/puzzle/mars-lander-episode-1",
    category = "Practice",
    subCategory = "Easy")
public class Player {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int surfaceN = in.nextInt();
      for (int i = 0; i < surfaceN; i++) {
        int landX = in.nextInt();
        int landY = in.nextInt();
      }

      while (true) {
        int X = in.nextInt();
        int Y = in.nextInt();
        int hSpeed = in.nextInt();
        int vSpeed = in.nextInt();
        int fuel = in.nextInt();
        int rotate = in.nextInt();
        int power = in.nextInt();

        if (vSpeed < -30) {
          ++power;
        } else if (vSpeed > -10) {
          --power;
        }

        power = Math.min(power, 4);
        power = Math.max(power, 0);

        System.out.println("0 " + power);
      }
    }
  }
}
