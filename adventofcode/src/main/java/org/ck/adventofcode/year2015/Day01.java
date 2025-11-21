package org.ck.adventofcode.year2015;

import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
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
    run(in, _ -> true, state -> state.floor);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, floor -> floor >= 0, state -> state.position - 1);
  }

  private void run(
      final Scanner in,
      final IntPredicate continueCondition,
      final ToIntFunction<State> getResult) {
    final State state = new State(0, 1);

    print(
        in.nextLine()
            .chars()
            .boxed()
            .takeWhile(_ -> continueCondition.test(state.floor))
            .collect(
                Collector.of(
                    () -> state,
                    Day01::moveElevator,
                    (_, _) -> null,
                    _ -> getResult.applyAsInt(state))));
  }

  private static void moveElevator(final State state, final int element) {
    state.floor += element == '(' ? 1 : -1;
    state.position += 1;
  }

  private static final class State {
    private int floor;
    private int position;

    public State(final int floor, final int position) {
      this.floor = floor;
      this.position = position;
    }
  }
}
