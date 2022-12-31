package org.ck.adventofcode.year2015.day02;

import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20150201,
    name = "Day 2: I Was Told There Would Be No Math",
    url = "https://adventofcode.com/2015/day/2",
    category = "2015")
public class Part1 {
  public static void main(String[] args) {
    int area = 0;

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String[] dimensions = in.nextLine().split("x");

        int l = Integer.parseInt(dimensions[0]);
        int w = Integer.parseInt(dimensions[1]);
        int h = Integer.parseInt(dimensions[2]);

        int lw = l * w;
        int lh = l * h;
        int wh = w * h;

        int min = Math.min(Math.min(lw, lh), wh);

        area += 2 * lw + 2 * lh + 2 * wh + min;
      }
    }

    System.out.println(area);
  }
}
