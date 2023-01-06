package org.ck.adventofcode.year2022.day24;

import java.util.*;
import java.util.stream.Collectors;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20222402,
    name = "Day 24: Blizzard Basin - Part 2",
    url = "https://adventofcode.com/2022/day/24#part2",
    category = "2022")
public class Part2 {
  public static void main(String[] args) {
    Set<CycleState> previouslyVisited = new HashSet<>();

    Set<Cyclone> cyclones = new HashSet<>();
    Set<Point> walls = new HashSet<>();
    int width = 0;
    int height;

    try (Scanner in = new Scanner(System.in)) {
      int y = 0;
      while (in.hasNextLine()) {
        char[] line = in.nextLine().toCharArray();
        for (int x = 0; x < line.length; ++x) {
          switch (line[x]) {
            case '^' -> cyclones.add(new Cyclone(new Point(x, y), Direction.UP));
            case 'v' -> cyclones.add(new Cyclone(new Point(x, y), Direction.DOWN));
            case '<' -> cyclones.add(new Cyclone(new Point(x, y), Direction.LEFT));
            case '>' -> cyclones.add(new Cyclone(new Point(x, y), Direction.RIGHT));
            case '#' -> walls.add(new Point(x, y));
            default -> throw new IllegalStateException("Unexpected value: " + line[x]);
          }
        }

        width = line.length;
        ++y;
      }

      height = y;
    }

    int finalWidth = width;
    int finalHeight = height;

    int loopLength = lcm((width - 2), (height - 2));
    Map<Integer, Set<Point>> possiblePatterns =
        getPossiblePatterns(cyclones, loopLength, finalWidth, finalHeight);

    Point start = new Point(1, 0);
    Point end = new Point(width - 2, height - 1);

    Queue<State> queue = new PriorityQueue<>(Comparator.comparingInt(State::steps));
    queue.add(new State(start, 0, false, false));
    while (!queue.isEmpty()) {
      State state = queue.poll();
      CycleState cacheCheck = CycleState.of(state, loopLength);

      if (previouslyVisited.contains(cacheCheck)) {
        continue;
      }
      previouslyVisited.add(cacheCheck);

      if (possiblePatterns.get(state.steps() % loopLength).contains(state.point())) {
        continue;
      }

      if (walls.contains(state.point())) {
        continue;
      }

      if (state.point().equals(end) && !state.beenAtEnd()) {
        queue.clear();
        previouslyVisited.clear();
        state = new State(state.point(), state.steps(), true, false);
      }

      if (state.point().equals(start) && state.beenAtEnd() && !state.beenAtStart()) {
        queue.clear();
        previouslyVisited.clear();
        state = new State(state.point(), state.steps(), true, true);
      }

      if (state.point().equals(end) && state.beenAtEnd() && state.beenAtStart()) {
        System.out.println(state.steps());
        break;
      }

      queue.add(
          new State(state.point(), state.steps() + 1, state.beenAtEnd(), state.beenAtStart()));

      if (state.point().x() > 0) {
        queue.add(
            new State(
                new Point(state.point().x() - 1, state.point().y()),
                state.steps() + 1,
                state.beenAtEnd(),
                state.beenAtStart()));
      }

      if (state.point().x() < width - 1) {
        queue.add(
            new State(
                new Point(state.point().x() + 1, state.point().y()),
                state.steps() + 1,
                state.beenAtEnd(),
                state.beenAtStart()));
      }

      if (state.point().y() > 0) {
        queue.add(
            new State(
                new Point(state.point().x(), state.point().y() - 1),
                state.steps() + 1,
                state.beenAtEnd(),
                state.beenAtStart()));
      }

      if (state.point().y() < height - 1) {
        queue.add(
            new State(
                new Point(state.point().x(), state.point().y() + 1),
                state.steps() + 1,
                state.beenAtEnd(),
                state.beenAtStart()));
      }
    }
  }

  private static int lcm(final int one, final int two) {
    int lower = Math.min(one, two);
    int upper = Math.max(one, two);

    int lowerMultiple = lower;
    int upperMultiple = upper;

    while (lowerMultiple != upperMultiple) {
      if (lowerMultiple < upperMultiple) {
        lowerMultiple += lower;
      } else {
        upperMultiple += upper;
      }
    }

    return lowerMultiple;
  }

  private static Map<Integer, Set<Point>> getPossiblePatterns(
      final Set<Cyclone> cyclones, final int loopLength, final int width, final int height) {
    Map<Integer, Set<Point>> possiblePatterns = new HashMap<>();

    Set<Cyclone> state = new HashSet<>(cyclones);
    for (int i = 0; i < loopLength; ++i) {
      possiblePatterns.put(i, state.stream().map(Cyclone::point).collect(Collectors.toSet()));

      state =
          state.stream().map(cyclone -> move(cyclone, width, height)).collect(Collectors.toSet());
    }

    return possiblePatterns;
  }

  private static Cyclone move(final Cyclone cyclone, int width, int height) {
    return switch (cyclone.direction()) {
      case UP -> new Cyclone(
          new Point(
              cyclone.point().x(), cyclone.point().y() > 1 ? cyclone.point().y() - 1 : height - 2),
          Direction.UP);
      case DOWN -> new Cyclone(
          new Point(
              cyclone.point().x(), cyclone.point().y() < height - 2 ? cyclone.point().y() + 1 : 1),
          Direction.DOWN);
      case LEFT -> new Cyclone(
          new Point(
              cyclone.point().x() > 1 ? cyclone.point().x() - 1 : width - 2, cyclone.point().y()),
          Direction.LEFT);
      case RIGHT -> new Cyclone(
          new Point(
              cyclone.point().x() < width - 2 ? cyclone.point().x() + 1 : 1, cyclone.point().y()),
          Direction.RIGHT);
    };
  }

  record CycleState(Point point, int cycle) {
    static CycleState of(State state, int cycleLength) {
      return new CycleState(state.point(), state.steps() % cycleLength);
    }
  }

  record Point(int x, int y) {}

  record State(Point point, int steps, boolean beenAtEnd, boolean beenAtStart) {}

  record Cyclone(Point point, Direction direction) {}

  private enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
  }
}
