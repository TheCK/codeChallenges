package org.ck.adventofcode.year2016;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20161001,
    name = "Day 10: Balance Bots",
    url = "https://adventofcode.com/2016/day/10",
    category = "2016")
@Solution(
    id = 20161002,
    name = "Day 10: Balance Bots - Part 2",
    url = "https://adventofcode.com/2016/day/10#part2",
    category = "2016")
public class Day10 extends AOCSolution {
  private static final Pattern INVENTORY =
      Pattern.compile("value (?<value>\\d+) goes to bot (?<bot>\\d+)");
  private static final Pattern LOGIC =
      Pattern.compile(
          "bot (?<bot>\\d+) gives low to (?<lowKind>output|bot) (?<low>\\d+) and high to (?<highKind>output|bot) (?<high>\\d+)");

  @Override
  protected void runPartOne(final Scanner in) {
    final int wanted1 = in.nextInt();
    final int wanted2 = in.nextInt();
    in.nextLine();

    run(
        in,
        (botContent, outputs) -> botContent.contains(wanted1) && botContent.contains(wanted2),
        (bot, outputs) -> bot);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        (botContent, outputs) ->
            outputs.containsKey(0) && outputs.containsKey(1) && outputs.containsKey(2),
        (bot, outputs) -> outputs.get(0) * outputs.get(1) * outputs.get(2));
  }

  private void run(
      final Scanner in,
      final BiPredicate<List<Integer>, Map<Integer, Integer>> stop,
      final BiFunction<Integer, Map<Integer, Integer>, Integer> getOutput) {
    final Map<Integer, List<Integer>> bots = new HashMap<>();
    final Map<Integer, Consumer<List<Integer>>> operations = new HashMap<>();
    final Map<Integer, Integer> outputs = new HashMap<>();

    parseInput(in, bots, operations, outputs);

    while (true) {
      final HashSet<Integer> currentBots = new HashSet<>(bots.keySet());
      for (Integer bot : currentBots) {
        if (stop.test(bots.get(bot), outputs)) {
          print(getOutput.apply(bot, outputs));
          return;
        }

        if (bots.get(bot).size() == 2) {
          operations.get(bot).accept(bots.get(bot));
          bots.put(bot, new ArrayList<>());
        }
      }
    }
  }

  private static void parseInput(
      final Scanner in,
      final Map<Integer, List<Integer>> bots,
      final Map<Integer, Consumer<List<Integer>>> operation,
      final Map<Integer, Integer> outputs) {
    while (in.hasNextLine()) {
      final String line = in.nextLine();

      final Matcher inventoryMatcher = INVENTORY.matcher(line);
      if (inventoryMatcher.find()) {
        parseInventory(bots, inventoryMatcher);
      }

      final Matcher logicMatcher = LOGIC.matcher(line);
      if (logicMatcher.find()) {
        parseLogic(bots, operation, outputs, logicMatcher);
      }
    }
  }

  private static void parseLogic(
      final Map<Integer, List<Integer>> bots,
      final Map<Integer, Consumer<List<Integer>>> operation,
      final Map<Integer, Integer> outputs,
      final Matcher logicMatcher) {
    final int bot = Integer.parseInt(logicMatcher.group("bot"));
    final int lowTarget = Integer.parseInt(logicMatcher.group("low"));
    final int highTarget = Integer.parseInt(logicMatcher.group("high"));

    final String lowKind = logicMatcher.group("lowKind");
    final String highKind = logicMatcher.group("highKind");

    operation.put(
        bot,
        chips -> {
          if ("bot".equals(lowKind)) {
            bots.putIfAbsent(lowTarget, new ArrayList<>());
            bots.get(lowTarget).add(Math.min(chips.get(0), chips.get(1)));
          } else {
            outputs.put(lowTarget, Math.min(chips.get(0), chips.get(1)));
          }

          if ("bot".equals(highKind)) {
            bots.putIfAbsent(highTarget, new ArrayList<>());
            bots.get(highTarget).add(Math.max(chips.get(0), chips.get(1)));
          } else {
            outputs.put(highTarget, Math.max(chips.get(0), chips.get(1)));
          }
        });
  }

  private static void parseInventory(
      final Map<Integer, List<Integer>> bots, final Matcher inventoryMatcher) {
    final int bot = Integer.parseInt(inventoryMatcher.group("bot"));
    final int value = Integer.parseInt(inventoryMatcher.group("value"));

    bots.putIfAbsent(bot, new ArrayList<>());
    bots.get(bot).add(value);
  }
}
