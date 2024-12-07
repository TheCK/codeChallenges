package org.ck.adventofcode.year2016;

import java.util.*;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.adventofcode.year2016.common.AssemBunnyComputer;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20162301,
    name = "Day 23: Safe Cracking",
    url = "https://adventofcode.com/2016/day/23",
    category = "2016")
@Solution(
    id = 20162302,
    name = "Day 23: Safe Cracking - Part 2",
    url = "https://adventofcode.com/2016/day/23",
    category = "2016")
public class Day23 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in);
  }

  private void run(final Scanner in) {
    final List<String> commands = new ArrayList<>();
    final int a = in.nextInt();
    in.nextLine();

    while (in.hasNextLine()) {
      commands.add(in.nextLine());
    }

    final AssemBunnyComputer computer =
        new AssemBunnyComputer(commands, Map.of("a", a, "b", 0, "c", 0, "d", 0));
    computer.run();

    print(computer.getRegisterValue("a"));
  }
}
