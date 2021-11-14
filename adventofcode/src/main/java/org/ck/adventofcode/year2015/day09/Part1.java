package org.ck.adventofcode.year2015.day09;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.*;
import java.util.function.BiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Solution(
    id = 20150901,
    name = "Day 9: All in a Single Night",
    url = "https://adventofcode.com/2015/day/9",
    category = "2015")
public class Part1 {
  private static final Pattern pattern = Pattern.compile("(\\p{L}+) to (\\p{L}+) = (\\d+)");
  private static final BiFunction<Integer, Integer, Integer> BEST_FUNCTION = Math::min;
  private static final int INITIAL = Integer.MAX_VALUE;

  public static void main(String[] args) throws Exception {
    Set<String> cities = new HashSet<>();
    Map<String, Integer> distances = new HashMap<>();
    int best = INITIAL;

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        Matcher matcher = pattern.matcher(in.nextLine());

        if (matcher.find()) {
          String from = matcher.group(1);
          String to = matcher.group(2);
          int distance = Integer.parseInt(matcher.group(3));

          cities.add(from);
          cities.add(to);

          distances.put(to + from, distance);
          distances.put(from + to, distance);
        }
      }

      int distance = getDistance(cities, distances, "");
      best = BEST_FUNCTION.apply(distance, best);
    }

    System.out.println(best);
  }

  private static int getDistance(
      Set<String> cities, Map<String, Integer> distances, String previous) {
    if (cities.isEmpty()) {
      return 0;
    }

    int best = INITIAL;
    for (String city : cities) {
      Set<String> copy = new HashSet<>(cities);
      copy.remove(city);

      int distance =
          getDistance(copy, distances, city) + distances.getOrDefault(city + previous, 0);
      best = BEST_FUNCTION.apply(distance, best);
    }

    return best;
  }
}
