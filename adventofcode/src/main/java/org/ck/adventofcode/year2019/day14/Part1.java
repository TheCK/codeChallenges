package org.ck.adventofcode.year2019.day14;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20191401,
    name = "Day 14: Space Stoichiometry",
    url = "https://adventofcode.com/2019/day/14",
    category = "2019")
public class Part1 {
  private static final Pattern pattern = Pattern.compile("([0-9]+) ([A-Z]+)");

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      Map<Amount, Set<Amount>> recipes = new HashMap<>();
      while (in.hasNextLine()) {
        String line = in.nextLine();

        List<Amount> resources = new ArrayList<>();

        Matcher containsMatcher = pattern.matcher(line);
        int start = 0;
        while (containsMatcher.find(start)) {
          resources.add(
              new Amount(containsMatcher.group(2), Integer.parseInt(containsMatcher.group(1))));
          start = containsMatcher.end();
        }

        recipes.put(
            resources.get(resources.size() - 1),
            new HashSet<>(resources.subList(0, resources.size() - 1)));
      }

      Queue<Amount> neededResources = new ArrayDeque<>();
      neededResources.add(new Amount("FUEL", 1));
      resolveResources(neededResources, recipes);

      System.out.println(neededResources.remove().amount);
    }
  }

  private static void resolveResources(
      Queue<Amount> neededResources, Map<Amount, Set<Amount>> recipes) {
    while (neededResources.size() != 1 || !"ORE".equals(neededResources.peek().name)) {
      Amount amount = neededResources.remove();

      boolean neededElsewhere =
          getAllRemainingNeededResources(neededResources, recipes).contains(amount.name);

      if (neededElsewhere) {
        neededResources.add(amount);
        continue;
      }

      for (Amount recipeForThis : recipes.get(amount)) {
        long batchSize =
            recipes.keySet().stream()
                .filter(a -> a.name.equals(amount.name))
                .mapToLong(a -> a.amount)
                .sum();

        long needed = amount.amount;
        if (needed % batchSize != 0) {
          needed = batchSize * ((needed / batchSize) + 1);
        }

        long neededTotal = needed / batchSize * recipeForThis.amount;

        if (neededResources.contains(recipeForThis)) {
          neededResources.forEach(
              a -> {
                if (a.name.equals(recipeForThis.name)) {
                  a.amount += neededTotal;
                }
              });
        } else {
          neededResources.add(new Amount(recipeForThis.name, neededTotal));
        }
      }
    }
  }

  private static Set<String> getAllRemainingNeededResources(
      Queue<Amount> neededResources, Map<Amount, Set<Amount>> recipes) {
    Set<String> needed = new HashSet<>();

    for (Amount resource : neededResources) {
      needed.add(resource.name);
      if (recipes.get(resource) != null) {
        needed.addAll(
            getAllRemainingNeededResources(new ArrayDeque<>(recipes.get(resource)), recipes));
      }
    }

    return needed;
  }

  private static class Amount {
    private final String name;
    private long amount;

    public Amount(String name, long amount) {
      this.name = name;
      this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Amount amount1 = (Amount) o;
      return name.equals(amount1.name);
    }

    @Override
    public int hashCode() {
      return Objects.hash(name);
    }
  }
}
