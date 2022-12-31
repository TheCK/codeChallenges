package org.ck.adventofcode.year2021.day19;

import org.ck.codechallengelib.annotation.Solution;

import java.util.*;
import java.util.function.UnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Solution(
    id = 20211902,
    name = "Day 19: Beacon Scanner - Part 2",
    url = "https://adventofcode.com/2021/day/19#part2",
    category = "2021")
public class Part2 {
  private static final Pattern scannerPattern = Pattern.compile("--- scanner (\\d+) ---");

  private static final List<UnaryOperator<Position>> rotators = List.of(
          position -> new Position(position.x(), position.y(), position.z()),
          position -> new Position(position.y(), -position.x(), position.z()),
          position -> new Position(-position.x(), -position.y(), position.z()),
          position -> new Position(-position.y(), position.x(), position.z()),

          position -> new Position(position.y(), position.z(), position.x()),
          position -> new Position(-position.x(), position.z(), position.y()),
          position -> new Position(-position.y(), position.z(), -position.x()),
          position -> new Position(position.x(), position.z(), -position.y()),

          position -> new Position(position.z(), position.x(), position.y()),
          position -> new Position(position.z(), position.y(), -position.x()),
          position -> new Position(position.z(), -position.x(), -position.y()),
          position -> new Position(position.z(), -position.y(), position.x()),

          position -> new Position(position.y(), position.x(), -position.z()),
          position -> new Position(-position.x(), position.y(), -position.z()),
          position -> new Position(-position.y(), -position.x(), -position.z()),
          position -> new Position(position.x(), -position.y(), -position.z()),

          position -> new Position(position.x(), -position.z(), position.y()),
          position -> new Position(position.y(), -position.z(), -position.x()),
          position -> new Position(-position.x(), -position.z(), -position.y()),
          position -> new Position(-position.y(), -position.z(), position.x()),

          position -> new Position(-position.z(), position.y(), position.x()),
          position -> new Position(-position.z(), -position.x(), position.y()),
          position -> new Position(-position.z(), -position.y(), -position.x()),
          position -> new Position(-position.z(), position.x(), -position.y())
  );

  public static void main(String[] args) {
    Set<Sensor> sensors = new HashSet<>();

    try (Scanner in = new Scanner(System.in)) {
      int sensorName = 0;
      Set<Position> beacons = new HashSet<>();

      while (in.hasNextLine()) {
        String line = in.nextLine();

        final Matcher matcher = scannerPattern.matcher(line);
        if (matcher.find()) {
          sensorName = Integer.parseInt(matcher.group(1));
          beacons = new HashSet<>();
        } else if (!line.isBlank()) {
          final String[] split = line.split(",");
          beacons.add(
              new Position(
                  Integer.parseInt(split[0]),
                  Integer.parseInt(split[1]),
                  Integer.parseInt(split[2])));
        } else {
          sensors.add(new Sensor(sensorName, new Position(0, 0, 0), beacons));
        }
      }

      sensors.add(new Sensor(sensorName, new Position(0, 0, 0), beacons));
    }

    List<Sensor> uncorrected = new ArrayList<>(sensors);

    Queue<Sensor> alreadyCorrected = new ArrayDeque<>();

    sensors.stream().filter(sensor -> sensor.number == 0).findFirst().ifPresent(first -> {
      alreadyCorrected.add(first);
      uncorrected.remove(first);
    });

    while (!alreadyCorrected.isEmpty()) {
      Sensor corrected = alreadyCorrected.remove();

      Set<Sensor> moved = new HashSet<>();
      for (Sensor other : uncorrected) {
        corrected
            .correctPosition(other)
            .ifPresent(
                fixed -> {
                  alreadyCorrected.add(fixed);
                  sensors.remove(fixed);
                  sensors.add(fixed);
                  moved.add(other);
                });
      }
      uncorrected.removeAll(moved);
    }

    int max = 0;
    for (Sensor one : sensors) {
      for (Sensor two : sensors) {
        int distance = Math.abs(one.position().x() - two.position().x())
                + Math.abs(one.position().y() - two.position().y())
                + Math.abs(one.position().z() - two.position().z());

        max = Math.max(max, distance);
      }
    }

    System.out.println(max);
  }

  private record Position(int x, int y, int z) {}

  private record Sensor(int number, Position position, Set<Position> beacons) {
    private Optional<Sensor> correctPosition(Sensor other) {
      for(UnaryOperator<Position> rotator : rotators) {
        Sensor rotated = other.rotate(rotator);
        for(Position beacon : beacons) {
          for(Position otherBeacon : rotated.beacons) {
            Position offset = new Position(beacon.x - otherBeacon.x, beacon.y - otherBeacon.y, beacon.z - otherBeacon.z);
            Sensor candidate = rotated.move(offset);
            if(enoughBeaconsMatch(candidate)) {
              return Optional.of(candidate);
            }
          }
        }
      }

      return Optional.empty();
    }

    private Sensor move(final Position offset) {
      return new Sensor(number, offset, beacons.stream().map(beacon -> new Position(beacon.x() + offset.x(), beacon.y() + offset.y(), beacon.z() + offset.z())).collect(Collectors.toSet()));
    }

    private Sensor rotate(UnaryOperator<Position> rotator) {
      return new Sensor(number, rotator.apply(position), beacons.stream().map(rotator).collect(Collectors.toSet()));
    }

    private boolean enoughBeaconsMatch(final Sensor other) {
      Set<Position> beacons = new HashSet<>(this.beacons);
      beacons.retainAll(other.beacons);

      return beacons.size() >= 12;
    }

    @Override
    public boolean equals(final Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      final Sensor sensor = (Sensor) o;
      return number == sensor.number;
    }

    @Override
    public int hashCode() {
      return Objects.hash(number);
    }
  }
}
