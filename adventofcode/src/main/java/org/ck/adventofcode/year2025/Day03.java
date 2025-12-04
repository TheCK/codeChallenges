package org.ck.adventofcode.year2025;

import java.util.Scanner;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20250301,
    name = "Day 3: Lobby ",
    url = "https://adventofcode.com/2025/day/3",
    category = "2025")
@Solution(
    id = 20250302,
    name = "Day 3: Lobby  - Part 2",
    url = "https://adventofcode.com/2025/day/3#part2",
    category = "2025")
public class Day03 extends AOCSolution {

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, 2);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, 12);
  }

  private void run(final Scanner in, final int numberOfBatteries) {
    long jolts = 0;

    while (in.hasNextLine()) {
      final String line = in.nextLine();

      long currentJolts = 0;
      int startIndex = 0;
      for (int battery = numberOfBatteries - 1; battery >= 0; --battery) {
        int maxValue = 0;
        int maxIndex = startIndex;
        for (int i = startIndex; i < line.length() - battery; ++i) {
          final int value = line.charAt(i) - '0';

          if (value > maxValue) {
            maxValue = value;
            maxIndex = i;
          }
        }

        startIndex = maxIndex + 1;
        currentJolts = 10 * currentJolts + maxValue;
      }

      jolts += currentJolts;
    }

    print(jolts);
  }
}
