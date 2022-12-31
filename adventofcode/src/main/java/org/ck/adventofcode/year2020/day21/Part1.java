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
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20202101,
    name = "Day 21: Allergen Assessment",
    url = "https://adventofcode.com/2020/day/21",
    category = "2020")
public class Part1 {
  private static final Pattern menuPattern = Pattern.compile("([a-z ]+) \\(contains ([a-z, ]+)\\)");

  public static void main(String[] args) {
    Map<String, List<String>> possibleAllergens = new HashMap<>();
    Map<String, Integer> occurrences = new HashMap<>();

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        Matcher menuMatcher = menuPattern.matcher(in.nextLine());

        if (!menuMatcher.matches()) {
          throw new InputMismatchException("bad input");
        }

        List<String> ingredients = Arrays.asList(menuMatcher.group(1).split(" "));
        List<String> allergens = Arrays.asList(menuMatcher.group(2).split(", "));

        ingredients.forEach(
            ingredient -> occurrences.put(ingredient, occurrences.getOrDefault(ingredient, 0) + 1));

        for (String allergen : allergens) {
          possibleAllergens.computeIfAbsent(allergen, key -> new ArrayList<>(ingredients));
          possibleAllergens.get(allergen).retainAll(ingredients);
        }
      }
    }

    System.out.println(
        occurrences.entrySet().stream()
            .filter(
                ingredient ->
                    possibleAllergens.entrySet().stream()
                        .noneMatch(entry -> entry.getValue().contains(ingredient.getKey())))
            .mapToInt(Entry::getValue)
            .sum());
  }
}
