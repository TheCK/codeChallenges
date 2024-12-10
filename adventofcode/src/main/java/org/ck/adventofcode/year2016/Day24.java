package org.ck.adventofcode.year2016;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20162401,
    name = "Day 24: Air Duct Spelunking",
    url = "https://adventofcode.com/2016/day/24",
    category = "2016")
@Solution(
    id = 20162402,
    name = "Day 24: Air Duct Spelunking - Part 2",
    url = "https://adventofcode.com/2016/day/24",
    category = "2016")
public class Day24 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, (lastStep, distances) -> 0);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, (lastStep, distances) -> distances.get('0').get(lastStep));
  }

  private void run(
      final Scanner in,
      final BiFunction<Character, Map<Character, Map<Character, Integer>>, Integer>
          lastStepLength) {
    final List<char[]> grid = new ArrayList<>();

    while (in.hasNextLine()) {
      grid.add(in.nextLine().toCharArray());
    }

    final List<Target> wanted = new ArrayList<>();
    for (int y = 0; y < grid.size(); ++y) {
      for (int x = 0; x < grid.get(y).length; ++x) {
        final char field = grid.get(y)[x];

        if (field != '.' && field != '#') {
          wanted.add(new Target(field, new Coordinate(x, y)));
        }
      }
    }

    final Map<Character, Map<Character, Integer>> distances = new HashMap<>();
    for (int i = 0; i < wanted.size(); ++i) {
      for (int j = i + 1; j < wanted.size(); ++j) {
        final int steps =
            findPathLength(grid, wanted.get(i).coordinate(), wanted.get(j).coordinate());

        distances
            .computeIfAbsent(wanted.get(i).name(), k -> new HashMap<>())
            .computeIfAbsent(wanted.get(j).name(), k -> steps);
        distances
            .computeIfAbsent(wanted.get(j).name(), k -> new HashMap<>())
            .computeIfAbsent(wanted.get(i).name(), k -> steps);
      }
    }

    print(
        getOverallDistance(
            wanted.stream()
                .map(Target::name)
                .filter(target -> target != '0')
                .collect(Collectors.toSet()),
            distances,
            '0',
            lastStepLength));
  }

  private int getOverallDistance(
      final Set<Character> remaining,
      final Map<Character, Map<Character, Integer>> distances,
      final char current,
      final BiFunction<Character, Map<Character, Map<Character, Integer>>, Integer>
          lastStepLength) {
    if (remaining.isEmpty()) {
      return lastStepLength.apply(current, distances);
    }

    int distance = Integer.MAX_VALUE;

    for (final char next : remaining) {
      distance =
          Math.min(
              distance,
              getOverallDistance(
                      remaining.stream()
                          .filter(target -> target != next)
                          .collect(Collectors.toSet()),
                      distances,
                      next,
                      lastStepLength)
                  + distances.get(current).get(next));
    }

    return distance;
  }

  private static int findPathLength(
      final List<char[]> grid, final Coordinate start, final Coordinate end) {
    final Queue<State> queue = new PriorityQueue<>(Comparator.comparingInt(State::steps));
    queue.add(new State(start, 0));

    final Set<Coordinate> lookAheadCache = new HashSet<>();

    while (!queue.isEmpty()) {
      final State state = queue.poll();
      final Coordinate coordinate = state.coordinate();

      if (coordinate.equals(end)) {
        return state.steps();
      }

      for (final Coordinate next :
          List.of(
              new Coordinate(coordinate.x(), coordinate.y() - 1),
              new Coordinate(coordinate.x(), coordinate.y() + 1),
              new Coordinate(coordinate.x() - 1, coordinate.y()),
              new Coordinate(coordinate.x() + 1, coordinate.y()))) {
        if (grid.get(next.y())[next.x()] != '#' && !lookAheadCache.contains(next)) {
          lookAheadCache.add(next);
          queue.add(new State(next, state.steps() + 1));
        }
      }
    }

    return Integer.MAX_VALUE;
  }

  private record Target(char name, Coordinate coordinate) {}

  private record Coordinate(int x, int y) {}

  private record State(Coordinate coordinate, int steps) {}
}
