package org.ck.adventofcode.year2015;

import java.util.*;
import java.util.function.Function;
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
    run(in, List::of);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        (line) -> {
          final List<String> commands = new ArrayList<>();

          final StringBuilder santa = new StringBuilder();
          final StringBuilder robo = new StringBuilder();

          int index = 0;
          for (char command : line.toCharArray()) {
            if (index % 2 == 0) {
              santa.append(command);
            } else {
              robo.append(command);
            }

            ++index;
          }

          commands.add(santa.toString());
          commands.add(robo.toString());

          return commands;
        });
  }

  private void run(final Scanner in, final Function<String, List<String>> getCommands) {
    final List<String> commands = getCommands.apply(in.nextLine());

    final Set<Point> houses = new HashSet<>();

    for (String commandLine : commands) {
      int x = 0;
      int y = 0;

      houses.add(new Point(x, y));
      for (char command : commandLine.toCharArray()) {
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

  private record Point(int x, int y) {}
}
