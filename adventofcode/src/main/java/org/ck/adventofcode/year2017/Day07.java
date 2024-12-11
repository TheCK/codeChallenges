package org.ck.adventofcode.year2017;

import java.util.*;
import java.util.function.BiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20170701,
    name = "Day 7: Recursive Circus",
    url = "https://adventofcode.com/2017/day/7",
    category = "2017")
@Solution(
    id = 20170702,
    name = "Day 7: Recursive Circus - Part 2",
    url = "https://adventofcode.com/2017/day/7#part2",
    category = "2017")
public class Day07 extends AOCSolution {
  private static final Pattern LINE_PATTERN =
      Pattern.compile("(?<name>\\w+) \\((?<weight>\\d+)\\) ?(-> (?<above>[\\w, ]+))?");

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, (programs, first) -> first);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, (programs, first) -> String.valueOf(Day07.findDifference(programs, first).newWeight()));
  }

  private void run(
      final Scanner in, final BiFunction<Map<String, Program>, String, String> getResult) {
    final Map<String, Program> programs = new HashMap<>();

    while (in.hasNextLine()) {
      final Matcher matcher = LINE_PATTERN.matcher(in.nextLine());

      if (matcher.find()) {
        if (matcher.group("above") == null) {
          programs.put(
              matcher.group("name"),
              new Program(
                  matcher.group("name"), Integer.parseInt(matcher.group("weight")), List.of()));
        } else {
          programs.put(
              matcher.group("name"),
              new Program(
                  matcher.group("name"),
                  Integer.parseInt(matcher.group("weight")),
                  Arrays.asList(matcher.group("above").split(", "))));
        }
      }
    }

    final Set<String> names = new HashSet<>(programs.keySet());
    programs.values().forEach(program -> program.above().forEach(names::remove));

    print(getResult.apply(programs, names.stream().findFirst().orElseThrow()));
  }

  /**
   * this code assumes that the affected node has more than one neighbour, otherwise the decision
   * would have to happen one level up
   */
  private static Result findDifference(final Map<String, Program> programs, final String current) {
    final Program program = programs.get(current);
    final List<String> aboveList = program.above();

    if (aboveList.isEmpty()) {
      return new WeightResult(program.weight());
    }

    final Map<String, Result> results =
        aboveList.stream()
            .collect(Collectors.toMap(above -> above, above -> findDifference(programs, above)));

    final Optional<Result> maybeNewWeightResult =
        results.values().stream().filter(NewWeightResult.class::isInstance).findFirst();

    if (maybeNewWeightResult.isPresent()) {
      return maybeNewWeightResult.get();
    }

    final LongSummaryStatistics stats =
        results.values().stream().mapToLong(Result::weight).summaryStatistics();
    final long difference = stats.getMax() - stats.getMin();

    if (difference == 0) {
      return new WeightResult(program.weight() + stats.getMin() * stats.getCount());
    }

    final String oddProgramName =
        results.entrySet().stream()
            .collect(Collectors.groupingBy(e -> e.getValue().weight(), Collectors.toList()))
            .values()
            .stream()
            .filter(list -> list.size() == 1)
            .map(list -> list.getFirst().getKey())
            .findFirst()
            .orElseThrow();

    final long oddProgramWeight = programs.get(oddProgramName).weight();

    return new NewWeightResult(
        stats.getMax() == results.get(oddProgramName).weight()
            ? oddProgramWeight - difference
            : oddProgramWeight + difference);
  }

  private sealed interface Result permits NewWeightResult, WeightResult {
    default long newWeight() {
      throw new UnsupportedOperationException();
    }

    default long weight() {
      throw new UnsupportedOperationException();
    }
  }

  private record NewWeightResult(long newWeight) implements Result {}

  private record WeightResult(long weight) implements Result {}

  private record Program(String name, int weight, List<String> above) {}
}
