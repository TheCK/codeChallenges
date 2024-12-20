package org.ck.adventofcode.year2024;

import java.util.*;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20242001,
    name = "Day 20: Race Condition",
    url = "https://adventofcode.com/2024/day/20",
    category = "2024")
@Solution(
    id = 20242002,
    name = "Day 20: Race Condition - Part 2",
    url = "https://adventofcode.com/2024/day/20#part2",
    category = "2024")
public class Day20 extends AOCSolution {

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, 2);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, 20);
  }

  private void run(final Scanner in, final int allowedCheatTime) {
    final int wantedSaveAmount = Integer.parseInt(in.nextLine());

    final List<String> grid = new ArrayList<>();
    Coordinate start = null;
    Coordinate end = null;

    int row = 0;
    while (in.hasNextLine()) {
      final String line = in.nextLine();

      if (line.contains("S")) {
        start = new Coordinate(line.indexOf('S'), row);
      }
      if (line.contains("E")) {
        end = new Coordinate(line.indexOf('E'), row);
      }

      grid.add(line);
      ++row;
    }

    if (start == null || end == null) {
      throw new IllegalArgumentException("Start and end coordinates must be provided");
    }

    final long[][] distances = new long[grid.size()][grid.getFirst().length()];
    for (final long[] distanceRow : distances) {
      Arrays.fill(distanceRow, Long.MAX_VALUE);
    }

    fillFromStartToEnd(distances, grid, start, end);

    fillReachableFromEnd(distances, grid, end);

    final Map<Long, Long> savesPerAmount = getSavesPerAmount(distances, allowedCheatTime);

    long savesOverValue = 0;
    for (final Map.Entry<Long, Long> entry : savesPerAmount.entrySet()) {
      if (entry.getKey() >= wantedSaveAmount) {
        savesOverValue += entry.getValue();
      }
    }

    print(savesOverValue);
  }

  private static void fillFromStartToEnd(
      final long[][] distances,
      final List<String> grid,
      final Coordinate start,
      final Coordinate end) {
    final Queue<State> queue = new PriorityQueue<>(Comparator.comparingLong(State::steps));
    queue.add(new State(start, 0));

    while (!queue.isEmpty()) {
      final State state = queue.poll();
      final Coordinate coordinate = state.coordinate();
      final long steps = state.steps();

      distances[coordinate.y()][coordinate.x()] = steps;

      if (coordinate.equals(end)) {
        break;
      }

      final long nextSteps = steps + 1;
      visitNeighbours(distances, grid, coordinate, nextSteps, queue);
    }
  }

  private static void fillReachableFromEnd(
      final long[][] distances, final List<String> grid, final Coordinate end) {
    final Queue<State> queue = new PriorityQueue<>(Comparator.comparingLong(State::steps));
    queue.add(new State(end, distances[end.y()][end.x()]));

    while (!queue.isEmpty()) {
      final State state = queue.poll();
      final Coordinate coordinate = state.coordinate();
      final long steps = state.steps();

      distances[coordinate.y()][coordinate.x()] = steps;

      final long nextSteps = steps - 1;
      visitNeighbours(distances, grid, coordinate, nextSteps, queue);
    }
  }

  private static void visitNeighbours(
      final long[][] distances,
      final List<String> grid,
      final Coordinate coordinate,
      final long nextSteps,
      final Queue<State> queue) {
    for (final Coordinate next :
        Set.of(
            new Coordinate(coordinate.x() - 1, coordinate.y()),
            new Coordinate(coordinate.x() + 1, coordinate.y()),
            new Coordinate(coordinate.x(), coordinate.y() - 1),
            new Coordinate(coordinate.x(), coordinate.y() + 1))) {
      if (grid.get(next.y).charAt(next.x()) != '#' && distances[next.y()][next.x()] > nextSteps) {
        queue.add(new State(next, nextSteps));
      }
    }
  }

  private static Map<Long, Long> getSavesPerAmount(
      final long[][] distances, final int allowedCheatTime) {
    final Map<Long, Long> savesPerAmount = new HashMap<>();

    for (int y1 = 1; y1 < distances.length - 1; ++y1) {
      for (int x1 = 1; x1 < distances[y1].length - 1; ++x1) {
        final long distance1 = distances[y1][x1];

        if (distance1 < Long.MAX_VALUE) {
          getCheatsPerStart(distances, allowedCheatTime, y1, x1, distance1, savesPerAmount);
        }
      }
    }
    return savesPerAmount;
  }

  private static void getCheatsPerStart(
      final long[][] distances,
      final int allowedCheatTime,
      final int y1,
      final int x1,
      final long distance1,
      final Map<Long, Long> savesPerAmount) {
    for (int y2 = 1; y2 < distances.length - 1; ++y2) {
      for (int x2 = 1; x2 < distances[y1].length - 1; ++x2) {
        final long distance2 = distances[y2][x2];
        final long cheatTime = (long) Math.abs(y1 - y2) + Math.abs(x1 - x2);

        if (distance2 < Long.MAX_VALUE && distance1 < distance2 && cheatTime <= allowedCheatTime) {
          final long saveAmount = distance2 - distance1 - cheatTime;

          if (saveAmount > 0) {
            savesPerAmount.put(
                saveAmount, savesPerAmount.computeIfAbsent(saveAmount, key -> 0L) + 1);
          }
        }
      }
    }
  }

  private record Coordinate(int x, int y) {}

  private record State(Coordinate coordinate, long steps) {}
}
