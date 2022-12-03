package org.ck.codingame.practice.easy.thedescent;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.Scanner;

@Solution(
    id = 101002,
    name = "The Descent",
    url = "https://www.codingame.com/ide/puzzle/the-descent",
    category = "Practice",
    subCategory = "Easy")
public class Player {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {

      while (true) {
        int maxHeight = 0;
        int maxIndex = 0;
        for (int i = 0; i < 8; i++) {
          int mountainHeight = in.nextInt();

          if (mountainHeight > maxHeight) {
            maxHeight = mountainHeight;
            maxIndex = i;
          }
        }

        System.out.println(maxIndex);
      }
    }
  }
}
