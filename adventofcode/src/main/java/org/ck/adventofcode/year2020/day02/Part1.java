package org.ck.adventofcode.year2020.day02;

import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20200201,
    name = "Day 2: Password Philosophy",
    url = "https://adventofcode.com/2020/day/2",
    category = "2020")
public class Part1 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int count = 0;

      while (in.hasNextLine()) {
        String[] line = in.nextLine().split(" ");

        int diff = line[2].length() - line[2].replaceAll(line[1].substring(0, 1), "").length();

        String[] limits = line[0].split("-");
        int lower = Integer.parseInt(limits[0]);
        int upper = Integer.parseInt(limits[1]);

        if (lower <= diff && diff <= upper) {
          ++count;
        }
      }

      System.out.println(count);
    }
  }
}
