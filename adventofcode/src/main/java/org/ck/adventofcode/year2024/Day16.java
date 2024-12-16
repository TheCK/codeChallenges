package org.ck.adventofcode.year2024;

import java.util.*;
import java.util.function.ToLongBiFunction;
import java.util.stream.Collectors;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20241601,
    name = "Day 16: Reindeer Maze",
    url = "https://adventofcode.com/2024/day/16",
    category = "2024")
@Solution(
    id = 20241602,
    name = "Day 16: Reindeer Maze - Part 2",
    url = "https://adventofcode.com/2024/day/16#part2",
    category = "2024")
public class Day16 extends AOCSolution {

  @Override
  protected void runPartOne(final Scanner in) {
    run(
        in,
        (cache, end) ->
            getMinPoints(cache[end.y()][end.x()]).stream().findFirst().orElseThrow().points());
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, this::getUniquePathElements);
  }

  private void run(
      final Scanner in, final ToLongBiFunction<CacheValue[][][], Coordinate> getResult) {
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
      throw new IllegalStateException();
    }

    final CacheValue[][][] cache = getCacheValues(grid, start);

    print(getResult.applyAsLong(cache, end));
  }

  private static CacheValue[][][] getCacheValues(final List<String> grid, final Coordinate start) {
    final Queue<State> queue = new PriorityQueue<>(Comparator.comparingLong(State::points));
    queue.add(new State(new Position(start, Direction.EAST), null, 0));

    final CacheValue[][][] cache = new CacheValue[grid.size()][grid.getFirst().length()][4];
    for (int y = 0; y < cache.length; ++y) {
      for (int x = 0; x < cache.length; ++x) {
        for (int direction = 0; direction < 4; ++direction) {
          cache[y][x][direction] = new CacheValue(Long.MAX_VALUE, new HashSet<>());
        }
      }
    }

    while (!queue.isEmpty()) {
      final State state = queue.poll();
      final Position current = state.current();
      final Coordinate coordinate = current.coordinate();
      final Direction direction = current.direction();
      final long points = state.points();

      if (cache[coordinate.y()][coordinate.x()][direction.ordinal()].points() < points) {
        continue;
      }
      cache[coordinate.y()][coordinate.x()][direction.ordinal()] =
          new CacheValue(points, cache[coordinate.y()][coordinate.x()][direction.ordinal()].from());
      if (state.last() != null) {
        cache[coordinate.y()][coordinate.x()][direction.ordinal()].from().add(state.last());
      }

      final Position next = direction.next(current);
      if (grid.get(next.coordinate().y()).charAt(next.coordinate().x()) != '#') {
        queue.add(new State(next, current, points + 1));
      }

      queue.add(new State(direction.turnCW(current), current, points + 1000));
      queue.add(new State(direction.turnCCW(current), current, points + 1000));
    }
    return cache;
  }

  private Set<CacheValue> getMinPoints(final CacheValue[] cache) {
    final long min =
        Math.min(
            Math.min(cache[0].points(), cache[1].points()),
            Math.min(cache[2].points(), cache[3].points()));

    return Arrays.stream(cache).filter(entry -> entry.points() == min).collect(Collectors.toSet());
  }

  private int getUniquePathElements(final CacheValue[][][] cache, final Coordinate end) {
    final Queue<Position> queue =
        getMinPoints(cache[end.y()][end.x()]).stream()
            .map(CacheValue::from)
            .flatMap(Set::stream)
            .distinct()
            .collect(Collectors.toCollection(LinkedList::new));
    final Set<Coordinate> pathPieces = new HashSet<>();

    while (!queue.isEmpty()) {
      final Position position = queue.poll();

      pathPieces.add(position.coordinate());

      queue.addAll(
          cache[position.coordinate().y()][position.coordinate().x()][
              position.direction().ordinal()]
              .from());
    }

    return pathPieces.size() + 1;
  }

  private record CacheValue(long points, Set<Position> from) {}

  private record State(Position current, Position last, long points) {}

  private record Position(Coordinate coordinate, Direction direction) {}

  private record Coordinate(int x, int y) {}

  private enum Direction {
    NORTH(0, -1),
    EAST(1, 0),
    SOUTH(0, 1),
    WEST(-1, 0);

    private final int deltaX;
    private final int deltaY;

    Direction(int deltaX, int deltaY) {
      this.deltaX = deltaX;
      this.deltaY = deltaY;
    }

    public Position turnCW(final Position current) {
      return new Position(
          current.coordinate(),
          switch (this) {
            case NORTH -> Direction.EAST;
            case EAST -> Direction.SOUTH;
            case SOUTH -> Direction.WEST;
            case WEST -> Direction.NORTH;
          });
    }

    public Position turnCCW(final Position current) {
      return new Position(
          current.coordinate(),
          switch (this) {
            case NORTH -> Direction.WEST;
            case EAST -> Direction.NORTH;
            case SOUTH -> Direction.EAST;
            case WEST -> Direction.SOUTH;
          });
    }

    public Position next(Position current) {
      return new Position(
          new Coordinate(current.coordinate().x() + deltaX, current.coordinate().y() + deltaY),
          current.direction());
    }
  }
}
