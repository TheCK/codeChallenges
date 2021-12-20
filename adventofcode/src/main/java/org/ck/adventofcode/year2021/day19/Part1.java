package org.ck.adventofcode.year2021.day19;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Solution(
    id = 20211901,
    name = "Day 19: Beacon Scanner",
    url = "https://adventofcode.com/2021/day/19",
    category = "2021",
    solved = false)
public class Part1 {
  private static final Pattern scannerPattern = Pattern.compile("--- scanner (\\d+) ---");

  public static void main(String[] args) {
    Map<Integer, Set<Beacon>> beacons = new HashMap<>();

    try (Scanner in = new Scanner(System.in)) {
      int scanner = 0;

      while (in.hasNextLine()) {
        String line = in.nextLine();

        final Matcher matcher = scannerPattern.matcher(line);
        if (matcher.find()) {
          scanner = Integer.parseInt(matcher.group(1));
          beacons.put(scanner, new HashSet<>());
        } else if (!line.isBlank()) {
          final String[] split = line.split(",");
          beacons
              .get(scanner)
              .add(
                  new Beacon(
                      Integer.parseInt(split[0]),
                      Integer.parseInt(split[1]),
                      Integer.parseInt(split[2])));
        }
      }
    }

    for (int i = 0; i < beacons.size(); ++i) {
      for (int j = i + 1; j < beacons.size(); ++j) {
        for (Beacon beacon1 : beacons.get(i)) {
          for (Beacon beacon2 : beacons.get(j)) {
            Function<Beacon, Set<Beacon>> aliases = getAliases(beacon1, beacon2);
            int same = 0;

            for (Beacon candidate : beacons.get(j)) {
              final int finalI = i;
              if (aliases.apply(candidate).stream()
                  .anyMatch(beacon -> beacons.get(finalI).contains(beacon))) {
                ++same;
              }
            }

            if (same >= 12) {
              System.err.println(i + " next to " + j);
            }
          }
        }
      }
    }

    System.out.println("foo");
  }

  private static Function<Beacon, Set<Beacon>> getAliases(
      final Beacon beacon1, final Beacon beacon2) {
    return (beacon ->
        new HashSet<>(
            List.of(
                new Beacon(beacon.x - Math.abs(beacon2.x - beacon1.x), 0, 0),
                new Beacon(beacon.x - Math.abs(-beacon2.x - beacon1.x), 0, 0),
                new Beacon(beacon.x - Math.abs(beacon2.x + beacon1.x), 0, 0),
                new Beacon(beacon.x - Math.abs(-beacon2.x + beacon1.x), 0, 0))));
  }

  private static final record Beacon(int x, int y, int z) {}
}
