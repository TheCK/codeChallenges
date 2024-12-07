package org.ck.adventofcode.year2016;

import java.util.*;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.adventofcode.year2016.common.AssemBunnyComputer;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20161201,
    name = "Day 12: Leonardo's Monorail",
    url = "https://adventofcode.com/2016/day/12",
    category = "2016")
@Solution(
    id = 20161202,
    name = "Day 12: Leonardo's Monorail - Part 2",
    url = "https://adventofcode.com/2016/day/12#part2",
    category = "2016")
public class Day12 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, 0);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, 1);
  }

  private void run(final Scanner in, final int c) {
    final List<String> commands = new ArrayList<>();

    while (in.hasNextLine()) {
      commands.add(in.nextLine());
    }

    final AssemBunnyComputer computer =
        new AssemBunnyComputer(commands, Map.of("a", 0, "b", 0, "c", c, "d", 0));
    computer.run();

    print(computer.getRegisterValue("a"));
  }
}
