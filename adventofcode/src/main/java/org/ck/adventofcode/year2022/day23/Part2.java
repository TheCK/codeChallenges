package org.ck.adventofcode.year2022.day23;

import java.util.*;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20222302,
    name = "Day 23: Unstable Diffusion - Part 2",
    url = "https://adventofcode.com/2022/day/23#part2",
    category = "2022")
public class Part2 {
  public static void main(String[] args) {
    Set<Point> elves = new HashSet<>();
    try (Scanner in = new Scanner(System.in)) {
      int y = 0;
      while (in.hasNextLine()) {
        String line = in.nextLine();

        for (int x = 0; x < line.length(); ++x) {
          if (line.charAt(x) == '#') {
            elves.add(new Point(x, y));
          }
        }
        ++y;
      }
    }

    Queue<Direction> directions =
        new ArrayDeque<>(List.of(Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST));

    boolean moved = true;
    int i = 0;
    while (moved) {
      ++i;
      moved = false;
      Map<Point, List<Point>> proposals = new HashMap<>();
      for (Point elf : elves) {
        Set<Point> neighbours = getNeigbours(elf);
        neighbours.retainAll(elves);

        if (!neighbours.isEmpty()) {
          Point newPosition = elf;
          for (Direction direction : directions) {
            Set<Point> directionalNeighbours = direction.getToCheck(elf);
            directionalNeighbours.retainAll(elves);

            if (directionalNeighbours.isEmpty()) {
              newPosition = direction.move(elf);
              moved = true;
              break;
            }
          }

          proposals.computeIfAbsent(newPosition, x -> new ArrayList<>());
          proposals.get(newPosition).add(elf);
        } else {
          proposals.computeIfAbsent(elf, x -> new ArrayList<>());
          proposals.get(elf).add(elf);
        }
      }

      elves = new HashSet<>();
      for (Map.Entry<Point, List<Point>> proposal : proposals.entrySet()) {
        if (proposal.getValue().size() == 1) {
          elves.add(proposal.getKey());
        } else {
          elves.addAll(proposal.getValue());
        }
      }

      directions.add(directions.poll());
    }

    System.out.println(i);
  }

  private static Set<Point> getNeigbours(final Point elf) {
    return new HashSet<>(
        Set.of(
            new Point(elf.x() - 1, elf.y() - 1),
            new Point(elf.x(), elf.y() - 1),
            new Point(elf.x() + 1, elf.y() - 1),
            new Point(elf.x() - 1, elf.y()),
            new Point(elf.x() + 1, elf.y()),
            new Point(elf.x() - 1, elf.y() + 1),
            new Point(elf.x(), elf.y() + 1),
            new Point(elf.x() + 1, elf.y() + 1)));
  }

  private record Point(int x, int y) {}

  private enum Direction {
    NORTH(
        elf ->
            new HashSet<>(
                Set.of(
                    new Point(elf.x() - 1, elf.y() - 1),
                    new Point(elf.x(), elf.y() - 1),
                    new Point(elf.x() + 1, elf.y() - 1))),
        elf -> new Point(elf.x(), elf.y() - 1)),
    SOUTH(
        elf ->
            new HashSet<>(
                Set.of(
                    new Point(elf.x() - 1, elf.y() + 1),
                    new Point(elf.x(), elf.y() + 1),
                    new Point(elf.x() + 1, elf.y() + 1))),
        elf -> new Point(elf.x(), elf.y() + 1)),
    WEST(
        elf ->
            new HashSet<>(
                Set.of(
                    new Point(elf.x() - 1, elf.y() - 1),
                    new Point(elf.x() - 1, elf.y()),
                    new Point(elf.x() - 1, elf.y() + 1))),
        elf -> new Point(elf.x() - 1, elf.y())),
    EAST(
        elf ->
            new HashSet<>(
                Set.of(
                    new Point(elf.x() + 1, elf.y() - 1),
                    new Point(elf.x() + 1, elf.y()),
                    new Point(elf.x() + 1, elf.y() + 1))),
        elf -> new Point(elf.x() + 1, elf.y()));

    private final Function<Point, Set<Point>> toCheck;
    private final UnaryOperator<Point> move;

    Direction(Function<Point, Set<Point>> toCheck, UnaryOperator<Point> move) {
      this.toCheck = toCheck;
      this.move = move;
    }

    public Set<Point> getToCheck(Point elf) {
      return toCheck.apply(elf);
    }

    public Point move(Point elf) {
      return this.move.apply(elf);
    }
  }
}
