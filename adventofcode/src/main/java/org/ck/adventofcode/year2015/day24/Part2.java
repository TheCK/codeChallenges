package org.ck.adventofcode.year2015.day24;

import java.util.*;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20152402,
    name = "Day 24: It Hangs in the Balance - Part 2",
    url = "https://adventofcode.com/2015/day/24#part2",
    category = "2015")
public class Part2 {
  public static void main(String[] args) throws Exception {
    List<Integer> weights = new ArrayList<>();

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextInt()) {
        weights.add(in.nextInt());
      }
    }

    weights.sort((x1, x2) -> Integer.compare(x2, x1));
    int wantedWeight = weights.stream().mapToInt(i -> i).sum() / 4;

    Queue<Set<Integer>> combos = new PriorityQueue<>(Comparator.comparingInt(Set::size));
    combos.addAll(select(weights, wantedWeight, 0));

    int amount = Integer.MAX_VALUE;
    long entanglement = Long.MAX_VALUE;

    while (!combos.isEmpty()) {
      Set<Integer> candidate = combos.poll();

      if (candidate.size() > amount) {
        break;
      }

      if (isValid(candidate, weights, wantedWeight)) {
        long newEntanglement = candidate.stream().mapToLong(i -> i).reduce(1, (i1, i2) -> i1 * i2);

        if (candidate.size() == amount) {
          entanglement = Math.min(entanglement, newEntanglement);
        } else {
          amount = candidate.size();
          entanglement = newEntanglement;
        }
      }
    }

    System.out.println(entanglement);
  }

  private static boolean isValid(
      final Set<Integer> candidate, final List<Integer> weights, final int wantedWeight) {
    List<Integer> remainders = new ArrayList<>(weights);
    remainders.removeAll(candidate);

    List<Set<Integer>> selects = select(remainders, wantedWeight, 0);

    for (Set<Integer> select : selects) {
      List<Integer> moreRemainders = new ArrayList<>(remainders);
      moreRemainders.removeAll(select);

      List<Set<Integer>> moreSelects = select(moreRemainders, wantedWeight, 0);

      for (Set<Integer> moreSelect : moreSelects) {
        List<Integer> lastBag = new ArrayList<>(moreRemainders);
        moreRemainders.removeAll(moreSelect);

        if (lastBag.stream().mapToInt(i -> i).sum() == wantedWeight) {
          return true;
        }
      }
    }

    return false;
  }

  private static List<Set<Integer>> select(
      final List<Integer> weights, final int wantedWeight, final int index) {
    List<Set<Integer>> combos = new ArrayList<>();

    for (int i = index; i < weights.size(); ++i) {
      int current = weights.get(i);

      if (current < wantedWeight) {
        List<Set<Integer>> others = select(weights, wantedWeight - current, i + 1);

        for (Set<Integer> set : others) {
          set.add(current);
          combos.add(set);
        }
      } else if (current == wantedWeight) {
        Set<Integer> set = new HashSet<>();
        set.add(current);

        List<Set<Integer>> list = new ArrayList<>();
        list.add(set);

        return list;
      }
    }

    return combos;
  }
}
