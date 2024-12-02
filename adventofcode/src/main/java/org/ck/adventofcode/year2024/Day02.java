package org.ck.adventofcode.year2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20240201,
    name = "Day 2: Red-Nosed Reports",
    url = "https://adventofcode.com/2024/day/2",
    category = "2024")
@Solution(
    id = 20240202,
    name = "Day 2: Red-Nosed Reports - Part 2",
    url = "https://adventofcode.com/2024/day/2#part2",
    category = "2024")
public class Day02 extends AOCSolution {

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, List::of);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        list -> {
          final List<List<Integer>> all = new ArrayList<>();
          all.add(list);

          for (int i = 0; i < list.size(); ++i) {
            final List<Integer> tmp = new ArrayList<>(list);
            tmp.remove(i);

            all.add(tmp);
          }

          return all;
        });
  }

  private void run(final Scanner in, Function<List<Integer>, List<List<Integer>>> foo) {
    long safeCount = 0;

    while (in.hasNextLine()) {
      final List<Integer> line = readInput(in);

      final List<List<Integer>> all = foo.apply(line);

      for (List<Integer> t : all) {
        final boolean ascending = t.get(0) - t.get(1) < 0;
        boolean isSafe = true;

        for (int i = 0; i < t.size() - 1; ++i) {
          final int difference = t.get(i) - t.get(i + 1);

          if (levelsAreValid(ascending, difference)) {
            isSafe = false;
            break;
          }
        }

        if (isSafe) {
          ++safeCount;
          break;
        }
      }
    }

    print(safeCount);
  }

  private static boolean levelsAreValid(final boolean ascending, final int difference) {
    return (ascending && difference > 0)
        || (!ascending && difference < 0)
        || !(Math.abs(difference) >= 1 && Math.abs(difference) <= 3);
  }

  private static List<Integer> readInput(final Scanner in) {
    final List<Integer> line = new ArrayList<>();

    for (String part : in.nextLine().split(" ")) {
      line.add(Integer.parseInt(part));
    }

    return line;
  }
}
