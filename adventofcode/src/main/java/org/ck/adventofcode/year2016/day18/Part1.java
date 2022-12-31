package org.ck.adventofcode.year2016.day18;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20161801,
    name = "Day 18: Like a Rogue",
    url = "https://adventofcode.com/2016/day/18",
    category = "2016")
public class Part1 {
  public static void main(String[] args) {
    List<String> grid = new ArrayList<>();
    int rows = 0;

    try (Scanner in = new Scanner(System.in)) {
      grid.add("." + in.nextLine() + ".");
      rows = in.nextInt();
    }

    for (int i = 1; i < rows; ++i) {
      StringBuilder builder = new StringBuilder();

      for (int j = 1; j < grid.get(i - 1).length() - 1; ++j) {
        if ((grid.get(i - 1).charAt(j - 1) == '^'
                && grid.get(i - 1).charAt(j) == '^'
                && grid.get(i - 1).charAt(j + 1) == '.')
            || (grid.get(i - 1).charAt(j - 1) == '.'
                && grid.get(i - 1).charAt(j) == '^'
                && grid.get(i - 1).charAt(j + 1) == '^')
            || (grid.get(i - 1).charAt(j - 1) == '^'
                && grid.get(i - 1).charAt(j) == '.'
                && grid.get(i - 1).charAt(j + 1) == '.')
            || (grid.get(i - 1).charAt(j - 1) == '.'
                && grid.get(i - 1).charAt(j) == '.'
                && grid.get(i - 1).charAt(j + 1) == '^')) {
          builder.append("^");
        } else {
          builder.append(".");
        }
      }

      grid.add("." + builder + ".");
    }

    System.out.println(
        grid.stream()
            .map(line -> line.substring(1, line.length() - 1))
            .mapToLong(
                line -> {
                  long safe = 0;

                  for (int i = 0; i < line.length(); ++i) {
                    if (line.charAt(i) == '.') {
                      ++safe;
                    }
                  }

                  return safe;
                })
            .sum());
  }
}
