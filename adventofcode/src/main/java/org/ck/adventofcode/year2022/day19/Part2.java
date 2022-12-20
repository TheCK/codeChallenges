package org.ck.adventofcode.year2022.day19;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

@Solution(
    id = 20221902,
    name = "Day 19: Not Enough Minerals - Part 2",
    url = "https://adventofcode.com/2022/day/19#part2",
    category = "2022",
    solved = false)
public class Part2 {
  private static final Pattern PATTERN =
      Pattern.compile(
          "Blueprint (\\d+): Each ore robot costs (\\d+) ore. Each clay robot costs (\\d+) ore. Each obsidian robot costs (\\d+) ore and (\\d+) clay. Each geode robot costs (\\d+) ore and (\\d+) obsidian.");

  private static Map<State, Integer> cache;

  public static void main(String[] args) {
    List<Blueprint> blueprints = new ArrayList<>();
    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        Matcher matcher = PATTERN.matcher(in.nextLine());

        if (matcher.find()) {
          blueprints.add(
              new Blueprint(
                  Integer.parseInt(matcher.group(1)),
                  Integer.parseInt(matcher.group(2)),
                  Integer.parseInt(matcher.group(3)),
                  Integer.parseInt(matcher.group(4)),
                  Integer.parseInt(matcher.group(5)),
                  Integer.parseInt(matcher.group(6)),
                  Integer.parseInt(matcher.group(7))));
        }
      }
    }

    int qualityLevel = 1;
    for (Blueprint blueprint : blueprints) {
      cache = new HashMap<>();

      int maxGeode = getMaxGeode(blueprint, new State(32, 0, 0, 0, 0, 1, 0, 0, 0));

      qualityLevel *= maxGeode;
    }

    System.out.println(qualityLevel);
  }

  private static int getMaxGeode(final Blueprint blueprint, final State state) {
    if (state.timeLeft() == 0) {
      return 0;
    }

    if (cache.containsKey(state)) {
      return cache.get(state);
    }

    int maxGeode = 0;
    for (Possibility possibility : Possibility.values()) {
      maxGeode =
          Math.max(
              maxGeode,
              switch (possibility) {
                case ORE_BOT -> buildOreBot(blueprint, state);
                case CLAY_BOT -> buildClayBot(blueprint, state);
                case OBSIDIAN_BOT -> buildObsidianBot(blueprint, state);
                case GEODE_BOT -> buildGeodeBot(blueprint, state);
              });
    }

    int geodes = maxGeode;
    cache.put(state, geodes);

    return geodes;
  }

  private static int getWaitTime(
      final State state, final int oreCost, final int clayCost, final int obsidianCost) {
    int waitForOre = oreCost > 0 ? getWaitTime(oreCost, state.ore(), state.oreBots()) : 0;
    int waitForClay = clayCost > 0 ? getWaitTime(clayCost, state.clay(), state.clayBots()) : 0;
    int waitForObsidian =
        obsidianCost > 0 ? getWaitTime(obsidianCost, state.obsidian(), state.obsidianBots()) : 0;

    return IntStream.of(waitForOre, waitForClay, waitForObsidian).max().getAsInt();
  }

  private static int getWaitTime(final int cost, final int resources, final int bots) {
    return bots > 0
        ? Math.max(0, (int) Math.ceil(((double) (cost - resources)) / bots))
        : Integer.MAX_VALUE;
  }

  private static int buildGeodeBot(final Blueprint blueprint, final State state) {
    int waitTime =
        getWaitTime(state, blueprint.geodeBotOreCost(), 0, blueprint.geodeBotObsidianCost());

    if (waitTime < state.timeLeft()) {
      return getMaxGeode(
              blueprint,
              new State(
                  state.timeLeft() - (1 + waitTime),
                  state.ore() + (state.oreBots() * (1 + waitTime)) - blueprint.geodeBotOreCost(),
                  state.clay() + (state.clayBots() * (1 + waitTime)),
                  state.obsidian()
                      + (state.obsidianBots() * (1 + waitTime))
                      - blueprint.geodeBotObsidianCost(),
                  state.geode() + (state.geodeBots() * (1 + waitTime)),
                  state.oreBots(),
                  state.clayBots(),
                  state.obsidianBots(),
                  state.geodeBots() + 1))
          + state.geodeBots() * (1 + waitTime);
    }

    return state.geodeBots() * state.timeLeft();
  }

  private static int buildObsidianBot(final Blueprint blueprint, final State state) {
    int waitTime =
        getWaitTime(state, blueprint.obsidianBotOreCost(), blueprint.obsidianBotClayCost(), 0);

    if (waitTime < state.timeLeft()) {
      return getMaxGeode(
              blueprint,
              new State(
                  state.timeLeft() - (1 + waitTime),
                  state.ore() + (state.oreBots() * (1 + waitTime)) - blueprint.obsidianBotOreCost(),
                  state.clay()
                      + (state.clayBots() * (1 + waitTime))
                      - blueprint.obsidianBotClayCost(),
                  state.obsidian() + (state.obsidianBots() * (1 + waitTime)),
                  state.geode() + (state.geodeBots() * (1 + waitTime)),
                  state.oreBots(),
                  state.clayBots(),
                  state.obsidianBots() + 1,
                  state.geodeBots()))
          + state.geodeBots() * (1 + waitTime);
    }

    return state.geodeBots() * state.timeLeft();
  }

  private static int buildClayBot(final Blueprint blueprint, final State state) {
    int waitTime = getWaitTime(state, blueprint.clayBotOreCost(), 0, 0);

    if (waitTime < state.timeLeft()) {
      return getMaxGeode(
              blueprint,
              new State(
                  state.timeLeft() - (1 + waitTime),
                  state.ore() + (state.oreBots() * (1 + waitTime)) - blueprint.clayBotOreCost(),
                  state.clay() + (state.clayBots() * (1 + waitTime)),
                  state.obsidian() + (state.obsidianBots() * (1 + waitTime)),
                  state.geode() + (state.geodeBots() * (1 + waitTime)),
                  state.oreBots(),
                  state.clayBots() + 1,
                  state.obsidianBots(),
                  state.geodeBots()))
          + state.geodeBots() * (1 + waitTime);
    }

    return state.geodeBots() * state.timeLeft();
  }

  private static int buildOreBot(final Blueprint blueprint, final State state) {
    int waitTime = getWaitTime(state, blueprint.oreBotOreCost(), 0, 0);

    if (waitTime < state.timeLeft()) {
      return getMaxGeode(
              blueprint,
              new State(
                  state.timeLeft() - (1 + waitTime),
                  state.ore() + (state.oreBots() * (1 + waitTime)) - blueprint.oreBotOreCost(),
                  state.clay() + (state.clayBots() * (1 + waitTime)),
                  state.obsidian() + (state.obsidianBots() * (1 + waitTime)),
                  state.geode() + (state.geodeBots() * (1 + waitTime)),
                  state.oreBots() + 1,
                  state.clayBots(),
                  state.obsidianBots(),
                  state.geodeBots()))
          + state.geodeBots() * (1 + waitTime);
    }

    return state.geodeBots() * state.timeLeft();
  }

  enum Possibility {
    ORE_BOT,
    CLAY_BOT,
    OBSIDIAN_BOT,
    GEODE_BOT;
  }

  record Blueprint(
      int id,
      int oreBotOreCost,
      int clayBotOreCost,
      int obsidianBotOreCost,
      int obsidianBotClayCost,
      int geodeBotOreCost,
      int geodeBotObsidianCost) {}

  record State(
      int timeLeft,
      int ore,
      int clay,
      int obsidian,
      int geode,
      int oreBots,
      int clayBots,
      int obsidianBots,
      int geodeBots) {}
}
