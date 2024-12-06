package org.ck.adventofcode.year2024;

import java.util.*;
import java.util.stream.Collectors;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20240601,
    name = "Day 6: Guard Gallivant",
    url = "https://adventofcode.com/2024/day/6",
    category = "2024")
@Solution(
    id = 20240602,
    name = "Day 6: Guard Gallivant - Part 2",
    url = "https://adventofcode.com/2024/day/6#part2",
    category = "2024")
public class Day06 extends AOCSolution {

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, (grid, start, visited) -> (long) visited.size());
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        (grid, start, visited) ->
            visited.stream()
                .filter(obstruction -> !start.coordinate().equals(obstruction))
                .filter(obstruction -> getPath(start, getCopy(grid, obstruction)).looped())
                .count());
  }

  private void run(
      final Scanner in,
      final TriFunction<List<String>, Position, Set<Coordinate>, Long> getResult) {
    final List<String> grid = new ArrayList<>();
    Position start = null;

    while (in.hasNextLine()) {
      final String line = in.nextLine();
      final int potentialStart = line.indexOf('^');

      if (potentialStart != -1) {
        start = new Position(new Coordinate(potentialStart, grid.size()), Direction.UP);
      }

      grid.add(line);
    }

    if (start == null) {
      throw new IllegalStateException("No start found");
    }

    final Set<Position> visited = getPath(start, grid).visited();

    print(
        getResult.apply(
            grid, start, visited.stream().map(Position::coordinate).collect(Collectors.toSet())));
  }

  private List<String> getCopy(final List<String> grid, final Coordinate obstruction) {
    final List<String> copy = new ArrayList<>(grid);

    copy.set(
        obstruction.y(),
        "%s#%s"
            .formatted(
                copy.get(obstruction.y()).substring(0, obstruction.x()),
                copy.get(obstruction.y()).substring(obstruction.x() + 1)));

    return copy;
  }

  private static PathResult getPath(final Position start, final List<String> grid) {
    final Set<Position> visited = new HashSet<>();
    Position current = start;

    while (true) {
      if (visited.contains(current)) {
        return new PathResult(visited, true);
      }

      visited.add(current);

      Position next = current.next();

      if (isOutSideOfGrid(grid, next)) {
        break;
      }

      if (grid.get(next.coordinate().y()).charAt(next.coordinate().x()) == '#') {
        next = current.turn();
      }

      current = next;
    }

    return new PathResult(visited, false);
  }

  private static boolean isOutSideOfGrid(final List<String> grid, final Position next) {
    return next.coordinate().x() < 0
        || next.coordinate().y() < 0
        || next.coordinate().x() >= grid.getFirst().length()
        || next.coordinate().y() >= grid.size();
  }

  private record PathResult(Set<Position> visited, boolean looped) {}

  private record Coordinate(int x, int y) {}

  private record Position(Coordinate coordinate, Direction direction) {
    public Position next() {
      return new Position(
          new Coordinate(
              coordinate.x() + direction.getDeltaX(), coordinate.y() + direction.getDeltaY()),
          direction);
    }

    public Position turn() {
      return new Position(coordinate, direction.turn());
    }
  }

  private enum Direction {
    UP(0, -1),
    RIGHT(1, 0),
    DOWN(0, 1),
    LEFT(-1, 0);

    private final int deltaX;
    private final int deltaY;

    Direction(final int deltaX, final int deltaY) {
      this.deltaX = deltaX;
      this.deltaY = deltaY;
    }

    public int getDeltaX() {
      return deltaX;
    }

    public int getDeltaY() {
      return deltaY;
    }

    public Direction turn() {
      return switch (this) {
        case UP -> RIGHT;
        case RIGHT -> DOWN;
        case DOWN -> LEFT;
        case LEFT -> UP;
      };
    }
  }

  private interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
  }
}
