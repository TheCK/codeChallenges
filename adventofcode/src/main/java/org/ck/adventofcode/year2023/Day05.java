package org.ck.adventofcode.year2023;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20230501,
    name = "Day 5: If You Give A Seed A Fertilizer",
    url = "https://adventofcode.com/2023/day/5",
    category = "2023")
@Solution(
    id = 20230502,
    name = "Day 5: If You Give A Seed A Fertilizer - Part 2",
    url = "https://adventofcode.com/2023/day/5#part2",
    category = "2023")
public class Day05 extends AOCSolution {
  private static final Pattern MAP_PATTERN = Pattern.compile("(?<map>[a-z-]+) map:");

  @Override
  protected void runPartOne(final Scanner in) {
    run(
        in,
        inputs -> {
          final Set<Slice> slices = new HashSet<>();

          for (int i = 1; i < inputs.length; ++i) {
            slices.add(new Slice(Long.parseLong(inputs[i]), 1L));
          }

          return slices;
        });
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        inputs -> {
          final Set<Slice> slices = new HashSet<>();

          for (int i = 1; i < inputs.length; i += 2) {
            slices.add(new Slice(Long.parseLong(inputs[i]), Long.parseLong(inputs[i + 1])));
          }

          return slices;
        });
  }

  private void run(final Scanner in, final Function<String[], Set<Slice>> getSlices) {
    final Map<String, Set<Mapping>> mappings = new HashMap<>();

    final String[] seeds = in.nextLine().split(" ");

    String map = null;
    while (in.hasNextLine()) {
      final String line = in.nextLine();
      final Matcher matcher = MAP_PATTERN.matcher(line);

      if (matcher.matches()) {
        map = matcher.group("map");
      } else {
        final String[] mapping = line.split(" ");

        if (mapping.length == 3) {
          mappings.computeIfAbsent(map, key -> new HashSet<>());
          mappings
              .get(map)
              .add(
                  new Mapping(
                      Long.parseLong(mapping[1]),
                      Long.parseLong(mapping[0]),
                      Long.parseLong(mapping[2])));
        }
      }
    }

    long min = Long.MAX_VALUE;
    for (Slice seedSlice : getSlices.apply(seeds)) {
      String currentCategory = "seed";
      Set<Slice> currentSlices = Set.of(seedSlice);

      while (!currentCategory.equals("location")) {
        final String finalCurrentCategory = currentCategory;
        final Set<Slice> newSlices = new HashSet<>();

        final String currentMapping =
            mappings.keySet().stream()
                .filter(key -> key.startsWith(finalCurrentCategory))
                .findAny()
                .orElseThrow();

        for (final Slice slice : currentSlices) {
          final List<Mapping> intersectingMappings =
              mappings.get(currentMapping).stream()
                  .filter(
                      mapping ->
                          (mapping.fromStart() <= slice.start()
                                  && slice.start() < mapping.fromEnd())
                              || (mapping.fromStart() < slice.end()
                                  && (slice.end()) < mapping.fromEnd()))
                  .sorted(Comparator.comparingLong(Mapping::fromStart))
                  .toList();

          if (!intersectingMappings.isEmpty()) {
            long currentStart = slice.start();
            for (final Mapping intersectingMapping : intersectingMappings) {
              while (currentStart < intersectingMapping.fromEnd() && currentStart < slice.end()) {
                if (currentStart < intersectingMapping.fromStart()) {
                  newSlices.add(
                      new Slice(currentStart, intersectingMapping.fromStart() - currentStart));
                  currentStart = intersectingMapping.fromStart();
                } else {
                  final long end = Math.min(intersectingMapping.fromEnd(), slice.end());
                  newSlices.add(
                      new Slice(
                          intersectingMapping.toStart()
                              + (currentStart - intersectingMapping.fromStart()),
                          end - currentStart));
                  currentStart = end;
                }
              }
            }

            if (currentStart < slice.end()) {
              newSlices.add(new Slice(currentStart, slice.end() - currentStart));
            }
          } else {
            newSlices.add(slice);
          }
        }

        currentCategory = currentMapping.split("-")[2];
        currentSlices = newSlices;
      }

      min = Math.min(currentSlices.stream().mapToLong(Slice::start).min().orElseThrow(), min);
    }

    print(min);
  }

  private record Mapping(long fromStart, long toStart, long range) {
    public long fromEnd() {
      return fromStart + range;
    }
  }

  private record Slice(long start, long range) {
    public long end() {
      return start + range;
    }
  }
}
