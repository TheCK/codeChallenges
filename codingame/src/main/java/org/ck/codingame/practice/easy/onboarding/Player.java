package org.ck.codingame.practice.easy.onboarding;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.Scanner;

@Solution(
    id = 101001,
    name = "Onboarding",
    url = "https://www.codingame.com/ide/puzzle/onboarding",
    category = "Practice",
    subCategory = "Easy")
public class Player {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    while (true) {
      String enemy1 = in.next(); // name of enemy 1
      int dist1 = in.nextInt(); // distance to enemy 1
      String enemy2 = in.next(); // name of enemy 2
      int dist2 = in.nextInt(); // distance to enemy 2

      System.out.println(dist1 < dist2 ? enemy1 : enemy2);
    }
  }
}
