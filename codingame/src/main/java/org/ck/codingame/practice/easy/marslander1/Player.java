package org.ck.codingame.practice.easy.marslander1;

import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

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
        in.nextInt();
        in.nextInt();
      }

      while (true) {
        in.nextInt();
        in.nextInt();
        in.nextInt();
        int vSpeed = in.nextInt();
        in.nextInt();
        in.nextInt();
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
