package org.ck.adventofcode.year2015;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20150601,
    name = "Day 6: Probably a Fire Hazard",
    url = "https://adventofcode.com/2015/day/6",
    category = "2015")
@Solution(
    id = 20150602,
    name = "Day 6: Probably a Fire Hazard - Part 2",
    url = "https://adventofcode.com/2015/day/6#part2",
    category = "2015")
public class Day06 extends AOCSolution {

  private static final Pattern PATTERN =
      Pattern.compile(
          "(?<command>turn on|turn off|toggle) (?<startX>\\d+),(?<startY>\\d+) through (?<endX>\\d+),(?<endY>\\d+)");

  @Override
  protected void runPartOne(final Scanner in) {
    run(
        in,
        (command, currentValue) ->
            switch (command) {
              case "turn on" -> 1;
              case "turn off" -> 0;
              case "toggle" -> currentValue == 1 ? 0 : 1;
              default -> throw new IllegalStateException("Unexpected value: " + command);
            });
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        (command, currentValue) ->
            switch (command) {
              case "turn on" -> currentValue + 1;
              case "turn off" -> currentValue == 0 ? 0 : currentValue - 1;
              case "toggle" -> currentValue + 2;
              default -> throw new IllegalStateException("Unexpected value: " + command);
            });
  }

  private void run(
      final Scanner in, final BiFunction<String, Integer, Integer> commandInterpreter) {
    final int[][] grid = new int[1000][1000];

    while (in.hasNextLine()) {
      final Matcher matcher = PATTERN.matcher(in.nextLine());

      if (matcher.find()) {
        final String command = matcher.group("command");
        final int startX = Integer.parseInt(matcher.group("startX"));
        final int startY = Integer.parseInt(matcher.group("startY"));
        final int endX = Integer.parseInt(matcher.group("endX"));
        final int endY = Integer.parseInt(matcher.group("endY"));

        for (int x = startX; x <= endX; ++x) {
          for (int y = startY; y <= endY; ++y) {
            grid[x][y] = commandInterpreter.apply(command, grid[x][y]);
          }
        }
      }
    }

    print(Arrays.stream(grid).flatMapToInt(Arrays::stream).sum());
  }
}
