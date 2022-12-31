package org.ck.adventofcode.year2015.day02;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20150202,
    name = "Day 2: I Was Told There Would Be No Math - Part 2",
    url = "https://adventofcode.com/2015/day/2#part2",
    category = "2015")
public class Part2 {
  public static void main(String[] args) {
    int length = 0;

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String[] dimensions = in.nextLine().split("x");

        int l = Integer.parseInt(dimensions[0]);
        int w = Integer.parseInt(dimensions[1]);
        int h = Integer.parseInt(dimensions[2]);

        List<Integer> lengths = Arrays.asList(l, w, h);
        Collections.sort(lengths);

        int s = lengths.get(0);
        int m = lengths.get(1);

        length += 2 * s + 2 * m + l * w * h;
      }
    }

    System.out.println(length);
  }
}
