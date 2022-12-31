package org.ck.adventofcode.year2021.day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20210501,
    name = "Day 5: Hydrothermal Venture",
    url = "https://adventofcode.com/2021/day/5",
    category = "2021")
public class Part1 {
  public static void main(String[] args) {
    List<Line> lines = new ArrayList<>();
    int maxX = 0;
    int maxY = 0;

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        final String[] split = in.nextLine().split(" -> ");
        final String[] start = split[0].split(",");
        final String[] end = split[1].split(",");

        final int startX = Integer.parseInt(start[0]);
        final int startY = Integer.parseInt(start[1]);

        final int endX = Integer.parseInt(end[0]);
        final int endY = Integer.parseInt(end[1]);

        lines.add(new Line(new Point(startX, startY), new Point(endX, endY)));

        maxX = Math.max(maxX, startX);
        maxX = Math.max(maxX, endX);

        maxY = Math.max(maxY, startY);
        maxY = Math.max(maxY, endY);
      }
    }

    int[][] vents = new int[maxY + 1][maxX + 1];

    for (Line line : lines) {
      if (line.getStart().getX() == line.getEnd().getX()) {
        for (int y = Math.min(line.getStart().getY(), line.getEnd().getY());
            y <= Math.max(line.getStart().getY(), line.getEnd().getY());
            ++y) {
          ++vents[y][line.getStart().getX()];
        }
      } else if (line.getStart().getY() == line.getEnd().getY()) {
        for (int x = Math.min(line.getStart().getX(), line.getEnd().getX());
            x <= Math.max(line.getStart().getX(), line.getEnd().getX());
            ++x) {
          ++vents[line.getStart().getY()][x];
        }
      }
    }

    System.out.println(
        Arrays.stream(vents).flatMapToInt(Arrays::stream).filter(value -> value >= 2).count());
  }

  private static final class Line {
    Point start;
    Point end;

    public Line(final Point start, final Point end) {
      this.start = start;
      this.end = end;
    }

    public Point getStart() {
      return start;
    }

    public Point getEnd() {
      return end;
    }
  }

  private static final class Point {
    int x;
    int y;

    public Point(final int x, final int y) {
      this.x = x;
      this.y = y;
    }

    public int getX() {
      return x;
    }

    public int getY() {
      return y;
    }
  }
}
