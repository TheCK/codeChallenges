package org.ck.adventofcode.year2025;

import java.util.*;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20250401,
    name = "Day 4: Printing Department",
    url = "https://adventofcode.com/2025/day/4",
    category = "2025")
@Solution(
    id = 20250402,
    name = "Day 4: Printing Department - Part 2",
    url = "https://adventofcode.com/2025/day/4#part2",
    category = "2025")
public class Day04 extends AOCSolution {

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, false);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, true);
  }

  private void run(final Scanner in, final boolean repeat) {
    final List<String> rows = new ArrayList<>();

    while (in.hasNextLine()) {
      rows.add(in.nextLine());
    }

    final boolean[][] done = new boolean[rows.size()][rows.getFirst().length()];
    final Queue<Coordinate> queue = new ArrayDeque<>(getInitialEmptyCoordinates(rows));

    int movable = 0;
    while (!queue.isEmpty()) {
      final Coordinate coordinate = queue.poll();
      if (done[coordinate.x][coordinate.y]) {
        continue;
      }

      final char current = rows.get(coordinate.x).charAt(coordinate.y);
      final Set<Coordinate> neighbours = getNeighbours(done, coordinate, rows, repeat);
      if (current == '.') {
        queue.addAll(neighbours);
        done[coordinate.x][coordinate.y] = true;
      } else {
        if (neighbours.size() < 4) {
          ++movable;
          done[coordinate.x][coordinate.y] = true;
          if (repeat) {
            queue.addAll(neighbours);
          }
        } else {
          done[coordinate.x][coordinate.y] = !repeat;
        }
      }
    }

    print(movable);
  }

  private static List<Coordinate> getInitialEmptyCoordinates(final List<String> rows) {
    final List<Coordinate> coordinates = new ArrayList<>();
    for (int i = 0; i < rows.size(); ++i) {
      for (int j = 0; j < rows.get(i).length(); ++j) {
        if (rows.get(i).charAt(j) == '.') {
          coordinates.add(new Coordinate(i, j));
        }
      }
    }

    return coordinates;
  }

  private Set<Coordinate> getNeighbours(
      final boolean[][] done,
      final Coordinate coordinate,
      final List<String> rows,
      final boolean repeat) {
    final Set<Coordinate> neighbours = new HashSet<>();

    for (int x = Math.max(coordinate.x - 1, 0);
        x <= Math.min(coordinate.x + 1, done.length - 1);
        ++x) {
      for (int y = Math.max(coordinate.y - 1, 0);
          y <= Math.min(coordinate.y + 1, done[coordinate.x].length - 1);
          ++y) {
        if ((x != coordinate.x || y != coordinate.y)
            && rows.get(x).charAt(y) == '@'
            && (!done[x][y] || !repeat)) {
          neighbours.add(new Coordinate(x, y));
        }
      }
    }

    return neighbours;
  }

  private record Coordinate(int x, int y) {}
}
