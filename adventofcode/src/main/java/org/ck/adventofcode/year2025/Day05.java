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

  private void run(final Scanner in, final ToLongFunction<List<Range>> getPartIngredientCount) {
    final List<Range> ranges = new ArrayList<>();

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

  private static ToLongFunction<List<Range>> getAvailableFreshIngredientsCount(final Scanner in) {
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

  private static long getAllFreshIngredientsCount(final List<Range> ranges) {
    ranges.sort(Comparator.comparing(Range::start));

    final List<Range> merged = new ArrayList<>();
    Range current = ranges.get(0);

    for (int i = 1; i < ranges.size(); ++i) {
      final Range next = ranges.get(i);

      if (next.start <= current.end + 1) {
        current = new Range(current.start, Math.max(current.end, next.end));
      } else {
        merged.add(current);
        current = next;
      }
    }
    merged.add(current);

    return merged.stream().mapToLong(range -> range.end - range.start + 1).sum();
  }

  private record Range(long start, long end) {}
}
