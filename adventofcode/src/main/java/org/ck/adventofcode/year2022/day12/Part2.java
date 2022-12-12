package org.ck.adventofcode.year2022.day12;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.*;

@Solution(
    id = 20221202,
    name = "Day 12: Hill Climbing Algorithm - Part 2",
    url = "https://adventofcode.com/2022/day/12#part2",
    category = "2022")
public class Part2 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      List<List<Integer>> grid = new ArrayList<>();

      while (in.hasNextLine()) {
        grid.add(new ArrayList<>(in.nextLine().chars().boxed().toList()));
      }

      List<Point> starts = new ArrayList<>();

      Point end = null;

      for (int y = 0; y < grid.size(); ++y) {
        for (int x = 0; x < grid.get(y).size(); ++x) {
          if (grid.get(y).get(x) == 'S') {
            starts.add(new Point(x, y, 0));
            grid.get(y).set(x, (int) 'a');
          } else if (grid.get(y).get(x) == 'a') {
            starts.add(new Point(x, y, 0));
          } else if (grid.get(y).get(x) == 'E') {
            end = new Point(x, y, -1);
            grid.get(y).set(x, (int) 'z');
          }
        }
      }

      int minDistance = Integer.MAX_VALUE;
      for (Point start : starts) {
        int[][] distances = new int[grid.size()][grid.get(0).size()];

        for (int y = 0; y < grid.size(); ++y) {
          for (int x = 0; x < grid.get(y).size(); ++x) {
            distances[y][x] = Integer.MAX_VALUE;
          }
        }

        PriorityQueue<Point> queue = new PriorityQueue<>(Comparator.comparingInt(Point::steps));
        queue.add(start);

        int distance = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
          Point current = queue.poll();
          if (current.steps() >= distances[current.y()][current.x()]) {
            continue;
          }

          distances[current.y()][current.x()] = current.steps();

          if (current.x() == end.x() && current.y() == end.y()) {
            distance = current.steps();
            break;
          }

          if (current.x() > 0
              && grid.get(current.y()).get(current.x() - 1)
                  <= (grid.get(current.y()).get(current.x()) + 1)) {
            queue.add(new Point(current.x() - 1, current.y(), current.steps() + 1));
          }
          if (current.x() < grid.get(current.y()).size() - 1
              && grid.get(current.y()).get(current.x() + 1)
                  <= (grid.get(current.y()).get(current.x()) + 1)) {
            queue.add(new Point(current.x() + 1, current.y(), current.steps() + 1));
          }
          if (current.y() > 0
              && grid.get(current.y() - 1).get(current.x())
                  <= (grid.get(current.y()).get(current.x()) + 1)) {
            queue.add(new Point(current.x(), current.y() - 1, current.steps() + 1));
          }
          if (current.y() < grid.size() - 1
              && grid.get(current.y() + 1).get(current.x())
                  <= (grid.get(current.y()).get(current.x()) + 1)) {
            queue.add(new Point(current.x(), current.y() + 1, current.steps() + 1));
          }
        }

        minDistance = Math.min(minDistance, distance);
      }

      System.out.println(minDistance);
    }
  }

  record Point(int x, int y, int steps) {}
}
