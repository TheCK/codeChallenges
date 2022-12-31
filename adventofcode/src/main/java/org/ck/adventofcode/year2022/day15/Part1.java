package org.ck.adventofcode.year2022.day15;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20221501,
    name = "Day 15: Beacon Exclusion Zone",
    url = "https://adventofcode.com/2022/day/15",
    category = "2022")
public class Part1 {
  private static final Pattern PATTERN =
      Pattern.compile(
          "Sensor at x=(-?\\d+), y=(-?\\d+): closest beacon is at x=(-?\\d+), y=(-?\\d+)");

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int row = in.nextInt();
      List<Sensor> sensors = new ArrayList<>();
      Set<Point> beacons = new HashSet<>();
      while (in.hasNextLine()) {
        String line = in.nextLine();

        Matcher matcher = PATTERN.matcher(line);
        if (matcher.matches()) {
          int sensorX = Integer.parseInt(matcher.group(1));
          int sensorY = Integer.parseInt(matcher.group(2));

          int beaconX = Integer.parseInt(matcher.group(3));
          int beaconY = Integer.parseInt(matcher.group(4));

          int distance = Math.abs(sensorX - beaconX) + Math.abs(sensorY - beaconY);
          sensors.add(new Sensor(sensorX, sensorY, distance));
          beacons.add(new Point(beaconX, beaconY));
        }
      }

      Set<Point> reachableInRow = new HashSet<>();
      for (Sensor sensor : sensors) {
        int xDistance = sensor.range() - Math.abs(row - sensor.y());

        if (xDistance >= 0) {
          for (int x = sensor.x() - xDistance; x <= sensor.x() + xDistance; ++x) {
            Point point = new Point(x, row);
            if (!beacons.contains(point)) {
              reachableInRow.add(point);
            }
          }
        }
      }

      System.out.println(reachableInRow.size());
    }
  }

  record Sensor(int x, int y, int range) {}

  record Point(int x, int y) {}
}
