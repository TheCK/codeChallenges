package org.ck.adventofcode.year2023;

import java.util.Scanner;
import java.util.function.ToLongFunction;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20230201,
    name = "Day 2: Cube Conundrum",
    url = "https://adventofcode.com/2023/day/2",
    category = "2023")
@Solution(
    id = 20230202,
    name = "Day 2: Cube Conundrum - Part 2",
    url = "https://adventofcode.com/2023/day/2#part2",
    category = "2023")
public class Day02 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(
        in,
        game -> {
          boolean valid = true;
          for (final String round : game[1].split("; ")) {
            for (final String draw : round.split(", ")) {
              final String[] colorAmount = draw.split(" ");

              valid =
                  Integer.parseInt(colorAmount[0])
                      <= switch (colorAmount[1]) {
                        case "red" -> 12;
                        case "green" -> 13;
                        case "blue" -> 14;
                        default -> 0;
                      };

              if (!valid) {
                break;
              }
            }

            if (!valid) {
              break;
            }
          }

          if (valid) {
            return Integer.parseInt(game[0].substring(5));
          }

          return 0;
        });
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        game -> {
          long reds = 0;
          long greens = 0;
          long blues = 0;

          for (final String round : game[1].split("; ")) {
            for (final String draw : round.split(", ")) {
              final String[] colorAmount = draw.split(" ");

              final long amount = Long.parseLong(colorAmount[0]);

              switch (colorAmount[1]) {
                case "red" -> reds = Math.max(reds, amount);
                case "green" -> greens = Math.max(greens, amount);
                case "blue" -> blues = Math.max(blues, amount);
                default -> {}
              }
            }
          }

          return reds * greens * blues;
        });
  }

  private void run(final Scanner in, final ToLongFunction<String[]> getGameValue) {
    long sum = 0;

    while (in.hasNextLine()) {
      final String[] game = in.nextLine().split(": ");

      sum += getGameValue.applyAsLong(game);
    }

    print(sum);
  }
}
