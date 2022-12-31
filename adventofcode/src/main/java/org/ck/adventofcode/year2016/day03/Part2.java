package org.ck.adventofcode.year2016.day03;

import org.ck.codechallengelib.annotation.Solution;

import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;

@Solution(
    id = 20160302,
    name = "Day 3: Squares With Three Sides - Part 2",
    url = "https://adventofcode.com/2016/day/3#part2",
    category = "2016")
public class Part2 {
  public static void main(String[] args) {
    int count = 0;

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextInt()) {
        int a1 = in.nextInt();
        int b1 = in.nextInt();
        int c1 = in.nextInt();

        int a2 = in.nextInt();
        int b2 = in.nextInt();
        int c2 = in.nextInt();

        int a3 = in.nextInt();
        int b3 = in.nextInt();
        int c3 = in.nextInt();

        count += validTriangle(a1, a2, a3) + validTriangle(b1, b2, b3) + validTriangle(c1, c2, c3);
      }
    }

    System.out.println(count);
  }

  private static int validTriangle(int a, int b, int c) {
    int s = min(min(a, b), c);
    int m = max(min(a, b), min(max(a, b), c));
    int l = max(max(a, b), c);

    return (s + m > l) ? 1 : 0;
  }
}
