package org.ck.adventofcode.year2015.day03;

import org.ck.codechallengelib.annotation.Solution;

import java.util.*;

@Solution(
    id = 20150302,
    name = "Day 3: Perfectly Spherical Houses in a Vacuum - Part 2",
    url = "https://adventofcode.com/2015/day/3#part2",
    category = "2015")
public class Part2 {
  public static void main(String[] args) {
    List<String> commands = new ArrayList<>();

    try (Scanner in = new Scanner(System.in)) {
      String line = in.nextLine();

      StringBuilder santa = new StringBuilder();
      StringBuilder robo = new StringBuilder();
      int index = 0;

      for (char command : line.toCharArray()) {
        if (index % 2 == 0) {
          santa.append(command);
        } else {
          robo.append(command);
        }

        ++index;
      }

      commands.add(santa.toString());
      commands.add(robo.toString());
    }

    Set<Point> houses = new HashSet<>();

    for (String commandLine : commands) {
      int x = 0;
      int y = 0;

      houses.add(new Point(x, y));
      for (char command : commandLine.toCharArray()) {
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
