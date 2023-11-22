package org.ck.adventofcode.year2017;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntUnaryOperator;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20170501,
    name = "Day 5: A Maze of Twisty Trampolines, All Alike",
    url = "https://adventofcode.com/2017/day/5",
    category = "2017")
@Solution(
    id = 20170502,
    name = "Day 5: A Maze of Twisty Trampolines, All Alike - Part 2",
    url = "https://adventofcode.com/2017/day/5#part2",
    category = "2017")
public class Day05 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, jump -> 1);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, jump -> jump >= 3 ? -1 : 1);
  }

  private void run(final Scanner in, final IntUnaryOperator getJumpChange) {
    final List<Integer> jumps = new ArrayList<>();

    while (in.hasNextInt()) {
      jumps.add(in.nextInt());
    }

    int pointer = 0;
    int counter = 0;

    while (pointer < jumps.size()) {
      final int jump = jumps.get(pointer);

      jumps.set(pointer, jumps.get(pointer) + getJumpChange.applyAsInt(jump));
      pointer = pointer + jump;

      ++counter;
    }

    print(counter);
  }
}
