package org.ck.adventofcode.year2019.day6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.ck.codeChallengeLib.annotation.Solution;

@Solution(
    id = 20190602,
    name = "Day 6: Universal Orbit Map - Part 2",
    url = "https://adventofcode.com/2019/day/6#part2",
    category = "2019")
public class Part2 {
  public static void main(String[] args) {
    Map<String, OrbitInfo> objects = new HashMap<>();

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String line[] = in.nextLine().split("\\)");

        objects.put(line[1], new OrbitInfo(line[0]));
      }
    }

    setSantaMovesToRoot(objects, objects.get("SAN"), 0);
    int moves = getYouMovesToSanta(objects, objects.get("YOU"), 0);

    System.out.println(moves - 2);
  }

  private static void setSantaMovesToRoot(
      Map<String, OrbitInfo> objects, OrbitInfo orbitInfo, int moves) {
    orbitInfo.setSantaMoves(moves);
    objects.computeIfAbsent(orbitInfo.getOrbits(), (foo) -> new OrbitInfo(null));
    if (orbitInfo.getOrbits() != null) {
      setSantaMovesToRoot(objects, objects.get(orbitInfo.getOrbits()), moves + 1);
    }
  }

  private static int getYouMovesToSanta(
      Map<String, OrbitInfo> objects, OrbitInfo orbitInfo, int moves) {
    if (orbitInfo.getSantaMoves() != 0) {
      return orbitInfo.getSantaMoves() + moves;
    }

    return getYouMovesToSanta(objects, objects.get(orbitInfo.getOrbits()), moves + 1);
  }

  private static class OrbitInfo {
    private int santaMoves = 0;
    private String orbits = null;

    public OrbitInfo(String orbits) {
      this.orbits = orbits;
    }

    public int getSantaMoves() {
      return santaMoves;
    }

    public void setSantaMoves(int santaMoves) {
      this.santaMoves = santaMoves;
    }

    public String getOrbits() {
      return orbits;
    }
  }
}
