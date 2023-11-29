package org.ck.adventofcode.year2015;

import java.util.*;
import java.util.function.IntBinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20150901,
    name = "Day 9: All in a Single Night",
    url = "https://adventofcode.com/2015/day/9",
    category = "2015")
@Solution(
    id = 20150902,
    name = "Day 9: All in a Single Night - Part 2",
    url = "https://adventofcode.com/2015/day/9#part2",
    category = "2015")
public class Day09 extends AOCSolution {
  private static final Pattern PATTERN =
      Pattern.compile("(?<from>\\p{L}+) to (?<to>\\p{L}+) = (?<distance>\\d+)");

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, Integer.MAX_VALUE, Math::min);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, Integer.MIN_VALUE, Math::max);
  }

  private void run(
      final Scanner in, final int initialValue, final IntBinaryOperator getBestDistance) {
    final Set<String> cities = new HashSet<>();
    final Map<String, Integer> distances = new HashMap<>();

    while (in.hasNextLine()) {
      final Matcher matcher = PATTERN.matcher(in.nextLine());

      if (matcher.find()) {
        final String from = matcher.group("from");
        final String to = matcher.group("to");
        final int distance = Integer.parseInt(matcher.group("distance"));

        cities.add(from);
        cities.add(to);

        distances.put(to + from, distance);
        distances.put(from + to, distance);
      }
    }

    print(getDistance(cities, distances, "", initialValue, getBestDistance));
  }

  private static int getDistance(
      final Set<String> cities,
      final Map<String, Integer> distances,
      final String previous,
      final int initialValue,
      final IntBinaryOperator getBestDistance) {
    if (cities.isEmpty()) {
      return 0;
    }

    int best = initialValue;
    for (String city : cities) {
      final Set<String> copy = new HashSet<>(cities);
      copy.remove(city);

      final int distance =
          getDistance(copy, distances, city, initialValue, getBestDistance)
              + distances.getOrDefault(city + previous, 0);
      best = getBestDistance.applyAsInt(distance, best);
    }

    return best;
  }
}
