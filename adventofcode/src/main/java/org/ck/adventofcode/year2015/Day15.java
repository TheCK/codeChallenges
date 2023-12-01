package org.ck.adventofcode.year2015;

import java.util.*;
import java.util.function.LongPredicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20151501,
    name = "Day 15: Science for Hungry People",
    url = "https://adventofcode.com/2015/day/15",
    category = "2015")
@Solution(
    id = 20151502,
    name = "Day 15: Science for Hungry People - Part 2",
    url = "https://adventofcode.com/2015/day/15#part2",
    category = "2015")
public class Day15 extends AOCSolution {
  private static final Pattern PATTERN =
      Pattern.compile(
          "(?<name>[a-zA-Z]+): "
              + "capacity (?<capacity>-?\\d+), "
              + "durability (?<durability>-?\\d+), "
              + "flavor (?<flavor>-?\\d+), "
              + "texture (?<texture>-?\\d+), "
              + "calories (?<calories>-?\\d+)");

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, calories -> true);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, calories -> calories == 500);
  }

  private void run(final Scanner in, final LongPredicate couldBeBest) {
    final Map<String, Ingredient> ingredients = new HashMap<>();

    while (in.hasNextLine()) {
      final String line = in.nextLine();
      final Matcher matcher = PATTERN.matcher(line);

      if (matcher.find()) {
        ingredients.put(
            matcher.group("name"),
            new Ingredient(
                Integer.parseInt(matcher.group("capacity")),
                Integer.parseInt(matcher.group("durability")),
                Integer.parseInt(matcher.group("flavor")),
                Integer.parseInt(matcher.group("texture")),
                Integer.parseInt(matcher.group("calories"))));
      }
    }

    final List<Map<String, Integer>> combos = getCombos(new ArrayList<>(ingredients.keySet()), 100);

    long best = 0;

    for (Map<String, Integer> combo : combos) {
      if (combo.values().stream().mapToInt(n -> n).sum() != 100) {
        continue;
      }

      long capacity = 0;
      long durability = 0;
      long flavor = 0;
      long texture = 0;
      long calories = 0;

      for (final Map.Entry<String, Integer> ingredient : combo.entrySet()) {
        if (ingredient.getValue() != 0) {
          capacity +=
              (long) ingredient.getValue() * ingredients.get(ingredient.getKey()).capacity();
          durability +=
              (long) ingredient.getValue() * ingredients.get(ingredient.getKey()).durability();
          flavor += (long) ingredient.getValue() * ingredients.get(ingredient.getKey()).flavor();
          texture += (long) ingredient.getValue() * ingredients.get(ingredient.getKey()).texture();
          calories +=
              (long) ingredient.getValue() * ingredients.get(ingredient.getKey()).calories();
        }
      }

      if (couldBeBest.test(calories)) {
        best =
            Math.max(
                Math.max(0, capacity)
                    * Math.max(0, durability)
                    * Math.max(0, flavor)
                    * Math.max(0, texture),
                best);
      }
    }

    print(best);
  }

  private static List<Map<String, Integer>> getCombos(
      final List<String> ingredients, final int rest) {
    final List<Map<String, Integer>> combos = new ArrayList<>();

    final String current = ingredients.get(0);
    for (int i = 1; i <= rest; ++i) {
      final List<String> remaining = new ArrayList<>(ingredients);
      remaining.remove(current);

      if (!remaining.isEmpty()) {
        final List<Map<String, Integer>> others = getCombos(remaining, rest - i);
        for (final Map<String, Integer> combo : others) {
          combo.put(current, i);
          combos.add(combo);
        }
      } else {
        final HashMap<String, Integer> n = new HashMap<>();
        n.put(current, i);
        combos.add(n);
      }
    }

    return combos;
  }

  private record Ingredient(int capacity, int durability, int flavor, int texture, int calories) {}
}
