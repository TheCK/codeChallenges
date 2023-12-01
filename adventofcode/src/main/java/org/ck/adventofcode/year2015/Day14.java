package org.ck.adventofcode.year2015;

import java.util.*;
import java.util.function.ToIntBiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20151401,
    name = "Day 14: Reindeer Olympics",
    url = "https://adventofcode.com/2015/day/14",
    category = "2015")
@Solution(
    id = 20151402,
    name = "Day 14: Reindeer Olympics - Part 2",
    url = "https://adventofcode.com/2015/day/14#part2",
    category = "2015")
public class Day14 extends AOCSolution {
  private static final Pattern PATTERN =
      Pattern.compile(
          "(?<reindeer>[a-zA-Z]+) can fly (?<speed>\\d+) km/s for (?<flyTime>\\d+) seconds, but then must rest for (?<restTime>\\d+) seconds.");

  @Override
  protected void runPartOne(final Scanner in) {
    run(
        in,
        (reindeer, time) -> {
          int max = 0;

          for (Reindeer deer : reindeer) {
            int cycles = time / deer.cycleTime();
            int remainders = time % deer.cycleTime();

            max =
                Math.max(
                    max,
                    (cycles * deer.speed() * deer.runTime())
                        + (Math.min(remainders, deer.runTime) * deer.speed()));
          }

          return max;
        });
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        (reindeer, time) -> {
          final Map<String, Integer> points = new HashMap<>();
          for (Reindeer deer : reindeer) {
            points.put(deer.name(), 0);
          }

          for (int i = 1; i <= time; ++i) {
            final Set<String> names = getLeadingReindeer(reindeer, i);

            for (String name : names) {
              points.compute(name, (key, value) -> value + 1);
            }
          }

          return points.values().stream().mapToInt(n -> n).max().orElseThrow();
        });
  }

  private void run(final Scanner in, final ToIntBiFunction<Set<Reindeer>, Integer> getPoints) {
    final Set<Reindeer> reindeer = new HashSet<>();

    final int time = Integer.parseInt(in.nextLine());

    while (in.hasNextLine()) {
      final String line = in.nextLine();
      final Matcher matcher = PATTERN.matcher(line);

      if (matcher.find()) {
        reindeer.add(
            new Reindeer(
                matcher.group("reindeer"),
                Integer.parseInt(matcher.group("speed")),
                Integer.parseInt(matcher.group("flyTime")),
                Integer.parseInt(matcher.group("restTime"))));
      }
    }

    print(getPoints.applyAsInt(reindeer, time));
  }

  private static Set<String> getLeadingReindeer(final Set<Reindeer> reindeer, final int i) {
    int max = 0;
    final Set<String> names = new HashSet<>();

    for (Reindeer deer : reindeer) {
      final int cycles = i / deer.cycleTime();
      final int remainders = i % deer.cycleTime();

      final int distance =
          (cycles * deer.speed() * deer.runTime())
              + (Math.min(remainders, deer.runTime) * deer.speed());

      if (distance == max) {
        names.add(deer.name());
      } else if (distance > max) {
        max = distance;
        names.clear();
        names.add(deer.name());
      }
    }
    return names;
  }

  private record Reindeer(String name, int speed, int runTime, int restTime) {
    public int cycleTime() {
      return runTime + restTime;
    }
  }
}
