package org.ck.adventofcode.year2023;

import java.util.*;
import java.util.function.ToLongFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20230301,
    name = "Day 3: Gear Ratios",
    url = "https://adventofcode.com/2023/day/3",
    category = "2023")
@Solution(
    id = 20230302,
    name = "Day 3: Gear Ratios - Part 2",
    url = "https://adventofcode.com/2023/day/3#part2",
    category = "2023")
public class Day03 extends AOCSolution {
  private static final Pattern NUMBER_PATTERN = Pattern.compile("(\\d+)");

  @Override
  protected void runPartOne(final Scanner in) {
    run(
        in,
        hits -> hits.stream().filter(hit -> !hit.symbols().isEmpty()).mapToLong(Hit::number).sum());
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        hits -> {
          final Map<Symbol, List<NumberWithSymbol>> numbersBySymbols =
              hits.stream()
                  .filter(hit -> !hit.symbols().isEmpty())
                  .flatMap(
                      hit ->
                          hit.symbols().stream()
                              .map(symbol -> new NumberWithSymbol(hit.number(), symbol)))
                  .filter(numberWithSymbol -> numberWithSymbol.symbol().symbol == '*')
                  .collect(Collectors.groupingBy(NumberWithSymbol::symbol));

          return numbersBySymbols.values().stream()
              .filter(numberWithSymbols -> numberWithSymbols.size() == 2)
              .mapToLong(
                  numberWithSymbols ->
                      numberWithSymbols.getFirst().number() * numberWithSymbols.get(1).number())
              .sum();
        });
  }

  private void run(final Scanner in, final ToLongFunction<Set<Hit>> getResult) {
    final List<String> grid = new ArrayList<>();

    while (in.hasNextLine()) {
      grid.add(in.nextLine());
    }

    final Set<Hit> hits = new HashSet<>();

    for (int row = 0; row < grid.size(); ++row) {
      final Matcher matcher = NUMBER_PATTERN.matcher(grid.get(row));
      int start = 0;

      while (matcher.find(start)) {
        final int number = Integer.parseInt(matcher.group(0));

        hits.add(new Hit(number, getSurroundingSymbols(grid, row, matcher.start(), matcher.end())));

        start = matcher.end();
      }
    }

    print(getResult.applyAsLong(hits));
  }

  private Set<Symbol> getSurroundingSymbols(
      final List<String> grid, final int row, final int start, final int end) {
    final Set<Symbol> symbols = new HashSet<>();

    for (int rowToCheck = Math.max(0, row - 1);
        rowToCheck <= Math.min(grid.size() - 1, row + 1);
        ++rowToCheck) {
      for (int columToCheck = Math.max(0, start - 1);
          columToCheck <= Math.min(grid.get(rowToCheck).length() - 1, end);
          ++columToCheck) {
        if (grid.get(rowToCheck).charAt(columToCheck) != '.'
            && !Character.isDigit(grid.get(rowToCheck).charAt(columToCheck))) {
          symbols.add(
              new Symbol(grid.get(rowToCheck).charAt(columToCheck), rowToCheck, columToCheck));
        }
      }
    }

    return symbols;
  }

  private record Hit(long number, Set<Symbol> symbols) {}

  private record Symbol(char symbol, int row, int column) {}

  private record NumberWithSymbol(long number, Symbol symbol) {}
}
