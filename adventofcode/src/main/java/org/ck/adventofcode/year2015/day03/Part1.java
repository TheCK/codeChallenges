package org.ck.adventofcode.year2015.day03;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

@Solution(
    id = 20150301,
    name = "Day 3: Perfectly Spherical Houses in a Vacuum",
    url = "https://adventofcode.com/2015/day/3",
    category = "2015")
public class Part1 {
  public static void main(String[] args) {
    Set<Point> houses = new HashSet<>();
    int x = 0;
    int y = 0;

    houses.add(new Point(x, y));
    try (Scanner in = new Scanner(System.in)) {
      String line = in.nextLine();

      for (char command : line.toCharArray()) {
        switch (command) {
          case '^' -> ++y;
          case '>' -> ++x;
          case 'v' -> --y;
          case '<' -> --x;
          default -> throw new RuntimeException();
        }

        houses.add(new Point(x, y));
      }
    }

    System.out.println(houses.size());
  }

  private static final class Point {
    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Point point = (Point) o;
      return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }
}
