package org.ck.adventofcode.year2015;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Gatherer;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20150301,
    name = "Day 3: Perfectly Spherical Houses in a Vacuum",
    url = "https://adventofcode.com/2015/day/3",
    category = "2015")
@Solution(
    id = 20150302,
    name = "Day 3: Perfectly Spherical Houses in a Vacuum - Part 2",
    url = "https://adventofcode.com/2015/day/3#part2",
    category = "2015")
public class Day03 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, line -> List.of(line.chars().boxed().toList()));
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        line ->
            line.chars()
                .boxed()
                .<List<Integer>>gather(
                    Gatherer.ofSequential(
                        State::new,
                        (state, element, _) -> {
                          if (state.santa.size() == state.robo.size()) {
                            state.santa.add(element);
                          } else {
                            state.robo.add(element);
                          }

                          return true;
                        },
                        (state, downstream) -> {
                          downstream.push(state.santa);
                          downstream.push(state.robo);
                        }))
                .toList());
  }

  private void run(final Scanner in, final Function<String, List<List<Integer>>> getCommands) {
    final Set<Point> houses = new HashSet<>();

    for (List<Integer> commandLine : getCommands.apply(in.nextLine())) {
      int x = 0;
      int y = 0;

      houses.add(new Point(x, y));

      for (int command : commandLine) {
        switch (command) {
          case '^' -> ++y;
          case '>' -> ++x;
          case 'v' -> --y;
          case '<' -> --x;
          default -> throw new IllegalArgumentException();
        }

        houses.add(new Point(x, y));
      }
    }

    print(houses.size());
  }

  private static final class State {
    private final List<Integer> santa = new ArrayList<>();
    private final List<Integer> robo = new ArrayList<>();
  }

  private record Point(int x, int y) {}
}
