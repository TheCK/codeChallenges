package org.ck.adventofcode.year2025;

import java.util.*;
import java.util.function.ToLongFunction;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20250601,
    name = "Day 6: Trash Compactor",
    url = "https://adventofcode.com/2025/day/6",
    category = "2025")
@Solution(
    id = 20250602,
    name = "Day 6: Trash Compactor - Part 2",
    url = "https://adventofcode.com/2025/day/6#part2",
    category = "2025")
public class Day06 extends AOCSolution {

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, Day06::getPart1Result);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, Day06::getPart2Result);
  }

  private void run(final Scanner in, final ToLongFunction<List<List<String>>> getResult) {
    final List<String> inputs = new ArrayList<>();

    while (in.hasNextLine()) {
      inputs.add(in.nextLine());
    }

    final String operations = inputs.getLast();
    final List<List<String>> columns = new ArrayList<>();
    for (int j = 0; j < inputs.size() - 1; ++j) {
      columns.add(new ArrayList<>());
    }

    int start = 1;
    while (true) {
      final int nextPlus = operations.indexOf('+', start);
      final int nextTimes = operations.indexOf('*', start);

      final int nextNumberStart;
      if (nextPlus == -1 && nextTimes == -1) {
        break;
      } else if (nextPlus == -1) {
        nextNumberStart = nextTimes;
      } else if (nextTimes == -1) {
        nextNumberStart = nextPlus;
      } else {
        nextNumberStart = Math.min(nextPlus, nextTimes);
      }

      for (int j = 0; j < inputs.size() - 1; ++j) {
        columns.get(j).add(inputs.get(j).substring(start - 1, nextNumberStart - 1));
      }

      start = nextNumberStart + 1;
    }
    for (int j = 0; j < inputs.size() - 1; ++j) {
      columns.get(j).add(inputs.get(j).substring(start - 1));
    }

    columns.add(new ArrayList<>(Arrays.asList(operations.trim().split("\\s+"))));

    print(getResult.applyAsLong(columns));
  }

  private static Long getPart1Result(List<List<String>> inputs) {
    long sum = 0;
    for (int i = 0; i < inputs.get(0).size(); ++i) {
      final String operation = inputs.get(inputs.size() - 1).get(i);
      long result = "*".equals(operation) ? 1 : 0;

      for (int j = 0; j < inputs.size() - 1; ++j) {
        switch (operation) {
          case "+" -> result += Long.parseLong(inputs.get(j).get(i).trim());
          case "*" -> result *= Long.parseLong(inputs.get(j).get(i).trim());
        }
      }

      sum += result;
    }

    return sum;
  }

  private static Long getPart2Result(List<List<String>> inputs) {
    long sum = 0;
    for (int i = 0; i < inputs.get(0).size(); ++i) {
      int numbersCount = 0;
      for (int j = 0; j < inputs.size() - 1; ++j) {
        numbersCount = Math.max(numbersCount, inputs.get(j).get(i).length());
      }

      final List<Long> numbers = new ArrayList<>();
      for (int numberIndex = 0; numberIndex < numbersCount; ++numberIndex) {
        long number = 0;
        for (int j = 0; j < inputs.size() - 1; ++j) {
          char current = inputs.get(j).get(i).charAt(numberIndex);

          if (current != ' ') {
            number = number * 10 + (current - '0');
          }
        }

        numbers.add(number);
      }

      final String operation = inputs.get(inputs.size() - 1).get(i);
      long result = "*".equals(operation) ? 1 : 0;
      for (Long number : numbers) {
        switch (operation) {
          case "+" -> result += number;
          case "*" -> result *= number;
        }
      }

      sum += result;
    }

    return sum;
  }
}
