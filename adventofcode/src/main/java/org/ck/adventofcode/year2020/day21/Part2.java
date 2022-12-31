package org.ck.adventofcode.year2020.day21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20202102,
    name = "Day 21: Allergen Assessment - Part 2",
    url = "https://adventofcode.com/2020/day/21",
    category = "2020")
public class Part2 {
  private static final Pattern menuPattern = Pattern.compile("([a-z ]+) \\(contains ([a-z, ]+)\\)");

  public static void main(String[] args) {
    Map<String, List<String>> possibleAllergens = new HashMap<>();

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        Matcher menuMatcher = menuPattern.matcher(in.nextLine());

        if (!menuMatcher.matches()) {
          throw new InputMismatchException("bad input");
        }

        List<String> ingredients = Arrays.asList(menuMatcher.group(1).split(" "));
        String[] allergens = menuMatcher.group(2).split(", ");

        for (String allergen : allergens) {
          possibleAllergens.computeIfAbsent(allergen, key -> new ArrayList<>(ingredients));
          possibleAllergens.get(allergen).retainAll(ingredients);
        }
      }
    }

    while (possibleAllergens.entrySet().stream().anyMatch(entry -> entry.getValue().size() != 1)) {
      for (Entry<String, List<String>> allergenEntry : possibleAllergens.entrySet()) {
        if (allergenEntry.getValue().size() == 1) {
          String ingredient = allergenEntry.getValue().get(0);

          for (Entry<String, List<String>> otherAllergenEntry : possibleAllergens.entrySet()) {
            if (otherAllergenEntry.getKey().equals(allergenEntry.getKey())) {
              continue;
            }

            otherAllergenEntry.getValue().remove(ingredient);
          }
        }
      }
    }

    System.out.println(
        possibleAllergens.entrySet().stream()
            .sorted(Entry.comparingByKey())
            .map(entry -> entry.getValue().get(0))
            .collect(Collectors.joining(",")));
  }
}
