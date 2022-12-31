package org.ck.adventofcode.year2016.day24;

import java.util.*;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20162401,
    name = "Day 24: Air Duct Spelunking",
    url = "https://adventofcode.com/2016/day/24",
    category = "2016",
    solved = false)
public class Part1 {
  public static void main(String[] args) {
    List<char[]> grid = new ArrayList<>();

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        grid.add(in.nextLine().toCharArray());
      }
    }

    List<Target> wanted = new ArrayList<>();
    for (int y = 0; y < grid.size(); ++y) {
      for (int x = 0; x < grid.get(y).length; ++x) {
        char field = grid.get(y)[x];

        if (field != '.' && field != '#') {
          wanted.add(new Target(field, new Coordinate(x, y)));
        }
      }
    }

    for (int i = 0; i < wanted.size(); ++i) {
      for (int j = i + 1; j < wanted.size(); ++j) {
        int steps = findPathLength(grid, wanted.get(i).coordinate(), wanted.get(j).coordinate);

        System.out.printf("%s-%s: %d%n", wanted.get(i).name(), wanted.get(j).name(), steps);
      }
    }
  }

  private static int findPathLength(
      final List<char[]> grid, final Coordinate start, final Coordinate end) {
    Queue<State> queue =
        new PriorityQueue<>(
            (s1, s2) -> {
              if (s1.history().size() < s2.history().size()) {
                return -1;
              }

              if (s1.history().size() > s2.history().size()) {
                return 1;
              }

              int d1 =
                  Math.abs(end.x() - s1.coordinate().x()) + Math.abs(end.y() - s1.coordinate().y());
              int d2 =
                  Math.abs(end.x() - s2.coordinate().x()) + Math.abs(end.y() - s2.coordinate().y());

              return Integer.compare(d1, d2);
            });
    queue.add(new State(start, new HashSet<>()));

    while (!queue.isEmpty()) {
      State state = queue.poll();
      Coordinate coordinate = state.coordinate();

      Set<Coordinate> newHistory = new HashSet<>(state.history());
      newHistory.add(coordinate);

      if (coordinate.equals(end)) {
        return state.history.size();
      }

      Coordinate up = new Coordinate(coordinate.x(), coordinate.y() - 1);
      if (grid.get(up.y())[up.x()] != '#' && !newHistory.contains(up)) {
        queue.add(new State(up, newHistory));
      }

      Coordinate down = new Coordinate(coordinate.x(), coordinate.y() + 1);
      if (grid.get(down.y())[down.x()] != '#' && !newHistory.contains(down)) {
        queue.add(new State(down, newHistory));
      }

      Coordinate left = new Coordinate(coordinate.x() - 1, coordinate.y());
      if (grid.get(left.y())[left.x()] != '#' && !newHistory.contains(left)) {
        queue.add(new State(left, newHistory));
      }

      Coordinate right = new Coordinate(coordinate.x() + 1, coordinate.y());
      if (grid.get(right.y())[right.x()] != '#' && !newHistory.contains(right)) {
        queue.add(new State(right, newHistory));
      }
    }

    return Integer.MAX_VALUE;
  }

  private static String print(final List<char[]> grid, State state) {
    StringBuilder builder = new StringBuilder();

    for (int j = 0; j < grid.size(); ++j) {
      for (int i = 0; i < grid.get(j).length; ++i) {
        if (state.history().contains(new Coordinate(i, j))) {
          builder.append('O');
        } else {
          builder.append(grid.get(j)[i]);
        }
      }

      builder.append(System.lineSeparator());
    }

    return builder.toString();
  }

  private record Target(char name, Coordinate coordinate) {}

  private record Coordinate(int x, int y) {}

  private record State(Coordinate coordinate, Set<Coordinate> history) {}
}
