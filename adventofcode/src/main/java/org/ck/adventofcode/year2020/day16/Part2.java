package org.ck.adventofcode.year2020.day16;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Solution(
    id = 20201602,
    name = "Day 16: Ticket Translation - Part 2",
    url = "https://adventofcode.com/2020/day/16#part2",
    category = "2020")
public class Part2 {
  private static final Pattern categoryPattern =
      Pattern.compile("([a-z ]+): ([0-9]+)-([0-9]+) or ([0-9]+)-([0-9]+)");

  public static void main(String[] args) {
    Map<String, Category> categories = new HashMap<>();
    List<List<Integer>> validTickets = new ArrayList<>();
    List<Integer> myTicket = new ArrayList<>();

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String line = in.nextLine();

        Matcher categoryMatcher = categoryPattern.matcher(line);
        if (categoryMatcher.matches()) {
          categories.put(
              categoryMatcher.group(1),
              new Category(
                  Arrays.asList(
                      new Range(
                          Integer.parseInt(categoryMatcher.group(2)),
                          Integer.parseInt(categoryMatcher.group(3))),
                      new Range(
                          Integer.parseInt(categoryMatcher.group(4)),
                          Integer.parseInt(categoryMatcher.group(5))))));
        } else if ("your ticket:".equals(line)) {
          myTicket.addAll(
              Arrays.stream(in.nextLine().split(","))
                  .map(Integer::valueOf)
                  .collect(Collectors.toList()));
        } else if (!"nearby tickets:".equals(line) && !line.isBlank()) {
          List<Integer> ticketValues =
              Arrays.stream(line.split(",")).map(Integer::valueOf).collect(Collectors.toList());

          boolean valid = true;
          for (Integer ticketValue : ticketValues) {
            if (categories.values().stream()
                .noneMatch(category -> category.isInRange(ticketValue))) {
              valid = false;
              break;
            }
          }

          if (valid) {
            validTickets.add(ticketValues);
          }
        }
      }

      Map<String, Set<Integer>> possibleColumns = new HashMap<>();

      for (String categoryName : categories.keySet()) {
        possibleColumns.put(categoryName, new HashSet<>());

        for (int i = 0; i < categories.keySet().size(); ++i) {
          int index = i;

          if (validTickets.stream()
              .map(ticket -> ticket.get(index))
              .allMatch(value -> categories.get(categoryName).isInRange(value))) {
            possibleColumns.get(categoryName).add(index);
          }
        }
      }

      while (possibleColumns.values().stream().mapToInt(Set::size).sum()
          != possibleColumns.size()) {
        for (String categoryName : categories.keySet()) {
          if (possibleColumns.get(categoryName).size() == 1) {
            Optional<Integer> column = possibleColumns.get(categoryName).stream().findFirst();

            for (String innerCategoryName : categories.keySet()) {
              if (categoryName.equals(innerCategoryName)) {
                continue;
              }

              possibleColumns.get(innerCategoryName).remove(column.get());
            }
          }
        }
      }

      System.out.println(
          possibleColumns.entrySet().stream()
              .filter(entry -> entry.getKey().contains("departure"))
              .map(Map.Entry::getValue)
              .map(set -> set.stream().findFirst())
              .map(Optional::get)
              .mapToLong(myTicket::get)
              .reduce(1, (a, b) -> a * b));
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
