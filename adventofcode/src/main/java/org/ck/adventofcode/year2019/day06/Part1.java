package org.ck.adventofcode.year2019.day06;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20190601,
    name = "Day 6: Universal Orbit Map",
    url = "https://adventofcode.com/2019/day/6",
    category = "2019")
public class Part1 {
  public static void main(String[] args) {
    Map<String, OrbitInfo> objects = new HashMap<>();

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String line[] = in.nextLine().split("\\)");

        objects.put(line[1], new OrbitInfo(line[0]));
      }
    }

    int count = 0;
    for (Entry<String, OrbitInfo> entry : objects.entrySet()) {
      count += getOrbits(objects, entry.getValue());
    }

    System.out.println(count);
  }

  private static int getOrbits(Map<String, OrbitInfo> objects, OrbitInfo orbitInfo) {
    if (orbitInfo == null) {
      return 0;
    }

    if (orbitInfo.getOrbitCount() == 0) {
      orbitInfo.setOrbitCount(1 + getOrbits(objects, objects.get(orbitInfo.getOrbits())));
    }

    return orbitInfo.getOrbitCount();
  }

  private static class OrbitInfo {
    private int orbitsCount = 0;
    private String orbits = null;

    public OrbitInfo(String orbits) {
      this.orbits = orbits;
    }

    public int getOrbitCount() {
      return orbitsCount;
    }

    public void setOrbitCount(int orbitsCount) {
      this.orbitsCount = orbitsCount;
    }

    public String getOrbits() {
      return orbits;
    }
  }
}
