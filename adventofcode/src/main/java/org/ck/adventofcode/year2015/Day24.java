package org.ck.adventofcode.year2015;

import java.util.*;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20152401,
    name = "Day 24: It Hangs in the Balance",
    url = "https://adventofcode.com/2015/day/24",
    category = "2015")
@Solution(
    id = 20152402,
    name = "Day 24: It Hangs in the Balance - Part 2",
    url = "https://adventofcode.com/2015/day/24#part2",
    category = "2015")
public class Day24 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, 3);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, 4);
  }

  private void run(final Scanner in, final int groupCount) {
    final List<Integer> weights = new ArrayList<>();

    while (in.hasNextInt()) {
      weights.add(in.nextInt());
    }

    weights.sort((x1, x2) -> Integer.compare(x2, x1));
    final int wantedWeight = weights.stream().mapToInt(i -> i).sum() / groupCount;

    final Queue<Set<Integer>> combos = new PriorityQueue<>(Comparator.comparingInt(Set::size));
    combos.addAll(select(weights, wantedWeight, 0));

    int amount = Integer.MAX_VALUE;
    long entanglement = Long.MAX_VALUE;

    while (!combos.isEmpty()) {
      final Set<Integer> candidate = combos.poll();

      if (candidate.size() > amount) {
        break;
      }

      if (isValid(candidate, weights, wantedWeight, groupCount)) {
        final long newEntanglement =
            candidate.stream().mapToLong(i -> i).reduce(1, (i1, i2) -> i1 * i2);

        if (candidate.size() == amount) {
          entanglement = Math.min(entanglement, newEntanglement);
        } else {
          amount = candidate.size();
          entanglement = newEntanglement;
        }
      }
    }

    print(entanglement);
  }

  private static boolean isValid(
      final Set<Integer> candidate,
      final List<Integer> weights,
      final int wantedWeight,
      final int groupCount) {
    final List<Integer> remainders = new ArrayList<>(weights);
    remainders.removeAll(candidate);

    final List<Set<Integer>> selects = select(remainders, wantedWeight, 0);

    for (final Set<Integer> select : selects) {
      final List<Integer> moreRemainders = new ArrayList<>(remainders);
      moreRemainders.removeAll(select);

      if (groupCount == 4) {
        final List<Set<Integer>> moreSelects = select(moreRemainders, wantedWeight, 0);

        for (final Set<Integer> moreSelect : moreSelects) {
          final List<Integer> lastBag = new ArrayList<>(moreRemainders);
          moreRemainders.removeAll(moreSelect);

          if (lastBag.stream().mapToInt(i -> i).sum() == wantedWeight) {
            return true;
          }
        }
      } else {
        if (moreRemainders.stream().mapToInt(i -> i).sum() == wantedWeight) {
          return true;
        }
      }
    }

    return false;
  }

  private static List<Set<Integer>> select(
      final List<Integer> weights, final int wantedWeight, final int index) {
    final List<Set<Integer>> combos = new ArrayList<>();

    for (int i = index; i < weights.size(); ++i) {
      final int current = weights.get(i);

      if (current < wantedWeight) {
        final List<Set<Integer>> others = select(weights, wantedWeight - current, i + 1);

        for (final Set<Integer> set : others) {
          set.add(current);
          combos.add(set);
        }
      } else if (current == wantedWeight) {
        final Set<Integer> set = new HashSet<>();
        set.add(current);

        final List<Set<Integer>> list = new ArrayList<>();
        list.add(set);

        return list;
      }
    }

    return combos;
  }
}
