package org.ck.adventofcode.year2021.day15;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.*;

@Solution(
    id = 20211502,
    name = "Day 15: Chiton - Part 2",
    url = "https://adventofcode.com/2021/day/15#part2",
    category = "2021")
public class Part2 {
  public static void main(String[] args) {
    List<int[]> grid = new ArrayList<>();

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        grid.add(Arrays.stream(in.nextLine().split("")).mapToInt(Integer::parseInt).toArray());
      }
    }

    int[][] bigGrid = new int[grid.size() * 5][grid.get(0).length * 5];

    for (int y = 0; y < grid.size(); ++y) {
      for (int x = 0; x < grid.get(y).length; ++x) {
        for (int yFactor = 0; yFactor < 5; ++yFactor) {
          for (int xFactor = 0; xFactor < 5; ++xFactor) {
            int value = grid.get(y)[x] + yFactor + xFactor;
            while (value > 9) {
              value -= 9;
            }

            bigGrid[y + grid.size() * yFactor][x + grid.get(y).length * xFactor] = value;
          }
        }
      }
    }

    System.out.println(findRoute(bigGrid));
  }

  private static int findRoute(final int[][] grid) {
    final Map<Point, Integer> distance = new HashMap<>();
    distance.put(new Point(0, 0), 0);

    Queue<Point> queue = new PriorityQueue<>(Comparator.comparingInt(distance::get));

    for (int i = 0; i < grid.length; ++i) {
      for (int j = 0; j < grid[i].length; ++j) {
        Point point = new Point(j, i);
        if (i != 0 || j != 0) {
          distance.put(point, Integer.MAX_VALUE);
        }

        queue.add(point);
      }
    }

    while (!queue.isEmpty()) {
      Point candidate = queue.poll();
      for (Point neighbour : getNeighbours(candidate, grid)) {
        int danger = distance.get(candidate) + grid[neighbour.y()][neighbour.x()];
        if (danger < distance.get(neighbour)) {
          distance.put(neighbour, danger);
          queue.remove(neighbour);
          queue.add(neighbour);
        }
      }
    }

    return distance.get(new Point(grid[0].length - 1, grid.length - 1));
  }

  private static List<Point> getNeighbours(final Point point, final int[][] grid) {
    List<Point> neighbours = new ArrayList<>();

    if (point.x() > 0) {
      neighbours.add(new Point(point.x() - 1, point.y()));
    }
    if (point.y() > 0) {
      neighbours.add(new Point(point.x(), point.y() - 1));
    }
    if (point.x() < grid[0].length - 1) {
      neighbours.add(new Point(point.x() + 1, point.y()));
    }
    if (point.y() < grid.length - 1) {
      neighbours.add(new Point(point.x(), point.y() + 1));
    }

    return neighbours;
  }

  private static final record Point(int x, int y) {}
}
