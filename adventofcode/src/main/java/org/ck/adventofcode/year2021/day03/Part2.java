package org.ck.adventofcode.year2021.day03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20210302,
    name = "Day 3: Binary Diagnostic - Part 2",
    url = "https://adventofcode.com/2021/day/3#part2",
    category = "2021")
public class Part2 {
  public static void main(String[] args) {
    List<String> numbers = new ArrayList<>();

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        numbers.add(in.nextLine());
      }
    }

    int generator = getValue(numbers, (ones, size) -> 2 * ones >= size);
    int scrubbers = getValue(numbers, (ones, size) -> 2 * ones < size);

    System.out.println(generator * scrubbers);
  }

  private static int getValue(List<String> numbers, BiPredicate<Integer, Integer> predicate) {
    List<String> values = new ArrayList<>(numbers);

    int length = values.get(0).length();

    for (int i = 0; i < length; ++i) {
      int finalI = i;
      int ones = values.stream().mapToInt(line -> line.charAt(finalI) - '0').sum();

      Predicate<String> pick =
          predicate.test(ones, values.size())
              ? line -> line.charAt(finalI) == '1'
              : line -> line.charAt(finalI) != '1';

      values = values.stream().filter(pick).toList();

      if (values.size() == 1) {
        break;
      }
    }

    return Integer.parseInt(values.get(0), 2);
  }
}
