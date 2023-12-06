package org.ck.adventofcode.year2023;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.BiFunction;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20230601,
    name = "Day 6: Wait For It",
    url = "https://adventofcode.com/2023/day/6",
    category = "2023")
@Solution(
    id = 20230602,
    name = "Day 6: Wait For It - Part 2",
    url = "https://adventofcode.com/2023/day/6#part2",
    category = "2023")
public class Day06 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(
        in,
        (time, distance) -> {
          final Set<Race> races = new HashSet<>();
          final String[] times = time.split("\\s+");
          final String[] distances = distance.split("\\s+");

          for (int i = 0; i < times.length; ++i) {
            races.add(new Race(Long.parseLong(times[i]), Long.parseLong(distances[i])));
          }

          return races;
        });
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        (time, distance) ->
            Set.of(
                new Race(
                    Long.parseLong(time.replaceAll("\\s+", "")),
                    Long.parseLong(distance.replaceAll("\\s+", "")))));
  }

  private void run(final Scanner in, final BiFunction<String, String, Set<Race>> getRaces) {
    final String time = in.nextLine().split(": +")[1];
    final String distance = in.nextLine().split(": +")[1];

    final Set<Race> races = getRaces.apply(time, distance);

    print(
        races.stream()
            .mapToLong(
                race -> {
                  final double sqrt = Math.sqrt((race.time() * race.time() - 4L * race.distance()));
                  final long max = (long) Math.floor((-1 * race.time() - sqrt) / -2);
                  final long min = (long) Math.ceil((-1 * race.time() + sqrt) / -2);

                  final long distanceAtMax = (race.time() - max) * max;
                  final long distanceAtMin = (race.time() - min) * min;

                  return max
                      - min
                      + 1
                      - (distanceAtMax == race.distance() ? 1 : 0)
                      - (distanceAtMin == race.distance() ? 1 : 0);
                })
            .reduce(1, (one, two) -> one * two));
  }

  private record Race(long time, long distance) {}
}
