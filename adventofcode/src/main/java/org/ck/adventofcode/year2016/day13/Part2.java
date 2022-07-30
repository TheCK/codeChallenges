package org.ck.adventofcode.year2016.day13;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.*;

@Solution(
    id = 20161302,
    name = "Day 13: A Maze of Twisty Little Cubicles - Part 2",
    url = "https://adventofcode.com/2016/day/13#part2",
    category = "2016")
public class Part2 {
  private static Map<Coordinate, Boolean> cache;

  public static void main(String[] args) {
    cache = new HashMap<>();

    try (Scanner in = new Scanner(System.in)) {
      int favourite = in.nextInt();

      Queue<State> queue = new PriorityQueue<>(Comparator.comparingInt(s -> s.history().size()));
      queue.add(new State(new Coordinate(1, 1), new HashSet<>()));

      Set<Coordinate> visited = new HashSet<>();

      while (!queue.isEmpty()) {
        State state = queue.poll();
        Coordinate coordinate = state.coordinate();

        if (state.history().size() > 50) {
          continue;
        }

        visited.add(coordinate);

        Coordinate up = new Coordinate(coordinate.x(), coordinate.y() - 1);
        if (coordinate.y() > 0 && isFree(up, favourite) && !state.history().contains(up)) {
          HashSet<Coordinate> history = new HashSet<>(state.history());
          history.add(coordinate);

          queue.add(new State(up, history));
        }

        Coordinate down = new Coordinate(coordinate.x(), coordinate.y() + 1);
        if (isFree(down, favourite) && !state.history().contains(down)) {
          HashSet<Coordinate> history = new HashSet<>(state.history());
          history.add(coordinate);

          queue.add(new State(down, history));
        }

        Coordinate left = new Coordinate(coordinate.x() - 1, coordinate.y());
        if (coordinate.x() > 0 && isFree(left, favourite) && !state.history().contains(left)) {
          HashSet<Coordinate> history = new HashSet<>(state.history());
          history.add(coordinate);

          queue.add(new State(left, history));
        }

        Coordinate right = new Coordinate(coordinate.x() + 1, coordinate.y());
        if (isFree(right, favourite) && !state.history().contains(right)) {
          HashSet<Coordinate> history = new HashSet<>(state.history());
          history.add(coordinate);

          queue.add(new State(right, history));
        }
      }

      System.out.println(visited.size());
    }
  }

  private static boolean isFree(Coordinate coordinate, int favourite) {
    cache.computeIfAbsent(
        coordinate,
        k -> {
          int number = k.x() * k.x() + 3 * k.x() + 2 * k.x() * k.y() + k.y() + k.y() * k.y();

          return Integer.bitCount(number + favourite) % 2 == 0;
        });
    return cache.get(coordinate);
  }

  private record Coordinate(int x, int y) {}

  private record State(Coordinate coordinate, Set<Coordinate> history) {}
}
