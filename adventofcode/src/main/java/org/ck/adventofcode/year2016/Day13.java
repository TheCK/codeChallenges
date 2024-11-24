package org.ck.adventofcode.year2016;

import java.util.*;
import java.util.function.Predicate;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20161301,
    name = "Day 13: A Maze of Twisty Little Cubicles",
    url = "https://adventofcode.com/2016/day/13",
    category = "2016")
@Solution(
    id = 20161302,
    name = "Day 13: A Maze of Twisty Little Cubicles - Part 2",
    url = "https://adventofcode.com/2016/day/13#part2",
    category = "2016")
public class Day13 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    final int favourite = in.nextInt();
    final int x = in.nextInt();
    final int y = in.nextInt();

    run(favourite, state -> false, coordinate -> coordinate.x() == x && coordinate.y() == y, false);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    final int favourite = in.nextInt();

    run(favourite, state -> state.history().size() > 50, coordinate -> false, true);
  }

  private void run(
      final int favourite,
      final Predicate<State> shouldSkip,
      final Predicate<Coordinate> shouldBreak,
      final boolean printVisited) {
    final Map<Coordinate, Boolean> cache = new HashMap<>();

    final Queue<State> queue =
        new PriorityQueue<>(Comparator.comparingInt(s -> s.history().size()));
    queue.add(new State(new Coordinate(1, 1), new HashSet<>()));

    final Set<Coordinate> visited = new HashSet<>();

    while (!queue.isEmpty()) {
      final State state = queue.poll();
      final Coordinate coordinate = state.coordinate();

      if (shouldSkip.test(state)) {
        continue;
      }

      if (shouldBreak.test(coordinate)) {
        print(state.history.size());
        break;
      }

      visited.add(coordinate);

      final Coordinate up = new Coordinate(coordinate.x(), coordinate.y() - 1);
      if (coordinate.y() > 0) {
        move(cache, up, favourite, state, coordinate, queue);
      }

      final Coordinate down = new Coordinate(coordinate.x(), coordinate.y() + 1);
      move(cache, down, favourite, state, coordinate, queue);

      final Coordinate left = new Coordinate(coordinate.x() - 1, coordinate.y());
      if (coordinate.x() > 0) {
        move(cache, left, favourite, state, coordinate, queue);
      }

      final Coordinate right = new Coordinate(coordinate.x() + 1, coordinate.y());
      move(cache, right, favourite, state, coordinate, queue);
    }

    if (printVisited) {
      print(visited.size());
    }
  }

  private static void move(
      final Map<Coordinate, Boolean> cache,
      final Coordinate newCoordinate,
      final int favourite,
      final State state,
      final Coordinate coordinate,
      final Queue<State> queue) {
    if (isFree(cache, newCoordinate, favourite) && !state.history().contains(newCoordinate)) {
      final HashSet<Coordinate> history = new HashSet<>(state.history());
      history.add(coordinate);

      queue.add(new State(newCoordinate, history));
    }
  }

  private static boolean isFree(
      final Map<Coordinate, Boolean> cache, final Coordinate coordinate, final int favourite) {
    cache.computeIfAbsent(
        coordinate,
        k -> {
          final int number = k.x() * k.x() + 3 * k.x() + 2 * k.x() * k.y() + k.y() + k.y() * k.y();

          return Integer.bitCount(number + favourite) % 2 == 0;
        });
    return cache.get(coordinate);
  }

  private record Coordinate(int x, int y) {}

  private record State(Coordinate coordinate, Set<Coordinate> history) {}
}
