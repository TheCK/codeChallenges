package org.ck.adventofcode.year2015;

import java.util.Scanner;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20150101,
    name = "Day 1: Not Quite Lisp",
    url = "https://adventofcode.com/2015/day/1",
    category = "2015")
@Solution(
    id = 20150102,
    name = "Day 1: Not Quite Lisp - Part 2",
    url = "https://adventofcode.com/2015/day/1#part2",
    category = "2015")
public class Day01 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, (floor) -> false, (floor, position) -> floor);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, (floor) -> floor < 0, (floor, position) -> position);
  }

  private void run(final Scanner in, IntPredicate getBreakCondition, IntBinaryOperator getResult) {
    int floor = 0;
    int position = 1;

    final String path = in.nextLine();

    for (char command : path.toCharArray()) {
      floor += command == '(' ? 1 : -1;

      if (getBreakCondition.test(floor)) {
        break;
      }

      ++position;
    }

    print(getResult.applyAsInt(floor, position));
  }
}
