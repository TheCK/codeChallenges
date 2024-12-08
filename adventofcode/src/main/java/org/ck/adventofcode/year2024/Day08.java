package org.ck.adventofcode.year2024;

import java.util.*;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20240801,
    name = "Day 8: Resonant Collinearity",
    url = "https://adventofcode.com/2024/day/8",
    category = "2024")
@Solution(
    id = 20240802,
    name = "Day 8: Resonant Collinearity - Part 2",
    url = "https://adventofcode.com/2024/day/8#part2",
    category = "2024")
public class Day08 extends AOCSolution {

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, 1, 1);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, 0, Integer.MAX_VALUE);
  }

  private void run(final Scanner in, final int startCoefficient, final int endCoefficient) {
    final Map<Character, List<Coordinate>> towers = new HashMap<>();
    int rowCount = 0;
    int columnCount = 0;

    while (in.hasNextLine()) {
      final String line = in.nextLine();
      columnCount = line.length();

      for (int column = 0; column < columnCount; ++column) {
        final char c = line.charAt(column);

        if (c != '.') {
          towers.computeIfAbsent(c, k -> new ArrayList<>()).add(new Coordinate(column, rowCount));
        }
      }

      ++rowCount;
    }

    final Set<Coordinate> antinodes = new HashSet<>();

    for (List<Coordinate> coordinates : towers.values()) {
      for (int i = 0; i < coordinates.size(); ++i) {
        for (int j = i + 1; j < coordinates.size(); ++j) {
          final int deltaX = coordinates.get(i).x() - coordinates.get(j).x();
          final int deltaY = coordinates.get(i).y() - coordinates.get(j).y();

          for (Tower tower :
              List.of(new Tower(coordinates.get(i), 1), new Tower(coordinates.get(j), -1))) {
            for (int coefficient = startCoefficient; coefficient <= endCoefficient; ++coefficient) {
              final Coordinate antinode =
                  new Coordinate(
                      tower.coordinate().x() + tower.offsetDirection() * coefficient * deltaX,
                      tower.coordinate().y() + tower.offsetDirection() * coefficient * deltaY);

              if (isOutOfBound(antinode, columnCount, rowCount)) {
                break;
              }

              antinodes.add(antinode);
            }
          }
        }
      }
    }

    print(antinodes.size());
  }

  private static boolean isOutOfBound(
      final Coordinate antinode, final int columnCount, final int rowCount) {
    return antinode.x() < 0
        || antinode.y() < 0
        || antinode.x() >= columnCount
        || antinode.y() >= rowCount;
  }

  private record Coordinate(int x, int y) {}

  private record Tower(Coordinate coordinate, int offsetDirection) {}
}
