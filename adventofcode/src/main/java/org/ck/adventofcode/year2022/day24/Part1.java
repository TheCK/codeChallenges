package org.ck.adventofcode.year2022.day24;

import org.ck.codechallengelib.annotation.Solution;

import java.util.*;

@Solution(
    id = 20222401,
    name = "Day 24: Blizzard Basin",
    url = "https://adventofcode.com/2022/day/24",
    category = "2022",
    solved = false)
public class Part1 {

  public static void main(String[] args) {
    List<Cyclone> cyclones = new ArrayList<>();
    int width = 0;
    int height = 0;

    try (Scanner in = new Scanner(System.in)) {
      int y = 0;
      while (in.hasNextLine()) {
        char[] line = in.nextLine().toCharArray();
        for (int x = 0; x < line.length; ++x) {
          switch (line[x]) {
            case '^' -> cyclones.add(new Cyclone(x, y, Direction.UP));
            case 'v' -> cyclones.add(new Cyclone(x, y, Direction.DOWN));
            case '<' -> cyclones.add(new Cyclone(x, y, Direction.LEFT));
            case '>' -> cyclones.add(new Cyclone(x, y, Direction.RIGHT));
          }
        }

        width = line.length;
        ++y;
      }

      height = y;
    }

    Queue<State> queue = new PriorityQueue<>(Comparator.comparingInt(State::steps));
    queue.add(new State(1, 0, cyclones, 0));
    while (!queue.isEmpty()) {
      State state = queue.poll();

      boolean onCyclone = false;
      for (Cyclone cyclone : state.cyclones()) {
        if (state.x() == cyclone.x() && state.y() == cyclone.y()) {
          onCyclone = true;
          break;
        }
      }

      if (onCyclone) {
        continue;
      }

      if (state.x() == width - 2 && state.y() == height - 2) {
        System.out.println(state.steps() + 1);
        break;
      }

      int finalWidth = width;
      int finalHeight = height;
      List<Cyclone> movedCyclones =
          state.cyclones().stream().map(cyclone -> move(cyclone, finalWidth, finalHeight)).toList();

      queue.add(new State(state.x(), state.y(), movedCyclones, state.steps() + 1));

      if (state.x() > 1) {
        queue.add(new State(state.x() - 1, state.y(), movedCyclones, state.steps() + 1));
      }

      if (state.x() < width - 3) {
        queue.add(new State(state.x() + 1, state.y(), movedCyclones, state.steps() + 1));
      }

      if (state.y() > 1) {
        queue.add(new State(state.x(), state.y() - 1, movedCyclones, state.steps() + 1));
      }

      if (state.y() < height - 3) {
        queue.add(new State(state.x(), state.y() + 1, movedCyclones, state.steps() + 1));
      }
    }
  }

  private static Cyclone move(final Cyclone cyclone, int width, int height) {
    return switch (cyclone.direction()) {
      case UP -> new Cyclone(
          cyclone.x(), cyclone.y() > 1 ? cyclone.y() - 1 : height - 2, Direction.UP);
      case DOWN -> new Cyclone(
          cyclone.x(), cyclone.y() < height - 3 ? cyclone.y() + 1 : 1, Direction.DOWN);
      case LEFT -> new Cyclone(
          cyclone.x() > 1 ? cyclone.x() - 1 : width - 2, cyclone.y(), Direction.LEFT);
      case RIGHT -> new Cyclone(
          cyclone.x() < width - 2 ? cyclone.x() + 1 : 0, cyclone.y(), Direction.RIGHT);
    };
  }

  record State(int x, int y, List<Cyclone> cyclones, int steps) {}

  record Cyclone(int x, int y, Direction direction) {}

  private enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;
  }
}
