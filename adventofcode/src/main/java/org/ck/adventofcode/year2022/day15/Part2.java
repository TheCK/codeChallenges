package org.ck.adventofcode.year2022.day15;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Solution(
    id = 20221502,
    name = "Day 15: Beacon Exclusion Zone - Part 2",
    url = "https://adventofcode.com/2022/day/15#part2",
    category = "2022")
public class Part2 {
  private static final Pattern PATTERN =
      Pattern.compile(
          "Sensor at x=(-?\\d+), y=(-?\\d+): closest beacon is at x=(-?\\d+), y=(-?\\d+)");

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      long max = in.nextLong();
      List<Sensor> sensors = new ArrayList<>();
      while (in.hasNextLine()) {
        String line = in.nextLine();

        Matcher matcher = PATTERN.matcher(line);
        if (matcher.matches()) {
          long sensorX = Long.parseLong(matcher.group(1));
          long sensorY = Long.parseLong(matcher.group(2));

          long beaconX = Long.parseLong(matcher.group(3));
          long beaconY = Long.parseLong(matcher.group(4));

          long distance = Math.abs(sensorX - beaconX) + Math.abs(sensorY - beaconY);
          sensors.add(new Sensor(sensorX, sensorY, distance));
        }
      }

      for (Sensor sensor : sensors) {
        long minX = sensor.x() - sensor.range() - 1;

        for (long x = minX, y = sensor.y(); x <= sensor.x(); ++x, --y) {
          if (x < 0 || y < 0 || x > max || y > max) {
            continue;
          }

          if (checkAllSensors(x, y, sensors)) {
            System.out.println(x * 4000000 + y);
            return;
          }
        }
      }
    }
  }

  private static boolean checkAllSensors(final long x, final long y, final List<Sensor> sensors) {
    for (Sensor sensor : sensors) {
      long distance = Math.abs(sensor.x() - x) + Math.abs(sensor.y() - y);

      if (sensor.range() >= distance) {
        return false;
      }
    }

    return true;
  }

  record Sensor(long x, long y, long range) {}
}
