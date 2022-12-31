package org.ck.adventofcode.year2015.day01;

import org.ck.codechallengelib.annotation.Solution;

import java.util.Scanner;

@Solution(
    id = 20150101,
    name = "Day 1: Not Quite Lisp",
    url = "https://adventofcode.com/2015/day/1",
    category = "2015")
public class Part1 {
  public static void main(String[] args) {
    int floor = 0;

    try (Scanner in = new Scanner(System.in)) {
      String path = in.nextLine();

      for(char command : path.toCharArray()) {
        floor += command == '(' ? 1 : -1;
      }
    }

    System.out.println(floor);
  }
}
