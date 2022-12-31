package org.ck.adventofcode.year2015.day16;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20151601,
    name = "Day 16: Aunt Sue",
    url = "https://adventofcode.com/2015/day/16",
    category = "2015")
public class Part1 {
  private static final Pattern pattern =
      Pattern.compile("Sue (\\d+): ([a-z]+): (\\d+), ([a-z]+): (\\d+), ([a-z]+): (\\d+)");

  private static final Map<String, Function<Integer, Boolean>> objects =
      new HashMap<>() {
        {
          put("children", (number) -> number == 3);
          put("cats", (number) -> number == 7);
          put("samoyeds", (number) -> number == 2);
          put("pomeranians", (number) -> number == 3);
          put("akitas", (number) -> number == 0);
          put("vizslas", (number) -> number == 0);
          put("goldfish", (number) -> number == 5);
          put("trees", (number) -> number == 3);
          put("cars", (number) -> number == 2);
          put("perfumes", (number) -> number == 1);
        }
      };

  public static void main(String[] args) throws Exception {
    Map<String, Map<String, Integer>> aunts = new HashMap<>();

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        Matcher matcher = pattern.matcher(in.nextLine());

        if (matcher.find()) {
          String aunt = matcher.group(1);

          aunts.put(aunt, new HashMap<>());
          aunts.get(aunt).put(matcher.group(2), Integer.parseInt(matcher.group(3)));
          aunts.get(aunt).put(matcher.group(4), Integer.parseInt(matcher.group(5)));
          aunts.get(aunt).put(matcher.group(6), Integer.parseInt(matcher.group(7)));
        }
      }
    }

    Optional<String> aunt =
        aunts.entrySet().stream()
            .filter(
                entry -> {
                  boolean matches = true;

                  for (String object : objects.keySet()) {
                    if (entry.getValue().containsKey(object)
                        && !objects.get(object).apply(entry.getValue().get(object))) {
                      matches = false;
                      break;
                    }
                  }

                  return matches;
                })
            .map(Map.Entry::getKey)
            .findFirst();

    aunt.ifPresent(System.out::println);
  }
}
