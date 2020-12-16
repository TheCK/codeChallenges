package org.ck.adventofcode.year2020.day16;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Solution(
    id = 20201601,
    name = "Day 16: Ticket Translation",
    url = "https://adventofcode.com/2020/day/16",
    category = "2020")
public class Part1 {
  private static final Pattern categoryPattern =
      Pattern.compile("[a-z ]+: ([0-9]+)-([0-9]+) or ([0-9]+)-([0-9]+)");

  public static void main(String[] args) {
    List<Category> categories = new ArrayList<>();

    try (Scanner in = new Scanner(System.in)) {
      int errorRate = 0;
      while (in.hasNextLine()) {
        String line = in.nextLine();

        Matcher categoryMatcher = categoryPattern.matcher(line);
        if (categoryMatcher.matches()) {
          categories.add(
              new Category(
                  Arrays.asList(
                      new Range(
                          Integer.parseInt(categoryMatcher.group(1)),
                          Integer.parseInt(categoryMatcher.group(2))),
                      new Range(
                          Integer.parseInt(categoryMatcher.group(3)),
                          Integer.parseInt(categoryMatcher.group(4))))));
        } else if ("your ticket:".equals(line)) {
          in.nextLine();
        } else if (!"nearby tickets:".equals(line) && !line.isBlank()) {
          List<Integer> ticketValues =
              Arrays.stream(line.split(",")).map(Integer::valueOf).collect(Collectors.toList());

          for (Integer ticketValue : ticketValues) {
            if (categories.stream().noneMatch(category -> category.isInRange(ticketValue))) {
              errorRate += ticketValue;
            }
          }
        }
      }

      System.out.println(errorRate);
    }
  }

  private static class Category {
    private final List<Range> ranges;

    public Category(List<Range> ranges) {
      this.ranges = ranges;
    }

    public boolean isInRange(int value) {
      return ranges.stream().anyMatch(range -> range.isInRange(value));
    }
  }

  private static class Range {
    private final int min;
    private final int max;

    public Range(int min, int max) {
      this.min = min;
      this.max = max;
    }

    public boolean isInRange(int value) {
      return min <= value && value <= max;
    }
  }
}
