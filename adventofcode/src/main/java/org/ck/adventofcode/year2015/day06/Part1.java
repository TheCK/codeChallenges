package org.ck.adventofcode.year2015.day06;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20150601,
    name = "Day 6: Probably a Fire Hazard",
    url = "https://adventofcode.com/2015/day/6",
    category = "2015")
public class Part1 {
  private static final int[][] GRID = new int[1000][1000];
  private static final Pattern PATTERN =
      Pattern.compile("(turn on|turn off|toggle) (\\d+),(\\d+) through (\\d+),(\\d+)");

  public static void main(String[] args) throws Exception {
    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        Matcher matcher = PATTERN.matcher(in.nextLine());

        if (matcher.find()) {
          String command = matcher.group(1);
          int startX = Integer.parseInt(matcher.group(2));
          int startY = Integer.parseInt(matcher.group(3));
          int endX = Integer.parseInt(matcher.group(4));
          int endY = Integer.parseInt(matcher.group(5));

          for (int x = startX; x <= endX; ++x) {
            for (int y = startY; y <= endY; ++y) {
              switch (command) {
                case "turn on" -> GRID[x][y] = 1;
                case "turn off" -> GRID[x][y] = 0;
                case "toggle" -> GRID[x][y] = GRID[x][y] == 1 ? 0 : 1;
                default -> throw new IllegalStateException("Unexpected value: " + command);
              }
            }
          }
        }
      }
    }

    System.out.println(Arrays.stream(GRID).flatMapToInt(Arrays::stream).sum());
  }
}
