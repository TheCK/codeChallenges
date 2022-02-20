package org.ck.adventofcode.year2016.day08;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.Scanner;

@Solution(
    id = 20160801,
    name = "Day 8: Two-Factor Authentication",
    url = "https://adventofcode.com/2016/day/8",
    category = "2016")
public class Part1 {
  public static void main(String[] args) {
    char[][] grid = new char[6][50];

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String[] line = in.nextLine().split(" ");

        if ("rect".equals(line[0])) {
          String[] rect = line[1].split("x");

          for (int x = 0; x < Integer.parseInt(rect[0]); ++x) {
            for (int y = 0; y < Integer.parseInt(rect[1]); ++y) {
              grid[y][x] = '#';
            }
          }
        } else {
          char[][] newGrid = new char[6][50];

          for (int x = 0; x < 50; ++x) {
            for (int y = 0; y < 6; ++y) {
              newGrid[y][x] = grid[y][x];
            }
          }

          int xMin = "column".equals(line[1]) ? Integer.parseInt(line[2].split("=")[1]) : 0;
          int xMax = "column".equals(line[1]) ? Integer.parseInt(line[2].split("=")[1]) : 49;

          int yMin = "row".equals(line[1]) ? Integer.parseInt(line[2].split("=")[1]) : 0;
          int yMax = "row".equals(line[1]) ? Integer.parseInt(line[2].split("=")[1]) : 5;

          int distance = Integer.parseInt(line[4]);

          for (int x = xMin; x <= xMax; ++x) {
            for (int y = yMin; y <= yMax; ++y) {
              newGrid["column".equals(line[1]) ? (y + distance) % 6 : y][
                      "row".equals(line[1]) ? (x + distance) % 50 : x] =
                  grid[y][x];
            }
          }

          grid = newGrid;
        }
      }
    }

    int count = 0;

    for (int x = 0; x < 50; ++x) {
      for (int y = 0; y < 6; ++y) {
        if (grid[y][x] == '#') {
          ++count;
        }
      }
    }

    System.out.println(count);
  }
}
