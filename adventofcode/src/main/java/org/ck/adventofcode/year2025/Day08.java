package org.ck.adventofcode.year2025;

import java.util.*;
import java.util.function.ToLongBiFunction;
import java.util.stream.LongStream;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20250801,
    name = "Day 8: Playground",
    url = "https://adventofcode.com/2025/day/8",
    category = "2025")
@Solution(
    id = 20250802,
    name = "Day 8: Playground - Part 2",
    url = "https://adventofcode.com/2025/day/8#part2",
    category = "2025")
public class Day08 extends AOCSolution {

  @Override
  protected void runPartOne(final Scanner in) {
    final int connections = Integer.parseInt(in.nextLine());

    run(
        in,
        connections,
        (networks, _) -> {
          final Queue<Network> sortedNetworks =
              new PriorityQueue<>(Comparator.comparing(Network::size).reversed());
          sortedNetworks.addAll(networks);

          return (long) sortedNetworks.poll().boxes().size()
              * sortedNetworks.poll().boxes().size()
              * sortedNetworks.poll().boxes().size();
        });
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, -1, (_, xCoordinates) -> xCoordinates.reduce(1, (a, b) -> a * b));
  }

  private void run(
      final Scanner in,
      int stopAfter,
      final ToLongBiFunction<Set<Network>, LongStream> resultGetter) {
    final Set<Box> boxes = new HashSet<>();
    final Queue<Distance> distances = new PriorityQueue<>(Comparator.comparing(Distance::distance));

    parseInput(in, boxes, distances);

    final Set<Network> networks = new HashSet<>();
    LongStream xCoordinates = null;
    boolean continueLoop = true;
    while (continueLoop) {
      final Distance distance = distances.poll();
      if (distance == null) {
        throw new IllegalStateException("Distance is null");
      }

      final Set<Network> effectedNetworks = getEffectedNetworks(networks, distance);

      if (effectedNetworks.isEmpty()) {
        networks.add(new Network(distance.boxes()));
      } else {
        final HashSet<Box> merged = new HashSet<>(distance.boxes());

        for (final Network effectedNetwork : effectedNetworks) {
          merged.addAll(effectedNetwork.boxes());
          networks.remove(effectedNetwork);
        }

        final Network newNetwork = new Network(merged);
        networks.add(newNetwork);

        if (newNetwork.size() == boxes.size()) {
          xCoordinates = distance.boxes().stream().mapToLong(Box::x);
          continueLoop = false;
        }
      }

      if (--stopAfter == 0) {
        continueLoop = false;
      }
    }

    print(resultGetter.applyAsLong(networks, xCoordinates));
  }

  private static Set<Network> getEffectedNetworks(
      final Set<Network> networks, final Distance distance) {
    final Set<Network> effectedNetworks = new HashSet<>();

    for (final Network network : networks) {
      for (final Box box : distance.boxes()) {
        if (network.boxes().contains(box)) {
          effectedNetworks.add(network);
        }
      }
    }
    return effectedNetworks;
  }

  private void parseInput(final Scanner in, final Set<Box> boxes, final Queue<Distance> distances) {
    while (in.hasNextLine()) {
      final String[] line = in.nextLine().split(",");
      final Box box =
          new Box(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]));

      for (final Box other : boxes) {
        distances.add(new Distance(Set.of(box, other), getDistance(box, other)));
      }

      boxes.add(box);
    }
  }

  private double getDistance(final Box box, final Box other) {
    final long dx = box.x - other.x;
    final long dy = box.y - other.y;
    final long dz = box.z - other.z;

    return Math.sqrt((double) dx * dx + dy * dy + dz * dz);
  }

  private record Box(long x, long y, long z) {}

  private record Distance(Set<Box> boxes, double distance) {}

  private record Network(Set<Box> boxes) {
    public int size() {
      return boxes.size();
    }
  }
}
