package org.ck.codingame.practice.easy.onboarding;

import org.ck.codechallengelib.annotation.Solution;

import java.util.Scanner;

@Solution(
    id = 101001,
    name = "Onboarding",
    url = "https://www.codingame.com/ide/puzzle/onboarding",
    category = "Practice",
    subCategory = "Easy")
public class Player {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {

      while (true) {
        String enemy1 = in.next();
        int dist1 = in.nextInt();
        String enemy2 = in.next();
        int dist2 = in.nextInt();

        System.out.println(dist1 < dist2 ? enemy1 : enemy2);
      }
    }
  }
}
