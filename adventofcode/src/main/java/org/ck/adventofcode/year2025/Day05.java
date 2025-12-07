package org.ck.adventofcode.year2025;

import java.util.*;
import java.util.function.ToLongFunction;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20250501,
    name = "Day 5: Cafeteria",
    url = "https://adventofcode.com/2025/day/5",
    category = "2025")
@Solution(
    id = 20250502,
    name = "Day 5: Cafeteria - Part 2",
    url = "https://adventofcode.com/2025/day/5#part2",
    category = "2025")
public class Day05 extends AOCSolution {

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, getAvailableFreshIngredientsCount(in));
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, Day05::getAllFreshIngredientsCount);
  }

  private void run(final Scanner in, final ToLongFunction<Set<Range>> getPartIngredientCount) {
    final Set<Range> ranges = new HashSet<>();

    while (in.hasNextLine()) {
      final String line = in.nextLine();

      if (line.isBlank()) {
        break;
      }

      final String[] parts = line.split("-");
      ranges.add(new Range(Long.parseLong(parts[0]), Long.parseLong(parts[1])));
    }

    print(getPartIngredientCount.applyAsLong(ranges));
  }

  private static ToLongFunction<Set<Range>> getAvailableFreshIngredientsCount(final Scanner in) {
    return ranges -> {
      long fresh = 0;
      while (in.hasNextLine()) {
        final long ingredient = Long.parseLong(in.nextLine());

        for (final Range range : ranges) {
          if (ingredient >= range.start && ingredient <= range.end) {
            ++fresh;
            break;
          }
        }
      }

      return fresh;
    };
  }

  private static long getAllFreshIngredientsCount(final Set<Range> ranges) {
    Set<Range> fresh = ranges;
    boolean merged = true;
    while (merged) {
      Set<Range> newFresh = new HashSet<>(fresh);
      merged = false;

      for (Range first : fresh) {
        for (Range second : fresh) {
          if (first != second && first.end >= second.start && first.end <= second.end) {
            merged = true;
            newFresh.remove(first);
            newFresh.remove(second);
            newFresh.add(new Range(Math.min(first.start, second.start), second.end));
            break;
          }
        }

        if (merged) {
          break;
        }
      }

      fresh = newFresh;
    }

    long freshCount = 0;
    for (Range range : fresh) {
      freshCount += range.end - range.start + 1;
    }
    return freshCount;
  }

  private record Range(long start, long end) {}
}
