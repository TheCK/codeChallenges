package org.ck.adventofcode.year2022.day22;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@Solution(
    id = 20222201,
    name = "Day 22: Monkey Map",
    url = "https://adventofcode.com/2022/day/21",
    category = "2022",
    solved = false)
public class Part1 {
  public static void main(String[] args) {
    List<char[]> grid = new ArrayList<>();
    String directions = "";
    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String line = in.nextLine();

        if (line.isEmpty()) {
          directions = in.nextLine();
        } else {
          grid.add(line.toCharArray());
        }
      }
    }

    int maxLength = grid.stream().mapToInt(row -> row.length).max().getAsInt();
    for (int i = 0; i < grid.size(); ++i) {
      if (grid.get(i).length < maxLength) {
        char[] row = new char[maxLength];
        System.arraycopy(grid.get(i), 0, row, 0, grid.get(i).length);
        grid.set(i, row);
      }
    }

    int y = 0;
    int x = 0;
    while (grid.get(y)[x] != '.') {
      ++x;
    }
    Point position = new Point(x, y);

    int i = 0;
    Direction direction = Direction.RIGHT;
    while (i < directions.length()) {
      if (directions.charAt(i) == 'R') {
        direction = direction.getTurnC().get();
        ++i;
      } else if (directions.charAt(i) == 'L') {
        direction = direction.getTurnCC().get();
        ++i;
      } else {
        int distance = 0;
        while (i < directions.length() && Character.isDigit(directions.charAt(i))) {
          distance = 10 * distance + (directions.charAt(i) - '0');
          ++i;
        }

        for (int step = 0; step < distance; ++step) {
          Point next = wrap(direction.getMove().apply(position), grid);
          while (grid.get(next.y())[next.x()] != '#' && grid.get(next.y())[next.x()] != '.') {
            next = wrap(direction.getMove().apply(next), grid);
          }

          if (grid.get(next.y())[next.x()] == '#') {
            break;
          }

          position = next;
        }
      }
    }

    System.out.println(
        (1000 * (position.y() + 1)) + (4 * (position.x() + 1)) + direction.getValue());
  }

  private static Point wrap(final Point point, final List<char[]> grid) {
    if (point.y() == -1) {
      return new Point(point.x(), grid.size() - 1);
    } else if (point.y() == grid.size()) {
      return new Point(point.x(), 0);
    } else if (point.x() == -1) {
      return new Point(grid.get(point.y()).length - 1, point.y());
    } else if (point.x() == grid.get(point.y()).length) {
      return new Point(0, point.y());
    }

    return point;
  }

  private record Point(int x, int y) {}

  private enum Direction {
    UP(3, point -> new Point(point.x(), point.y() - 1), Direction::getRight, Direction::getLeft),
    RIGHT(0, point -> new Point(point.x() + 1, point.y()), Direction::getDown, Direction::getUp),
    DOWN(1, point -> new Point(point.x(), point.y() + 1), Direction::getLeft, Direction::getRight),
    LEFT(2, point -> new Point(point.x() - 1, point.y()), Direction::getUp, Direction::getDown);

    private int value;
    private UnaryOperator<Point> move;
    private Supplier<Direction> turnC;
    private Supplier<Direction> turnCC;

    Direction(
        int value,
        UnaryOperator<Point> move,
        Supplier<Direction> turnC,
        Supplier<Direction> turnCC) {
      this.value = value;
      this.move = move;
      this.turnC = turnC;
      this.turnCC = turnCC;
    }

    public int getValue() {
      return value;
    }

    public Function<Point, Point> getMove() {
      return move;
    }

    public Supplier<Direction> getTurnC() {
      return turnC;
    }

    public Supplier<Direction> getTurnCC() {
      return turnCC;
    }

    private static Direction getUp() {
      return UP;
    }

    private static Direction getRight() {
      return RIGHT;
    }

    private static Direction getDown() {
      return DOWN;
    }

    private static Direction getLeft() {
      return LEFT;
    }
  }
}
