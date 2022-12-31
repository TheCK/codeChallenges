package org.ck.adventofcode.year2021.day13;

import org.ck.codechallengelib.annotation.Solution;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Solution(
    id = 20211302,
    name = "Day 13: Transparent Origami - Part 2",
    url = "https://adventofcode.com/2021/day/13#part2",
    category = "2021")
public class Part2 {
  private static final Pattern number = Pattern.compile("\\d+");

  public static void main(String[] args) {
    Set<Point> points = new HashSet<>();
    List<Command> commands = new ArrayList<>();

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String line = in.nextLine();

        if (line.isBlank()) {
          break;
        }

        final String[] split = line.split(",");
        final int x = Integer.parseInt(split[0]);
        final int y = Integer.parseInt(split[1]);

        points.add(new Point(x, y));
      }

      while (in.hasNextLine()) {
        String line = in.nextLine();
        final Matcher matcher = number.matcher(line);
        matcher.find();

        commands.add(new Command(line.contains("x"), Integer.parseInt(matcher.group(0))));
      }
    }

    for (Command command : commands) {
      points = fold(points, command);
    }

    int maxX = 0;
    int maxY = 0;
    for (Point point : points) {
      maxX = Math.max(point.x(), maxX);
      maxY = Math.max(point.y(), maxY);
    }

    boolean[][] grid = new boolean[maxY + 1][maxX + 1];
    for (Point point : points) {
      grid[point.y()][point.x()] = true;
    }

    for (int y = 0; y <= maxY; ++y) {
      for (int x = 0; x <= maxX; ++x) {
        System.out.print(grid[y][x] ? '#' : ' ');
      }
      System.out.println();
    }
  }

  private static Set<Point> fold(final Set<Point> points, final Command command) {
    return points.stream()
        .map(
            point -> {
              if (command.xAxis()) {
                if (point.x() < command.number()) {
                  return point;
                }

                return new Point(command.number() - (point.x() - command.number()), point.y());
              }

              if (point.y() < command.number()) {
                return point;
              }

              return new Point(point.x(), command.number() - (point.y() - command.number()));
            })
        .collect(Collectors.toSet());
  }

  private static record Point(int x, int y) {}

  private static record Command(boolean xAxis, int number) {}
}
