package org.ck.adventofcode.year2023;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20230801,
    name = "Day 8: Haunted Wasteland",
    url = "https://adventofcode.com/2023/day/8",
    category = "2023")
@Solution(
    id = 20230802,
    name = "Day 8: Haunted Wasteland - Part 2",
    url = "https://adventofcode.com/2023/day/8#part2",
    category = "2023")
public class Day08 extends AOCSolution {
  private static final Pattern PATH_PATTERN =
      Pattern.compile("(?<location>[\\dA-Z]+) = \\((?<left>[\\dA-Z]+), (?<right>[\\dA-Z]+)\\)");

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, locations -> Set.of("AAA"), "ZZZ"::equals);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        locations ->
            locations.stream()
                .filter(location -> location.endsWith("A"))
                .collect(Collectors.toSet()),
        location -> location.endsWith("Z"));
  }

  /**
   * this code makes the following assumptions about the input that seem to hold for all provided
   * inputs
   *
   * <p>1. There is only one end xxZ reachable from any start xxA. i.e. there is no path xxA -> ...
   * -> xxZ -> ... -> yyZ -> ... -> xxZ
   *
   * <p>2. The step count between a start and the end is the same as from the end back to itself.
   * i.e. there are equal steps in xxA -> ... -> xxZ and xxZ -> ... -> xxZ
   */
  private void run(
      final Scanner in,
      final UnaryOperator<Set<String>> getStartingNodes,
      final Predicate<String> isEnd) {
    final String directions = in.nextLine();
    in.nextLine();

    final Map<String, Path> paths = new HashMap<>();
    while (in.hasNextLine()) {
      final Matcher matcher = PATH_PATTERN.matcher(in.nextLine());

      if (matcher.find()) {
        paths.put(
            matcher.group("location"), new Path(matcher.group("left"), matcher.group("right")));
      }
    }

    final List<Integer> stepsToFinish = new ArrayList<>();

    final Set<String> locations = getStartingNodes.apply(paths.keySet());
    for (final String startingLocation : locations) {
      String location = startingLocation;
      int steps = 0;

      while (!isEnd.test(location)) {
        location =
            directions.charAt(steps % directions.length()) == 'L'
                ? paths.get(location).left()
                : paths.get(location).right();

        ++steps;
      }

      stepsToFinish.add(steps);
    }

    long lcm = 1;

    for (final long steps : stepsToFinish) {
      lcm *= steps / gcd(Math.max(lcm, steps), Math.min(lcm, steps));
    }

    print(lcm);
  }

  private long gcd(final long a, final long b) {
    if (b == 0) {
      return a;
    }

    return gcd(b, a % b);
  }

  private record Path(String left, String right) {}
}
