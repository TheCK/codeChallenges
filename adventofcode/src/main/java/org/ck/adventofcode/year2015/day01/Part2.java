package org.ck.adventofcode.year2015.day01;

import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20150102,
    name = "Day 1: Not Quite Lisp - Part 2",
    url = "https://adventofcode.com/2015/day/1#part2",
    category = "2015")
public class Part2 {
  public static void main(String[] args) {
    int floor = 0;
    int position = 1;

    try (Scanner in = new Scanner(System.in)) {
      String path = in.nextLine();

      for (char command : path.toCharArray()) {
        floor += command == '(' ? 1 : -1;

        if (floor < 0) {
          System.out.println(position);
          return;
        }

        ++position;
      }
    }
  }
}
