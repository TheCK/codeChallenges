package org.ck.adventofcode.year2022.day14;

import org.ck.codechallengelib.annotation.Solution;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@Solution(
    id = 20221401,
    name = "Day 14: Regolith Reservoir",
    url = "https://adventofcode.com/2022/day/14",
    category = "2022")
public class Part1 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      Set<Point> blocked = new HashSet<>();
      int maxY = 0;

      while (in.hasNextLine()) {
        String[] points = in.nextLine().split(" -> ");

        String[] startCoordinates = points[0].split(",");
        int startX = Integer.parseInt(startCoordinates[0]);
        int startY = Integer.parseInt(startCoordinates[1]);

        for (int i = 1; i < points.length; ++i) {
          String[] coordinates = points[i].split(",");

          int endX = Integer.parseInt(coordinates[0]);
          int endY = Integer.parseInt(coordinates[1]);

          for (int x = Math.min(startX, endX); x <= Math.max(startX, endX); ++x) {
            for (int y = Math.min(startY, endY); y <= Math.max(startY, endY); ++y) {
              maxY = Math.max(maxY, y);
              blocked.add(new Point(x, y));
            }
          }

          startX = endX;
          startY = endY;
        }
      }

      int settled = 0;
      while (true) {
        Point sand = new Point(500, 0);

        while (true) {
          Point newPoint = new Point(sand.x(), sand.y() + 1);

          if (newPoint.y() > maxY) {
            break;
          }

          if (!blocked.contains(newPoint)) {
            sand = newPoint;
            continue;
          }

          newPoint = new Point(sand.x() - 1, sand.y() + 1);
          if (!blocked.contains(newPoint)) {
            sand = newPoint;
            continue;
          }

          newPoint = new Point(sand.x() + 1, sand.y() + 1);
          if (!blocked.contains(newPoint)) {
            sand = newPoint;
            continue;
          }

          break;
        }

        if (sand.y() == maxY) {
          break;
        }

        ++settled;
        blocked.add(sand);
      }

      System.out.println(settled);
    }
  }

  record Point(int x, int y) {}
}
