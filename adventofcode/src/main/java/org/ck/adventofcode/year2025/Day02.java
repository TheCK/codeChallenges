package org.ck.adventofcode.year2025;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.ToIntFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20250201,
    name = "Day 2: Gift Shop",
    url = "https://adventofcode.com/2025/day/2",
    category = "2025")
@Solution(
    id = 20250202,
    name = "Day 2: Gift Shop - Part 2",
    url = "https://adventofcode.com/2025/day/2#part2",
    category = "2025")
public class Day02 extends AOCSolution {
  static final Pattern rangePattern = Pattern.compile("(?<start>\\d+)-(?<end>\\d+)");

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, _ -> 2);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, startLength -> startLength);
  }

  private void run(final Scanner in, final ToIntFunction<Integer> getMaxRepetitions) {
    final String[] ranges = in.nextLine().split(",");

    final Set<Long> invalidIds = new HashSet<>();
    for (final String range : ranges) {
      final Matcher matcher = rangePattern.matcher(range);

      if (matcher.find()) {
        final String startString = matcher.group("start");
        final String endString = matcher.group("end");

        final long end = Long.parseLong(endString);

        for (int repetitions = 2;
            repetitions <= getMaxRepetitions.applyAsInt(endString.length());
            ++repetitions) {
          invalidIds.addAll(generateInvalidIds(repetitions, startString, end));
        }
      }
    }

    print(invalidIds.stream().mapToLong(Long::longValue).sum());
  }

  private static Set<Long> generateInvalidIds(
      final int repetitions, final String startString, final long end) {
    final long start = Long.parseLong(startString);
    final int startLength = startString.length();

    final int halfLength = startLength / repetitions;
    final long startHalf =
        halfLength > 0 ? Long.parseLong(startString.substring(0, halfLength)) : 1;

    final Set<Long> invalidIds = new HashSet<>();
    for (long numberHalf = startHalf; ; ++numberHalf) {
      final long number = getInvalidId(numberHalf, repetitions);

      if (number > end) {
        break;
      }

      if (number >= start) {
        invalidIds.add(number);
      }
    }

    return invalidIds;
  }

  private static long getInvalidId(final long numberHalf, final int repetitions) {
    final int currentLength = (int) Math.log10(numberHalf) + 1;
    final long shiftAmount = (long) Math.pow(10, currentLength);

    long number = numberHalf;
    for (int i = 1; i < repetitions; ++i) {
      number *= shiftAmount;
      number += numberHalf;
    }

    return number;
  }
}
