package org.ck.adventofcode.year2016.day10;

import java.util.*;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20161002,
    name = "Day 10: Balance Bots - Part 2",
    url = "https://adventofcode.com/2016/day/10#part2",
    category = "2016")
public class Part2 {
  private static final Pattern inventory = Pattern.compile("value (\\d+) goes to bot (\\d+)");
  private static final Pattern logic =
      Pattern.compile(
          "bot (\\d+) gives low to (output|bot) (\\d+) and high to (output|bot) (\\d+)");

  public static void main(String[] args) {
    Map<Integer, List<Integer>> bots = new HashMap<>();
    Map<Integer, Consumer<List<Integer>>> operation = new HashMap<>();
    Map<Integer, Integer> outputs = new HashMap<>();

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String line = in.nextLine();

        final Matcher inventoryMatcher = inventory.matcher(line);
        if (inventoryMatcher.find()) {
          int bot = Integer.parseInt(inventoryMatcher.group(2));
          int value = Integer.parseInt(inventoryMatcher.group(1));

          bots.putIfAbsent(bot, new ArrayList<>());
          bots.get(bot).add(value);
        }

        final Matcher logicMatcher = logic.matcher(line);
        if (logicMatcher.find()) {
          int bot = Integer.parseInt(logicMatcher.group(1));
          int lowTarget = Integer.parseInt(logicMatcher.group(3));
          int highTarget = Integer.parseInt(logicMatcher.group(5));

          String lowSort = logicMatcher.group(2);
          String highSort = logicMatcher.group(4);

          operation.put(
              bot,
              (chips) -> {
                if ("bot".equals(lowSort)) {
                  bots.putIfAbsent(lowTarget, new ArrayList<>());
                  bots.get(lowTarget).add(Math.min(chips.get(0), chips.get(1)));
                } else {
                  outputs.put(lowTarget, Math.min(chips.get(0), chips.get(1)));
                }

                if ("bot".equals(highSort)) {
                  bots.putIfAbsent(highTarget, new ArrayList<>());
                  bots.get(highTarget).add(Math.max(chips.get(0), chips.get(1)));
                } else {
                  outputs.put(highTarget, Math.max(chips.get(0), chips.get(1)));
                }
              });
        }
      }
    }

    while (!(outputs.containsKey(0) && outputs.containsKey(1) && outputs.containsKey(2))) {
      HashSet<Integer> currentBots = new HashSet<>(bots.keySet());
      for (Integer bot : currentBots) {
        if (bots.get(bot).size() == 2) {
          operation.get(bot).accept(bots.get(bot));
          bots.put(bot, new ArrayList<>());
        }
      }
    }

    System.out.println(outputs.get(0) * outputs.get(1) * outputs.get(2));
  }
}
