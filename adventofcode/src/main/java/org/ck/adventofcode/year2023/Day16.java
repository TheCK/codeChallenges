package org.ck.adventofcode.year2023;

import java.util.*;
import java.util.function.Function;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20231601,
    name = "Day 16: The Floor Will Be Lava",
    url = "https://adventofcode.com/2023/day/16",
    category = "2023")
@Solution(
    id = 20231602,
    name = "Day 16: The Floor Will Be Lava - Part 2",
    url = "https://adventofcode.com/2023/day/16#part2",
    category = "2023")
public class Day16 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, grid -> Set.of(new Beam(new Position(0, 0), Direction.RIGHT)));
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        grid -> {
          final int maxRow = grid.size();
          final int maxColumn = grid.getFirst().length;

          final Set<Beam> startingPositions = new HashSet<>();

          for (int row = 0; row < maxRow; ++row) {
            startingPositions.add(new Beam(new Position(row, 0), Direction.RIGHT));
            startingPositions.add(new Beam(new Position(row, maxColumn - 1), Direction.LEFT));
          }

          for (int column = 0; column < maxColumn; ++column) {
            startingPositions.add(new Beam(new Position(0, column), Direction.DOWN));
            startingPositions.add(new Beam(new Position(maxRow - 1, column), Direction.UP));
          }

          return startingPositions;
        });
  }

  private void run(final Scanner in, final Function<List<char[]>, Set<Beam>> getStartingBeams) {
    final List<char[]> grid = new ArrayList<>();

    while (in.hasNextLine()) {
      grid.add(in.nextLine().toCharArray());
    }

    long maxEnergized = 0;
    for (final Beam startingBeam : getStartingBeams.apply(grid)) {
      final Set<Beam> visited = new HashSet<>();
      final Queue<Beam> queue = new ArrayDeque<>();
      queue.add(startingBeam);

      while (!queue.isEmpty()) {
        final Beam current = queue.poll();
        if (visited.contains(current)) {
          continue;
        }

        visited.add(current);

        final Set<Direction> newDirections =
            getDirections(
                grid.get(current.position().row())[current.position().column()],
                current.direction());
        for (final Direction newDirection : newDirections) {
          final Position newPosition = getPosition(current.position(), newDirection);

          if (newPosition.isValid(grid)) {
            queue.add(new Beam(newPosition, newDirection));
          }
        }
      }

      maxEnergized =
          Math.max(maxEnergized, visited.stream().map(Beam::position).distinct().count());
    }

    print(maxEnergized);
  }

  private Position getPosition(final Position position, final Direction newDirection) {
    return switch (newDirection) {
      case UP -> new Position(position.row() - 1, position.column());
      case DOWN -> new Position(position.row() + 1, position.column());
      case LEFT -> new Position(position.row(), position.column() - 1);
      case RIGHT -> new Position(position.row(), position.column() + 1);
    };
  }

  private Set<Direction> getDirections(char atPosition, final Direction direction) {
    return switch (atPosition) {
      case '/' -> Set.of(
          switch (direction) {
            case UP -> Direction.RIGHT;
            case DOWN -> Direction.LEFT;
            case LEFT -> Direction.DOWN;
            case RIGHT -> Direction.UP;
          });
      case '\\' -> Set.of(
          switch (direction) {
            case UP -> Direction.LEFT;
            case DOWN -> Direction.RIGHT;
            case LEFT -> Direction.UP;
            case RIGHT -> Direction.DOWN;
          });
      case '-' -> Set.of(Direction.UP, Direction.DOWN).contains(direction)
          ? Set.of(Direction.LEFT, Direction.RIGHT)
          : Set.of(direction);
      case '|' -> Set.of(Direction.LEFT, Direction.RIGHT).contains(direction)
          ? Set.of(Direction.DOWN, Direction.UP)
          : Set.of(direction);
      default -> Set.of(direction);
    };
  }

  private record Beam(Position position, Direction direction) {}

  private record Position(int row, int column) {
    public boolean isValid(final List<char[]> grid) {
      return row >= 0 && column >= 0 && row < grid.size() && column < grid.getFirst().length;
    }
  }

  private enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;
  }
}
