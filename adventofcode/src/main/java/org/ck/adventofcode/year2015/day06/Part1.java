package org.ck.adventofcode.year2015.day06;

import org.ck.codechallengelib.annotation.Solution;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Solution(
    id = 20150601,
    name = "Day 6: Probably a Fire Hazard",
    url = "https://adventofcode.com/2015/day/6",
    category = "2015")
public class Part1 {
  public static final int[][] grid = new int[1000][1000];
  public static final Pattern pattern =
      Pattern.compile("(turn on|turn off|toggle) (\\d+),(\\d+) through (\\d+),(\\d+)");

  public static void main(String[] args) throws Exception {
    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        Matcher matcher = pattern.matcher(in.nextLine());

        if (matcher.find()) {
          String command = matcher.group(1);
          int startX = Integer.parseInt(matcher.group(2));
          int startY = Integer.parseInt(matcher.group(3));
          int endX = Integer.parseInt(matcher.group(4));
          int endY = Integer.parseInt(matcher.group(5));

          for (int x = startX; x <= endX; ++x) {
            for (int y = startY; y <= endY; ++y) {
              switch (command) {
                case "turn on" -> grid[x][y] = 1;
                case "turn off" -> grid[x][y] = 0;
                case "toggle" -> grid[x][y] = grid[x][y] == 1 ? 0 : 1;
              }
            }
          }
        }
      }
    }

    System.out.println(Arrays.stream(grid).flatMapToInt(Arrays::stream).sum());
  }
}
