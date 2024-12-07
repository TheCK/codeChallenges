package org.ck.adventofcode.year2016;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20162201,
    name = "Day 22: Grid Computing",
    url = "https://adventofcode.com/2016/day/22",
    category = "2016")
@Solution(
    id = 20162202,
    name = "Day 22: Grid Computing - Part 2",
    url = "https://adventofcode.com/2016/day/22",
    category = "2016")
public class Day22 extends AOCSolution {
  private static final Pattern PATTERN =
      Pattern.compile(
          "/dev/grid/node-x(?<x>\\d+)-y(?<y>\\d+) +(?<size>\\d+)T +(?<used>\\d+)T +(?<avail>\\d+)T +\\d+%");

  @Override
  protected void runPartOne(final Scanner in) {
    in.nextLine();
    in.nextLine();

    final List<Node> nodes = new ArrayList<>();
    while (in.hasNextLine()) {
      final Matcher matcher = PATTERN.matcher(in.nextLine());

      if (matcher.find()) {
        nodes.add(
            new Node(
                Integer.parseInt(matcher.group("used")), Integer.parseInt(matcher.group("avail"))));
      }
    }

    int viablePairs = 0;

    for (int i = 0; i < nodes.size(); ++i) {
      for (int j = i + 1; j < nodes.size(); ++j) {
        if (nodes.get(i).used() > 0 && nodes.get(i).used() <= nodes.get(j).capacity()) {
          ++viablePairs;
        }
        if (nodes.get(j).used() > 0 && nodes.get(j).used() <= nodes.get(i).capacity()) {
          ++viablePairs;
        }
      }
    }

    print(viablePairs);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    in.nextLine();
    in.nextLine();

    final List<InputNode> nodes = new ArrayList<>();

    Coordinates initialEmpty = null;
    int maxX = 0;
    int maxY = 0;

    while (in.hasNextLine()) {
      final Matcher matcher = PATTERN.matcher(in.nextLine());

      if (matcher.find()) {
        final Coordinates coordinates =
            new Coordinates(
                Integer.parseInt(matcher.group("x")), Integer.parseInt(matcher.group("y")));

        final int used = Integer.parseInt(matcher.group("used"));

        maxX = Math.max(maxX, coordinates.x());
        maxY = Math.max(maxY, coordinates.y());

        if (used == 0) {
          initialEmpty = coordinates;
        }

        nodes.add(
            new InputNode(
                coordinates,
                used,
                Integer.parseInt(matcher.group("used"))
                    + Integer.parseInt(matcher.group("avail"))));
      }
    }

    final Node[][] initialGrid = new Node[maxX + 1][maxY + 1];
    nodes.forEach(
        node ->
            initialGrid[node.coordinates().x()][node.coordinates().y()] =
                new Node(node.used(), node.capacity()));

    final Queue<State> states = new PriorityQueue<>(Comparator.comparingInt(Day22::heuristic));
    states.add(new State(initialEmpty, new Coordinates(maxX, 0), 0));

    final Set<State> visited = new HashSet<>();

    while (!states.isEmpty()) {
      final State state = states.poll();

      if (visited.contains(state)) {
        continue;
      }

      visited.add(state);

      final Coordinates empty = state.emptyPosition();
      final Coordinates goal = state.goalPosition();

      if (goal.x() == 0 && goal.y() == 0) {
        print(state.steps());
        return;
      }

      for (final Coordinates newEmpty : getNewCoordinates(empty)) {
        if (isInbounds(newEmpty, maxX, maxY)
            && initialGrid[newEmpty.x()][newEmpty.y()].used()
                <= initialGrid[empty.x()][empty.y()].capacity()) {
          states.add(new State(newEmpty, newEmpty.equals(goal) ? empty : goal, state.steps() + 1));
        }
      }
    }
  }

  private static int heuristic(final State state) {
    return state.steps()
        + state.goalPosition().x()
        + state.goalPosition().y()
        + Math.abs(state.goalPosition().x() - state.emptyPosition().x())
        + Math.abs(state.goalPosition().y() - state.emptyPosition().y());
  }

  private static boolean isInbounds(final Coordinates newEmpty, final int maxX, final int maxY) {
    return newEmpty.x() >= 0 && newEmpty.y() >= 0 && newEmpty.x() <= maxX && newEmpty.y() <= maxY;
  }

  private static List<Coordinates> getNewCoordinates(final Coordinates empty) {
    return List.of(
        new Coordinates(empty.x() - 1, empty.y()),
        new Coordinates(empty.x() + 1, empty.y()),
        new Coordinates(empty.x(), empty.y() - 1),
        new Coordinates(empty.x(), empty.y() + 1));
  }

  private record State(Coordinates emptyPosition, Coordinates goalPosition, int steps) {
    @Override
    public boolean equals(final Object o) {
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      final State state = (State) o;
      return Objects.equals(goalPosition, state.goalPosition)
          && Objects.equals(emptyPosition, state.emptyPosition);
    }

    @Override
    public int hashCode() {
      return Objects.hash(emptyPosition, goalPosition);
    }
  }

  private record Coordinates(int x, int y) {}

  private record InputNode(Coordinates coordinates, int used, int capacity) {}

  private record Node(int used, int capacity) {}
}
