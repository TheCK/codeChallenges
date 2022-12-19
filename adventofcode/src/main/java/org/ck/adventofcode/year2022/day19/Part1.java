package org.ck.adventofcode.year2022.day19;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Solution(
    id = 20221901,
    name = "Day 19: Not Enough Minerals",
    url = "https://adventofcode.com/2022/day/19",
    category = "2022")
public class Part1 {

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

    int qualityLevel = 0;
    for (Blueprint blueprint : blueprints) {
      cache = new HashMap<>();

      int maxGeode = getMaxGeode(blueprint, new State(24, 0, 0, 0, 1, 0, 0, 0));

      qualityLevel += blueprint.id() * maxGeode;
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
                case ORE_BOT -> blueprint.oreBotOreCost() <= state.ore()
                    ? getMaxGeode(
                        blueprint,
                        new State(
                            state.timeLeft() - 1,
                            state.ore() + state.oreBots() - blueprint.oreBotOreCost(),
                            state.clay() + state.clayBots(),
                            state.obsidian() + state.obsidianBots(),
                            state.oreBots() + 1,
                            state.clayBots(),
                            state.obsidianBots(),
                            state.geodeBots()))
                    : buildNone(blueprint, state);
                case CLAY_BOT -> blueprint.clayBotOreCost() <= state.ore()
                    ? getMaxGeode(
                        blueprint,
                        new State(
                            state.timeLeft() - 1,
                            state.ore() + state.oreBots() - blueprint.clayBotOreCost(),
                            state.clay() + state.clayBots(),
                            state.obsidian() + state.obsidianBots(),
                            state.oreBots(),
                            state.clayBots() + 1,
                            state.obsidianBots(),
                            state.geodeBots()))
                    : buildNone(blueprint, state);
                case OBSIDIAN_BOT -> blueprint.obsidianBotOreCost() <= state.ore()
                        && blueprint.obsidianBotClayCost() <= state.clay()
                    ? getMaxGeode(
                        blueprint,
                        new State(
                            state.timeLeft() - 1,
                            state.ore() + state.oreBots() - blueprint.obsidianBotOreCost(),
                            state.clay() + state.clayBots() - blueprint.obsidianBotClayCost(),
                            state.obsidian() + state.obsidianBots(),
                            state.oreBots(),
                            state.clayBots(),
                            state.obsidianBots() + 1,
                            state.geodeBots()))
                    : buildNone(blueprint, state);
                case GEODE_BOT -> blueprint.geodeBotOreCost() <= state.ore()
                        && blueprint.geodeBotObsidianCost() <= state.obsidian()
                    ? getMaxGeode(
                        blueprint,
                        new State(
                            state.timeLeft() - 1,
                            state.ore() + state.oreBots() - blueprint.geodeBotOreCost(),
                            state.clay() + state.clayBots(),
                            state.obsidian()
                                + state.obsidianBots()
                                - blueprint.geodeBotObsidianCost(),
                            state.oreBots(),
                            state.clayBots(),
                            state.obsidianBots(),
                            state.geodeBots() + 1))
                    : buildNone(blueprint, state);
              });
    }

    int geodes = maxGeode + state.geodeBots();
    cache.put(state, geodes);

    return geodes;
  }

  private static int buildNone(final Blueprint blueprint, final State state) {
    return getMaxGeode(
        blueprint,
        new State(
            state.timeLeft() - 1,
            state.ore() + state.oreBots(),
            state.clay() + state.clayBots(),
            state.obsidian() + state.obsidianBots(),
            state.oreBots(),
            state.clayBots(),
            state.obsidianBots(),
            state.geodeBots()));
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
      int oreBots,
      int clayBots,
      int obsidianBots,
      int geodeBots) {}
}
