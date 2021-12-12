package org.ck.adventofcode.year2021.day12;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.*;

@Solution(
    id = 20211201,
    name = "Day 12: Passage Pathing",
    url = "https://adventofcode.com/2021/day/12",
    category = "2021")
public class Part1 {
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

    System.out.println(getPaths(caves, new HashSet<>(), "start"));
  }

  private static int getPaths(
      final Map<String, List<String>> caves, final Set<String> visited, final String cave) {
    if (visited.contains(cave) && cave.toLowerCase().equals(cave)) {
      return 0;
    }

    if ("end".equals(cave)) {
      return 1;
    }

    int paths = 0;
    for (String newCave : caves.get(cave)) {
      Set<String> newVisited = new HashSet<>(visited);
      newVisited.add(cave);
      paths += getPaths(caves, newVisited, newCave);
    }

    return paths;
  }
}
