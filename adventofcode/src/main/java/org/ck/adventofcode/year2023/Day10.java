package org.ck.adventofcode.year2023;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
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
    category = "2023",
    solved = false)
public class Day10 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in);
  }

  private void run(final Scanner in) {
    final List<String> grid = new ArrayList<>();

    while (in.hasNextLine()) {
      final String line = in.nextLine();
      grid.add(line);
    }

    final List<Position> positions = getPositions(grid);
    Position one = positions.getFirst();
    Position two = positions.getLast();

    int steps = 1;
    while (one.column() != two.column() || one.row() != two.row()) {
      one = move(grid, one);
      two = move(grid, two);

      ++steps;
    }

    print(steps);
  }

  private Position move(final List<String> grid, final Position position) {
    return switch (grid.get(position.row()).charAt(position.column())) {
      case '|' -> new Position(
          position.row() + (position.direction() == Direction.SOUTH ? -1 : 1),
          position.column(),
          position.direction());
      case '-' -> new Position(
          position.row(),
          position.column() + (position.direction() == Direction.EAST ? -1 : 1),
          position.direction());
      case 'L' -> position.direction() == Direction.NORTH
          ? new Position(position.row(), position.column() + 1, Direction.WEST)
          : new Position(position.row() - 1, position.column(), Direction.SOUTH);
      case 'J' -> position.direction() == Direction.NORTH
          ? new Position(position.row(), position.column() - 1, Direction.EAST)
          : new Position(position.row() - 1, position.column(), Direction.SOUTH);
      case '7' -> position.direction() == Direction.SOUTH
          ? new Position(position.row(), position.column() - 1, Direction.EAST)
          : new Position(position.row() + 1, position.column(), Direction.NORTH);
      case 'F' -> position.direction() == Direction.SOUTH
          ? new Position(position.row(), position.column() + 1, Direction.WEST)
          : new Position(position.row() + 1, position.column(), Direction.NORTH);
      default -> throw new IllegalStateException("Illegal pipe encoutered");
    };
  }

  private List<Position> getPositions(final List<String> grid) {
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

    final List<Position> positions = new ArrayList<>();

    if (row > 0 && Set.of('|', '7', 'F').contains(grid.get(row - 1).charAt(column))) {
      positions.add(new Position(row - 1, column, Direction.SOUTH));
    }

    if (row < grid.size() - 1 && Set.of('|', 'L', 'J').contains(grid.get(row + 1).charAt(column))) {
      positions.add(new Position(row + 1, column, Direction.NORTH));
    }

    if (column > 0 && Set.of('-', 'L', 'F').contains(grid.get(row).charAt(column - 1))) {
      positions.add(new Position(row, column - 1, Direction.EAST));
    }

    if (column < grid.getFirst().length() - 1
        && Set.of('-', 'J', '7').contains(grid.get(row).charAt(column + 1))) {
      positions.add(new Position(row, column + 1, Direction.WEST));
    }

    if (positions.size() != 2) {
      throw new IllegalStateException("Start does not have two connections");
    }

    return positions;
  }

  private record Position(int row, int column, Direction direction) {}

  private enum Direction {
    SOUTH,
    NORTH,
    WEST,
    EAST
  }
}
