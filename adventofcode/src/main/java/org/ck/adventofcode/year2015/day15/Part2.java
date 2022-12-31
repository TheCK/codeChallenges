package org.ck.adventofcode.year2015.day15;

import org.ck.codechallengelib.annotation.Solution;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Solution(
    id = 20151502,
    name = "Day 15: Science for Hungry People - Part 2",
    url = "https://adventofcode.com/2015/day/15#part2",
    category = "2015")
public class Part2 {
  private static final Pattern pattern =
      Pattern.compile(
          "([a-zA-Z]+): capacity (-?\\d+), durability (-?\\d+), flavor (-?\\d+), texture (-?\\d+), calories (-?\\d+)");

  public static void main(String[] args) throws Exception {
    Map<String, Ingredient> ingredients = new HashMap<>();

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String line = in.nextLine();
        final Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
          ingredients.put(
              matcher.group(1),
              new Ingredient(
                  Integer.parseInt(matcher.group(2)),
                  Integer.parseInt(matcher.group(3)),
                  Integer.parseInt(matcher.group(4)),
                  Integer.parseInt(matcher.group(5)),
                  Integer.parseInt(matcher.group(6))));
        }
      }
    }

    List<Map<String, Integer>> combos = getCombos(new ArrayList<>(ingredients.keySet()), 100);

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

      for (Map.Entry<String, Integer> ingredient : combo.entrySet()) {
        capacity += (long) ingredient.getValue() * ingredients.get(ingredient.getKey()).capacity();
        durability +=
            (long) ingredient.getValue() * ingredients.get(ingredient.getKey()).durability();
        flavor += (long) ingredient.getValue() * ingredients.get(ingredient.getKey()).flavor();
        texture += (long) ingredient.getValue() * ingredients.get(ingredient.getKey()).texture();
        calories += (long) ingredient.getValue() * ingredients.get(ingredient.getKey()).calories();
      }

      if (calories == 500) {
        best =
            Math.max(
                Math.max(0, capacity)
                    * Math.max(0, durability)
                    * Math.max(0, flavor)
                    * Math.max(0, texture),
                best);
      }
    }

    System.out.println(best);
  }

  private static List<Map<String, Integer>> getCombos(
      final List<String> ingredients, final int rest) {
    List<Map<String, Integer>> combos = new ArrayList<>();

    final String current = ingredients.get(0);
    for (int i = 1; i <= rest; ++i) {
      List<String> remaining = new ArrayList<>(ingredients);
      remaining.remove(current);

      if (remaining.size() > 0) {
        List<Map<String, Integer>> others = getCombos(remaining, rest - i);
        for (Map<String, Integer> combo : others) {
          combo.put(current, i);
          combos.add(combo);
        }
      } else {
        HashMap<String, Integer> n = new HashMap<>();
        n.put(current, i);
        combos.add(n);
      }
    }

    return combos;
  }

  private record Ingredient(int capacity, int durability, int flavor, int texture, int calories) {}
}
