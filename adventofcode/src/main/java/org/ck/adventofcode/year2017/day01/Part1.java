package org.ck.adventofcode.year2017.day01;

import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20170101,
    name = "Day 1: Inverse Captcha",
    url = "https://adventofcode.com/2017/day/1",
    category = "2017")
public class Part1 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      String captcha = in.nextLine();

      long sum = 0;

      for (int i = 0; i < captcha.length(); ++i) {
        if (captcha.charAt(i) == captcha.charAt((i + 1) % captcha.length())) {
          sum += captcha.charAt(i) - '0';
        }
      }

      System.out.println(sum);
    }
  }
}
