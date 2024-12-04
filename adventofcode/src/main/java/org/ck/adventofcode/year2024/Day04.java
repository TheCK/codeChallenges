package org.ck.adventofcode.year2024;

import java.util.*;
import java.util.function.IntFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20240401,
    name = "Day 4: Ceres Search",
    url = "https://adventofcode.com/2024/day/4",
    category = "2024")
@Solution(
    id = 20240402,
    name = "Day 4: Ceres Search - Part 2",
    url = "https://adventofcode.com/2024/day/4#part2",
    category = "2024")
public class Day04 extends AOCSolution {
  private static final String XMAS = "XMAS";
  private static final String SAMX = "SAMX";
  private static final String XMAS_OTHERS = "X.{%1$d}M.{%1$d}A.{%1$d}S";
  private static final String SAMX_OTHERS = "S.{%1$d}A.{%1$d}M.{%1$d}X";
  private static final String X_MAS_PATTERN =
      "([MS])[^\\n]([MS]).{%1$d}A.{%1$d}((?!\\2)[MS]).((?!\\1)[MS])";

  @Override
  protected void runPartOne(final Scanner in) {
    run(
        in,
        l ->
            List.of(
                Pattern.compile(XMAS),
                Pattern.compile(SAMX),
                Pattern.compile(XMAS_OTHERS.formatted(l), Pattern.DOTALL),
                Pattern.compile(SAMX_OTHERS.formatted(l), Pattern.DOTALL),
                Pattern.compile(XMAS_OTHERS.formatted(l + 1), Pattern.DOTALL),
                Pattern.compile(SAMX_OTHERS.formatted(l + 1), Pattern.DOTALL),
                Pattern.compile(XMAS_OTHERS.formatted(l - 1), Pattern.DOTALL),
                Pattern.compile(SAMX_OTHERS.formatted(l - 1), Pattern.DOTALL)));
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, l -> List.of(Pattern.compile(X_MAS_PATTERN.formatted(l - 1), Pattern.DOTALL)));
  }

  private void run(final Scanner in, IntFunction<List<Pattern>> getPatterns) {
    final List<String> grid = new ArrayList<>();

    while (in.hasNextLine()) {
      grid.add(in.nextLine());
    }

    final String text = String.join("\n", grid);
    final int lineLength = grid.getFirst().length();
    final List<Pattern> patterns = getPatterns.apply(lineLength);

    long count = 0;
    for (Pattern pattern : patterns) {
      final Matcher matcher = pattern.matcher(text);

      int start = 0;
      while (matcher.find(start)) {
        start = matcher.start() + 1;

        ++count;
      }
    }

    print(count);
  }
}
