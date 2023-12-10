package org.ck.adventofcode.year2023;

import java.util.*;
import java.util.function.ToIntBiFunction;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20231001,
    name = "Day 10: Pipe Maze",
    url = "https://adventofcode.com/2023/day/10",
    category = "2023")
@Solution(
    id = 20231002,
    name = "Day 10: Pipe Maze - Part 2",
    url = "https://adventofcode.com/2023/day/10#part2",
    category = "2023")
public class Day10 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, (grid, pipes) -> pipes.size() / 2);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        (grid, pipes) -> {
          int inside = 0;

          for (int row = 0; row < grid.size(); ++row) {
            for (int colum = 0; colum < grid.get(row).length(); ++colum) {
              if (!pipes.contains(new Point(row, colum))) {
                if (isInside(grid, pipes, row, colum)) {
                  ++inside;
                }
              }
            }
          }

          return inside;
        });
  }

  private boolean isInside(
      final List<String> grid, final Set<Point> pipes, final int startRow, final int startColumn) {
    int pipesToTop = 0;
    for (int row = startRow - 1; row >= 0; --row) {
      if (pipes.contains(new Point(row, startColumn))) {
        pipesToTop += getVerticalPipeValue(grid, row, startColumn);
      }
    }

    int pipesTobottom = 0;
    for (int row = startRow + 1; row < grid.size(); ++row) {
      if (pipes.contains(new Point(row, startColumn))) {
        pipesTobottom += getVerticalPipeValue(grid, row, startColumn);
      }
    }

    int pipesToLeft = 0;
    for (int column = startColumn - 1; column >= 0; --column) {
      if (pipes.contains(new Point(startRow, column))) {
        pipesToLeft += getHorizontalPipeValue(grid, startRow, column);
      }
    }

    int pipesToRight = 0;
    for (int column = startColumn + 1; column < grid.get(startRow).length(); ++column) {
      if (pipes.contains(new Point(startRow, column))) {
        pipesToRight += getHorizontalPipeValue(grid, startRow, column);
      }
    }

    return (pipesToTop / 10) % 2 != 0
        && (pipesTobottom / 10) % 2 != 0
        && (pipesToLeft / 10) % 2 != 0
        && (pipesToRight / 10) % 2 != 0;
  }

  private static int getVerticalPipeValue(
      final List<String> grid, final int row, final int column) {
    return switch (grid.get(row).charAt(column)) {
      case '-' -> 10;
      case 'L', '7' -> 5;
      case 'J', 'F' -> -5;
      default -> 0;
    };
  }

  private static int getHorizontalPipeValue(
      final List<String> grid, final int row, final int column) {
    return switch (grid.get(row).charAt(column)) {
      case '|' -> 10;
      case 'L', '7' -> 5;
      case 'J', 'F' -> -5;
      default -> 0;
    };
  }

  private void run(final Scanner in, final ToIntBiFunction<List<String>, Set<Point>> getResult) {
    final List<String> grid = new ArrayList<>();

    while (in.hasNextLine()) {
      final String line = in.nextLine();
      grid.add(line);
    }

    Pipe pipe = getStartPosition(grid);
    Direction direction = pipe.directions().stream().findAny().orElseThrow();

    final Set<Point> visited = new HashSet<>();
    while (pipe != null) {
      visited.add(pipe.point());

      final MoveResult move = move(grid, pipe, direction);
      pipe = move.next();
      direction = move.direction;
    }

    print(getResult.applyAsInt(grid, visited));
  }

  private MoveResult move(final List<String> grid, final Pipe pipe, final Direction direction) {
    final Point newPoint =
        switch (direction) {
          case SOUTH -> new Point(pipe.point().row() + 1, pipe.point().column());
          case NORTH -> new Point(pipe.point().row() - 1, pipe.point().column());
          case WEST -> new Point(pipe.point().row(), pipe.point().column() - 1);
          case EAST -> new Point(pipe.point().row(), pipe.point().column() + 1);
        };

    final Pipe newPipe =
        switch (grid.get(newPoint.row()).charAt(newPoint.column())) {
          case '|' -> new Pipe(newPoint, Set.of(Direction.NORTH, Direction.SOUTH));
          case '-' -> new Pipe(newPoint, Set.of(Direction.EAST, Direction.WEST));
          case 'L' -> new Pipe(newPoint, Set.of(Direction.NORTH, Direction.EAST));
          case 'J' -> new Pipe(newPoint, Set.of(Direction.NORTH, Direction.WEST));
          case '7' -> new Pipe(newPoint, Set.of(Direction.WEST, Direction.SOUTH));
          case 'F' -> new Pipe(newPoint, Set.of(Direction.EAST, Direction.SOUTH));
          case 'S' -> null;
          default -> throw new IllegalStateException("Illegal pipe encountered");
        };

    final Direction newDirection =
        switch (grid.get(newPoint.row()).charAt(newPoint.column())) {
          case '|' -> direction == Direction.SOUTH ? Direction.SOUTH : Direction.NORTH;
          case '-' -> direction == Direction.EAST ? Direction.EAST : Direction.WEST;
          case 'L' -> direction == Direction.SOUTH ? Direction.EAST : Direction.NORTH;
          case 'J' -> direction == Direction.SOUTH ? Direction.WEST : Direction.NORTH;
          case '7' -> direction == Direction.NORTH ? Direction.WEST : Direction.SOUTH;
          case 'F' -> direction == Direction.NORTH ? Direction.EAST : Direction.SOUTH;
          case 'S' -> null;
          default -> throw new IllegalStateException("Illegal pipe encountered");
        };

    return new MoveResult(newPipe, newDirection);
  }

  private Pipe getStartPosition(final List<String> grid) {
    int row = 0;
    int column = 0;

    while (row < grid.size()) {
      final int index = grid.get(row).indexOf('S');

      if (index >= 0) {
        column = index;
        break;
      }

      ++row;
    }

    final Set<Direction> directions = new HashSet<>();

    if (row > 0 && Set.of('|', '7', 'F').contains(grid.get(row - 1).charAt(column))) {
      directions.add(Direction.NORTH);
    }

    if (row < grid.size() - 1 && Set.of('|', 'L', 'J').contains(grid.get(row + 1).charAt(column))) {
      directions.add(Direction.SOUTH);
    }

    if (column > 0 && Set.of('-', 'L', 'F').contains(grid.get(row).charAt(column - 1))) {
      directions.add(Direction.WEST);
    }

    if (column < grid.getFirst().length() - 1
        && Set.of('-', 'J', '7').contains(grid.get(row).charAt(column + 1))) {
      directions.add(Direction.EAST);
    }

    if (directions.size() != 2) {
      throw new IllegalStateException("Start does not have two connections");
    }

    return new Pipe(new Point(row, column), directions);
  }

  private record MoveResult(Pipe next, Direction direction) {}

  private record Pipe(Point point, Set<Direction> directions) {}

  private record Point(int row, int column) {}

  private enum Direction {
    SOUTH,
    NORTH,
    WEST,
    EAST
  }
}
