package org.ck.adventofcode.year2016;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.apache.commons.lang3.NotImplementedException;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.adventofcode.year2016.common.AssemBunnyComputer;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20162501,
    name = "Day 25: Clock Signal",
    url = "https://adventofcode.com/2016/day/25",
    category = "2016")
public class Day25 extends AOCSolution {
  private static final int FOREVER_COUNT = 100;

  @Override
  protected void runPartOne(final Scanner in) {
    run(in);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    throw new NotImplementedException();
  }

  private void run(final Scanner in) {
    final List<String> commands = new ArrayList<>();

    while (in.hasNextLine()) {
      commands.add(in.nextLine());
    }

    int a = 0;
    while (true) {
      final AssemBunnyComputer computer =
          new AssemBunnyComputer(commands, Map.of("a", a, "b", 0, "c", 0, "d", 0));
      final List<Integer> output = computer.runWithWantedOutput(FOREVER_COUNT, 1000000);

      if (output.size() == FOREVER_COUNT) {
        boolean matches = true;

        for (int i = 0; i < FOREVER_COUNT; ++i) {
          if (output.get(i) != i % 2) {
            matches = false;
            break;
          }
        }

        if (matches) {
          break;
        }
      }

      ++a;
    }

    print(a);
  }
}
