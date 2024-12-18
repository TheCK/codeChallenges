package org.ck.adventofcode.year2024;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20241801,
    name = "Day 18: RAM Run",
    url = "https://adventofcode.com/2024/day/18",
    category = "2024")
@Solution(
    id = 20241802,
    name = "Day 18: RAM Run - Part 2",
    url = "https://adventofcode.com/2024/day/18#part2",
    category = "2024")
public class Day18 extends AOCSolution {

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, false, foundPath -> !foundPath);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, true, foundPath -> foundPath);
  }

  private void run(
      final Scanner in, final boolean initialFoundPath, final Predicate<Boolean> shouldRun) {
    final int gridSize = in.nextInt();
    int offset = in.nextInt() - 1;
    in.nextLine();

    final List<Coordinate> packets = new ArrayList<>();
    while (in.hasNextLine()) {
      final String[] line = in.nextLine().split(",");

      packets.add(new Coordinate(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
    }

    final Set<Coordinate> corrupted = packets.stream().limit(offset).collect(Collectors.toSet());
    final Set<Coordinate> previousPath = new HashSet<>();

    boolean foundPath = initialFoundPath;

    while (shouldRun.test(foundPath)) {
      foundPath = false;
      corrupted.add(packets.get(offset));

      if (!previousPath.isEmpty() && !previousPath.contains(packets.get(offset))) {
        foundPath = true;
        ++offset;
        continue;
      }

      final Map<Coordinate, Coordinate> origins = new HashMap<>();
      origins.put(new Coordinate(0, 0), null);

      final Queue<State> queue = new PriorityQueue<>(Comparator.comparingInt(State::count));
      queue.add(new State(new Coordinate(0, 0), 0));

      while (!queue.isEmpty()) {
        final State current = queue.poll();
        final Coordinate coordinate = current.current();

        if (coordinate.x() == gridSize && coordinate.y() == gridSize) {
          foundPath = true;
          if (!initialFoundPath) {
            print(current.count());
          }
          break;
        }

        for (final Coordinate next :
            Set.of(
                new Coordinate(coordinate.x() + 1, coordinate.y()),
                new Coordinate(coordinate.x(), coordinate.y() + 1),
                new Coordinate(coordinate.x() - 1, coordinate.y()),
                new Coordinate(coordinate.x(), coordinate.y() - 1))) {
          if (next.x() >= 0 && next.y() >= 0 && next.x() <= gridSize && next.y() <= gridSize) {
            if (!origins.containsKey(next) && !corrupted.contains(next)) {
              origins.put(next, coordinate);
              queue.add(new State(next, current.count() + 1));
            }
          }
        }
      }

      Coordinate current = new Coordinate(gridSize, gridSize);
      while (current != null) {
        previousPath.add(current);
        current = origins.get(current);
      }

      if (!foundPath && initialFoundPath) {
        final Coordinate last = packets.get(offset);
        print("%d,%d".formatted(last.x(), last.y()));
      }

      ++offset;
    }
  }

  private record State(Coordinate current, int count) {}

  private record Coordinate(int x, int y) {}
}
