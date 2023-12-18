package org.ck.adventofcode.year2023;

import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.Scanner;
import java.util.Set;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20231801,
    name = "Day 18: Lavaduct Lagoon",
    url = "https://adventofcode.com/2023/day/18",
    category = "2023",
    solved = false)
@Solution(
    id = 20231802,
    name = "Day 18: Lavaduct Lagoon - Part 2",
    url = "https://adventofcode.com/2023/day/18#part2",
    category = "2023",
    solved = false)
public class Day18 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in);
  }

  private void run(final Scanner in) {
    final Set<Dig> digs = new HashSet<>();
    digs.add(new Dig(0, 0));
    int row = 0;
    int column = 0;

    while (in.hasNextLine()) {
      final String[] line = in.nextLine().split(" ");
      for (int i = 0; i < Integer.parseInt(line[1]); ++i) {
        switch (line[0]) {
          case "R" -> ++column;
          case "L" -> --column;
          case "U" -> --row;
          case "D" -> ++row;
        }

        digs.add(new Dig(row, column));
      }
    }

    IntSummaryStatistics rowStats = digs.stream().mapToInt(Dig::row).summaryStatistics();

    int filled = 0;
    for (int scanRow = rowStats.getMin(); scanRow <= rowStats.getMax(); ++scanRow) {
      final int finalScanRow = scanRow;
      final IntSummaryStatistics columnStats =
          digs.stream()
              .filter(dig -> dig.row() == finalScanRow)
              .mapToInt(Dig::column)
              .summaryStatistics();

      filled += columnStats.getMax() - columnStats.getMin() + 1;
    }
    print(filled);
  }

  private record Dig(int row, int column) {}
}
