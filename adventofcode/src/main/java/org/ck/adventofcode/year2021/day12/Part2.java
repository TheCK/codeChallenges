package org.ck.adventofcode.year2021.day12;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.*;

@Solution(
    id = 20211202,
    name = "Day 12: Passage Pathing - Part 2",
    url = "https://adventofcode.com/2021/day/12#part2",
    category = "2021")
public class Part2 {
  public static void main(String[] args) {
    Map<String, List<String>> caves = new HashMap<>();

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        final String[] split = in.nextLine().split("-");

        caves.putIfAbsent(split[0], new ArrayList<>());
        caves.putIfAbsent(split[1], new ArrayList<>());

        caves.get(split[0]).add(split[1]);
        caves.get(split[1]).add(split[0]);
      }
    }

    System.out.println(getPaths(caves, new ArrayList<>(), "start", Optional.empty()));
  }

  private static int getPaths(
      final Map<String, List<String>> caves,
      final List<String> visited,
      final String cave,
      final Optional<String> smallCave) {
    if (visited.contains(cave) && cave.toLowerCase().equals(cave)) {
      if (smallCave.isEmpty() && !"start".equals(cave)) {
        int paths = 0;

        for (String newCave : caves.get(cave)) {
          List<String> newVisited = new ArrayList<>(visited);
          newVisited.add(cave);
          paths += getPaths(caves, newVisited, newCave, Optional.of(cave));
        }

        return paths;
      }

      return 0;
    }

    if ("end".equals(cave)) {
      return 1;
    }

    int paths = 0;
    for (String newCave : caves.get(cave)) {
      List<String> newVisited = new ArrayList<>(visited);
      newVisited.add(cave);
      paths += getPaths(caves, newVisited, newCave, smallCave);
    }

    return paths;
  }
}
