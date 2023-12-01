package org.ck.adventofcode.year2015;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20151601,
    name = "Day 16: Aunt Sue",
    url = "https://adventofcode.com/2015/day/16",
    category = "2015")
@Solution(
    id = 20151602,
    name = "Day 16: Aunt Sue - Part 2",
    url = "https://adventofcode.com/2015/day/16#part2",
    category = "2015")
public class Day16 extends AOCSolution {
  private static final Pattern PATTERN =
      Pattern.compile(
          "Sue (?<number>\\d+): "
              + "(?<name1>[a-z]+): (?<value1>\\d+), "
              + "(?<name2>[a-z]+): (?<value2>\\d+), "
              + "(?<name3>[a-z]+): (?<value3>\\d+)");

  private static final Map<String, Function<Integer, Boolean>> SUES_OBJECTS =
      Map.of(
          "children", number -> number == 3,
          "cats", number -> number == 7,
          "samoyeds", number -> number == 2,
          "pomeranians", number -> number == 3,
          "akitas", number -> number == 0,
          "vizslas", number -> number == 0,
          "goldfish", number -> number == 5,
          "trees", number -> number == 3,
          "cars", number -> number == 2,
          "perfumes", number -> number == 1);

  private static final Map<String, Function<Integer, Boolean>> CORRECT_SUES_OBJECT =
      Map.of(
          "children", number -> number == 3,
          "cats", number -> number > 7,
          "samoyeds", number -> number == 2,
          "pomeranians", number -> number < 3,
          "akitas", number -> number == 0,
          "vizslas", number -> number == 0,
          "goldfish", number -> number < 5,
          "trees", number -> number > 3,
          "cars", number -> number == 2,
          "perfumes", number -> number == 1);

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, SUES_OBJECTS);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, CORRECT_SUES_OBJECT);
  }

  private void run(final Scanner in, final Map<String, Function<Integer, Boolean>> mfcsam) {
    final Map<String, Map<String, Integer>> aunts = new HashMap<>();

    while (in.hasNextLine()) {
      final Matcher matcher = PATTERN.matcher(in.nextLine());

      if (matcher.find()) {
        final String aunt = matcher.group("number");

        aunts.put(aunt, new HashMap<>());
        aunts.get(aunt).put(matcher.group("name1"), Integer.valueOf(matcher.group("value1")));
        aunts.get(aunt).put(matcher.group("name2"), Integer.valueOf(matcher.group("value2")));
        aunts.get(aunt).put(matcher.group("name3"), Integer.valueOf(matcher.group("value3")));
      }
    }

    Optional<String> aunt =
        aunts.entrySet().stream()
            .filter(
                entry -> {
                  boolean matches = true;

                  for (Map.Entry<String, Function<Integer, Boolean>> object : mfcsam.entrySet()) {
                    if (entry.getValue().containsKey(object.getKey())
                        && Boolean.TRUE.equals(
                            !object.getValue().apply(entry.getValue().get(object.getKey())))) {
                      matches = false;
                      break;
                    }
                  }

                  return matches;
                })
            .map(Map.Entry::getKey)
            .findFirst();

    aunt.ifPresent(this::print);
  }
}
