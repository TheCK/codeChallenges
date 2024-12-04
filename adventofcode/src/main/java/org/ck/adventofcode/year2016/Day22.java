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
    category = "2016",
    solved = false)
public class Day22 extends AOCSolution {
  private static final Pattern PATTERN =
      Pattern.compile(
          "/dev/grid/node-x(?<x>\\d+)-y(?<y>\\d+) +(?<size>\\d+)T +(?<used>\\d+)T +(?<avail>\\d+)T +\\d+%");

  @Override
  protected void runPartOne(final Scanner in) {
    in.nextLine();
    in.nextLine();

    List<Node> nodes = new ArrayList<>();
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
        if (nodes.get(i).used() > 0 && nodes.get(i).used() <= nodes.get(j).free()) {
          ++viablePairs;
        }
        if (nodes.get(j).used() > 0 && nodes.get(j).used() <= nodes.get(i).free()) {
          ++viablePairs;
        }
      }
    }

    print(viablePairs);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in);
  }

  private void run(final Scanner in) {
    in.nextLine();
    in.nextLine();

    final List<InputNode> nodes = new ArrayList<>();

    Coordinates empty = null;
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
          empty = coordinates;
        }

        nodes.add(new InputNode(coordinates, used, Integer.parseInt(matcher.group("avail"))));
      }
    }

    Node[][] grid = new Node[maxX + 1][maxY + 1];
    nodes.forEach(
        node ->
            grid[node.coordinates().x()][node.coordinates().y()] =
                new Node(node.used(), node.free()));

    Queue<State> states = new PriorityQueue<>(Comparator.comparingInt(State::steps));
    states.add(new State(grid, empty, new Coordinates(maxX, 0), 0));

    while (!states.isEmpty()) {
      final State state = states.poll();

      if (state.goalPosition().x() == 0 && state.goalPosition().y() == 0) {
        print(state.steps());
        return;
      }

      int emptySpace = grid[empty.x()][empty.y()].used();
      if (empty.x() > 0 && grid[empty.x() - 1][empty.y()].used() <= emptySpace) {
        final Node[][] copy = Arrays.stream(grid).map(Node[]::clone).toArray(Node[][]::new);

        states.add(
            new State(copy, empty, new Coordinates(empty.x(), empty.y()), state.steps() + 1));
      }
    }
  }

  private record State(
      Node[][] grid, Coordinates emptyPosition, Coordinates goalPosition, int steps) {}

  private record Coordinates(int x, int y) {}

  private record InputNode(Coordinates coordinates, int used, int free) {}

  private record Node(int used, int free) {}
}
