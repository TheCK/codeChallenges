package org.ck.adventofcode.year2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.lang3.NotImplementedException;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20242501,
    name = "Day 25: Code Chronicle",
    url = "https://adventofcode.com/2024/day/25",
    category = "2024")
public class Day25 extends AOCSolution {

  @Override
  protected void runPartOne(final Scanner in) {
    run(in);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    throw new NotImplementedException();
  }

  private void run(final Scanner in) {
    final List<Key> keys = new ArrayList<>();
    final List<Lock> locks = new ArrayList<>();

    Component component = null;
    while (in.hasNextLine()) {
      final String line = in.nextLine();

      if (component == null && "#####".equals(line)) {
        component =
            new Key(
                List.of(
                    new AtomicInteger(1),
                    new AtomicInteger(1),
                    new AtomicInteger(1),
                    new AtomicInteger(1),
                    new AtomicInteger(1)));
        keys.add((Key) component);
      } else if (component == null && ".....".equals(line)) {
        component =
            new Lock(
                List.of(
                    new AtomicInteger(0),
                    new AtomicInteger(0),
                    new AtomicInteger(0),
                    new AtomicInteger(0),
                    new AtomicInteger(0)));
        locks.add((Lock) component);
      } else if (line.isBlank()) {
        component = null;
      } else if (component != null) {
        for (int i = 0; i < line.length(); i++) {
          if (line.charAt(i) == '#') {
            component.heights().get(i).set(component.heights().get(i).get() + 1);
          }
        }
      }
    }

    print(getMatchingPairs(locks, keys));
  }

  private static long getMatchingPairs(final List<Lock> locks, final List<Key> keys) {
    long sum = 0;

    for (Lock lock : locks) {
      for (Key key : keys) {
        boolean fits = true;

        for (int i = 0; i < lock.heights().size(); ++i) {
          if (lock.heights().get(i).get() + key.heights().get(i).get() > 7) {
            fits = false;
            break;
          }
        }

        if (fits) {
          ++sum;
        }
      }
    }
    return sum;
  }

  private sealed interface Component permits Key, Lock {
    List<AtomicInteger> heights();
  }

  private record Key(List<AtomicInteger> heights) implements Component {}

  private record Lock(List<AtomicInteger> heights) implements Component {}
}
