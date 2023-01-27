package org.ck.adventofcode.year2021.day15;

import java.util.*;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20211501,
    name = "Day 15: Chiton",
    url = "https://adventofcode.com/2021/day/15",
    category = "2021")
public class Part1 {
  public static void main(String[] args) {
    List<int[]> grid = new ArrayList<>();

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        grid.add(Arrays.stream(in.nextLine().split("")).mapToInt(Integer::parseInt).toArray());
      }
    }

    System.out.println(findRoute(grid));
  }

  private static int findRoute(final List<int[]> grid) {
    final Map<Point, Integer> distance = new HashMap<>();
    distance.put(new Point(0, 0), 0);

    Queue<Point> queue = new PriorityQueue<>(Comparator.comparingInt(distance::get));

    for (int i = 0; i < grid.size(); ++i) {
      for (int j = 0; j < grid.get(i).length; ++j) {
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
        int danger = distance.get(candidate) + grid.get(neighbour.y())[neighbour.x()];
        if (danger < distance.get(neighbour)) {
          distance.put(neighbour, danger);
          queue.remove(neighbour);
          queue.add(neighbour);
        }
      }
    }

    return distance.get(new Point(grid.get(0).length - 1, grid.size() - 1));
  }

  private static List<Point> getNeighbours(final Point point, final List<int[]> grid) {
    List<Point> neighbours = new ArrayList<>();

    if (point.x() > 0) {
      neighbours.add(new Point(point.x() - 1, point.y()));
    }
    if (point.y() > 0) {
      neighbours.add(new Point(point.x(), point.y() - 1));
    }
    if (point.x() < grid.get(0).length - 1) {
      neighbours.add(new Point(point.x() + 1, point.y()));
    }
    if (point.y() < grid.size() - 1) {
      neighbours.add(new Point(point.x(), point.y() + 1));
    }

    return neighbours;
  }

  private static final record Point(int x, int y) {}
}
