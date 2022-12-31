package org.ck.adventofcode.year2016.day03;

import org.ck.codechallengelib.annotation.Solution;

import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;

@Solution(
    id = 20160301,
    name = "Day 3: Squares With Three Sides",
    url = "https://adventofcode.com/2016/day/3",
    category = "2016")
public class Part1 {
  public static void main(String[] args) {
    int count = 0;

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextInt()) {
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        int s = min(min(a, b), c);
        int m = max(min(a, b), min(max(a, b), c));
        int l = max(max(a, b), c);

        if (s + m > l) {
          ++count;
        }
      }
    }

    System.out.println(count);
  }
}
