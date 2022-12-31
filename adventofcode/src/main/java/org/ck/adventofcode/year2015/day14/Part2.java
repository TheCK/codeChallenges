package org.ck.adventofcode.year2015.day14;

import org.ck.codechallengelib.annotation.Solution;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Solution(
    id = 20151402,
    name = "Day 14: Reindeer Olympics - Part 2",
    url = "https://adventofcode.com/2015/day/14#part2",
    category = "2015")
public class Part2 {
  private static final Pattern pattern =
      Pattern.compile(
          "([a-zA-Z]+) can fly (\\d+) km/s for (\\d+) seconds, but then must rest for (\\d+) seconds.");

  public static void main(String[] args) throws Exception {
    Set<Reindeer> reindeer = new HashSet<>();

    try (Scanner in = new Scanner(System.in)) {
      int time = Integer.parseInt(in.nextLine());

      while (in.hasNextLine()) {
        String line = in.nextLine();
        final Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
          reindeer.add(
              new Reindeer(
                  matcher.group(1),
                  Integer.parseInt(matcher.group(2)),
                  Integer.parseInt(matcher.group(3)),
                  Integer.parseInt(matcher.group(4))));
        }
      }

      Map<String, Integer> points = new HashMap<>();
      for (Reindeer deer : reindeer) {
        points.put(deer.name(), 0);
      }

      for (int i = 1; i <= time; ++i) {
        int max = 0;
        Set<String> names = new HashSet<>();

        for (Reindeer deer : reindeer) {
          int cycles = i / deer.cycleTime();
          int remainders = i % deer.cycleTime();

          int distance =
              (cycles * deer.speed() * deer.runTime())
                  + (Math.min(remainders, deer.runTime) * deer.speed());

          if (distance == max) {
            names.add(deer.name());
          } else if (distance > max) {
            max = distance;
            names = new HashSet<>();
            names.add(deer.name());
          }
        }

        for (String name : names) {
          points.compute(name, (key, value) -> value + 1);
        }
      }

      System.out.println(points.values().stream().mapToInt(n -> n).max().getAsInt());
    }
  }

  private record Reindeer(String name, int speed, int runTime, int restTime) {
    public int cycleTime() {
      return runTime + restTime;
    }
  }
}
