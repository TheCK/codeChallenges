package org.ck.adventofcode.year2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20241501,
    name = "Day 15: Warehouse Woes",
    url = "https://adventofcode.com/2024/day/15",
    category = "2024")
@Solution(
    id = 20241502,
    name = "Day 15: Warehouse Woes - Part 2",
    url = "https://adventofcode.com/2024/day/15#part2",
    category = "2024")
public class Day15 extends AOCSolution {

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, line -> line);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, Day15::stretchLine);
  }

  private void run(final Scanner in, final UnaryOperator<char[]> getActualLine) {
    final List<char[]> grid = new ArrayList<>();
    while (in.hasNextLine()) {
      final String line = in.nextLine();
      if (line.isBlank()) {
        break;
      }

      grid.add(getActualLine.apply(line.toCharArray()));
    }

    final StringBuilder builder = new StringBuilder();
    while (in.hasNextLine()) {
      builder.append(in.nextLine());
    }

    final String commands = builder.toString();
    Coordinate robot = findRobot(grid);

    for (int i = 0; i < commands.length(); i++) {
      final char command = commands.charAt(i);

      robot =
          switch (command) {
            case '^' -> move(grid, robot, new Coordinate(0, -1));
            case 'v' -> move(grid, robot, new Coordinate(0, 1));
            case '<' -> move(grid, robot, new Coordinate(-1, 0));
            case '>' -> move(grid, robot, new Coordinate(1, 0));
            default -> throw new IllegalArgumentException("Unexpected command: " + command);
          };
    }

    print(getGpsSum(grid));
  }

  private long getGpsSum(final List<char[]> grid) {
    long sum = 0;
    for (int y = 0; y < grid.size(); ++y) {
      for (int x = 0; x < grid.get(y).length; ++x) {
        if (grid.get(y)[x] == 'O' || grid.get(y)[x] == '[') {
          sum += 100L * y + x;
        }
      }
    }
    return sum;
  }

  private static char[] stretchLine(final char[] line) {
    final char[] newLine = new char[2 * line.length];

    for (int i = 0; i < line.length; ++i) {
      switch (line[i]) {
        case '#':
          newLine[2 * i] = '#';
          newLine[2 * i + 1] = '#';
          break;
        case 'O':
          newLine[2 * i] = '[';
          newLine[2 * i + 1] = ']';
          break;
        case '@':
          newLine[2 * i] = '@';
          newLine[2 * i + 1] = '.';
          break;
        default:
          newLine[2 * i] = '.';
          newLine[2 * i + 1] = '.';
          break;
      }
    }

    return newLine;
  }

  private Coordinate move(
      final List<char[]> grid, final Coordinate robot, final Coordinate direction) {
    final Coordinate newPoint =
        new Coordinate(robot.x() + direction.x(), robot.y() + direction.y());

    if (grid.get(newPoint.y())[newPoint.x()] == '.') {
      swap(grid, robot, newPoint);
      return newPoint;
    } else if (grid.get(newPoint.y())[newPoint.x()] == 'O'
        || (direction.y() == 0
            && (grid.get(newPoint.y())[newPoint.x()] == '['
                || grid.get(newPoint.y())[newPoint.x()] == ']'))) {
      if (push(grid, newPoint, direction)) {
        swap(grid, robot, newPoint);
        return newPoint;
      }
    } else if (grid.get(newPoint.y())[newPoint.x()] == '['
        || grid.get(newPoint.y())[newPoint.x()] == ']') {
      if (pushComplicated(grid, newPoint, direction.y(), false)) {
        pushComplicated(grid, newPoint, direction.y(), true);
        swap(grid, robot, newPoint);
        return newPoint;
      }
    }

    return robot;
  }

  private boolean pushComplicated(
      final List<char[]> grid,
      final Coordinate point,
      final int yDirection,
      final boolean actuallyPush) {
    final Coordinate left;
    final Coordinate right;
    if (grid.get(point.y())[point.x()] == '[') {
      left = point;
      right = new Coordinate(point.x() + 1, point.y());
    } else {
      left = new Coordinate(point.x() - 1, point.y());
      right = point;
    }

    final Coordinate newLeft = new Coordinate(left.x(), left.y() + yDirection);
    final Coordinate newRight = new Coordinate(right.x(), right.y() + yDirection);

    if (grid.get(newLeft.y())[newLeft.x()] == '.' && grid.get(newRight.y())[newRight.x()] == '.') {
      if (actuallyPush) {
        swap(grid, left, newLeft);
        swap(grid, right, newRight);
      }

      return true;
    } else if (grid.get(newLeft.y())[newLeft.x()] == '#'
        || grid.get(newRight.y())[newRight.x()] == '#') {
      return false;
    }
    boolean canPush = true;
    if (grid.get(newLeft.y())[newLeft.x()] != '.') {
      if (pushComplicated(grid, newLeft, yDirection, actuallyPush)) {
        if (actuallyPush && grid.get(newRight.y())[newRight.x()] == '.') {
          swap(grid, left, newLeft);
          swap(grid, right, newRight);
        }
      } else {
        canPush = false;
      }
    }
    if (grid.get(right.y())[right.x()] != '.' && grid.get(newRight.y())[newRight.x()] != '.') {
      if (pushComplicated(grid, newRight, yDirection, actuallyPush)) {
        if (actuallyPush) {
          swap(grid, right, newRight);
          swap(grid, left, newLeft);
        }
      } else {
        canPush = false;
      }
    }

    return canPush;
  }

  private boolean push(
      final List<char[]> grid, final Coordinate point, final Coordinate direction) {
    final Coordinate newPoint =
        new Coordinate(point.x() + direction.x(), point.y() + direction.y());

    if (grid.get(newPoint.y())[newPoint.x()] == '.') {
      swap(grid, point, newPoint);
      return true;
    } else if (grid.get(newPoint.y())[newPoint.x()] == 'O'
        || grid.get(newPoint.y())[newPoint.x()] == '['
        || grid.get(newPoint.y())[newPoint.x()] == ']') {
      if (push(grid, newPoint, direction)) {
        swap(grid, point, newPoint);
        return true;
      }
    }

    return false;
  }

  private void swap(final List<char[]> grid, final Coordinate one, final Coordinate two) {
    final char tmp = grid.get(one.y())[one.x()];
    grid.get(one.y())[one.x()] = grid.get(two.y())[two.x()];
    grid.get(two.y())[two.x()] = tmp;
  }

  private Coordinate findRobot(final List<char[]> grid) {
    for (int y = 0; y < grid.size(); ++y) {
      for (int x = 0; x < grid.get(y).length; ++x) {
        if (grid.get(y)[x] == '@') {
          return new Coordinate(x, y);
        }
      }
    }

    throw new IllegalStateException("No robot found");
  }

  private record Coordinate(int x, int y) {}
}
