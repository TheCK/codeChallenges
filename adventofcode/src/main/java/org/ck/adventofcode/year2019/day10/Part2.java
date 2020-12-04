package org.ck.adventofcode.year2019.day10;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.ck.codeChallengeLib.annotation.Solution;

import java.util.*;

@Solution(
    id = 20191002,
    name = "Day 10: Monitoring Station - Part 2",
    url = "https://adventofcode.com/2019/day/10#part2",
    category = "2019")
public class Part2 {
  public static void main(String[] args) throws Exception {
    List<String> lines = new ArrayList<>();

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        lines.add(in.nextLine());
      }
    }

    int xMax = lines.get(0).length();
    int yMax = lines.size();
    int maxVisibleAsteroids = 0;
    int bestX = -1;
    int bestY = -1;

    for (int stationX = 0; stationX < xMax; ++stationX) {
      for (int stationY = 0; stationY < xMax; ++stationY) {
        if (lines.get(stationY).charAt(stationX) == '#') {
          Set<String> ratios = new HashSet<>();

          int visibleAsteroids = 0;
          for (int x = 0; x < xMax; ++x) {
            for (int y = 0; y < yMax; ++y) {
              if (lines.get(y).charAt(x) == '#') {
                int xdiff = x - stationX;
                int ydiff = y - stationY;

                if (ydiff == 0 && xdiff == 0) {
                  continue;
                }

                int gcd = getGdc(Math.abs(xdiff), Math.abs(ydiff));
                String ratio = String.format("%d:%d", xdiff / gcd, ydiff / gcd);

                if (!ratios.contains(ratio)) {
                  ratios.add(ratio);
                  ++visibleAsteroids;
                }
              }
            }
          }

          if (visibleAsteroids > maxVisibleAsteroids) {
            bestX = stationX;
            bestY = stationY;
            maxVisibleAsteroids = visibleAsteroids;
          }
        }
      }
    }

    Map<Asteroid, PriorityQueue<Asteroid>> asteroids = new HashMap<>();
    for (int x = 0; x < xMax; ++x) {
      for (int y = 0; y < yMax; ++y) {
        if (lines.get(y).charAt(x) == '#') {
          int xdiff = x - bestX;
          int ydiff = y - bestY;

          if (ydiff == 0 && xdiff == 0) {
            continue;
          }

          int gcd = getGdc(Math.abs(xdiff), Math.abs(ydiff));
          Asteroid ratio = new Asteroid(xdiff / gcd, ydiff / gcd);

          asteroids.computeIfAbsent(ratio, (value) -> new PriorityQueue<>());
          asteroids.get(ratio).add(new Asteroid(xdiff, ydiff));
        }
      }
    }

    List<Asteroid> sortedRatios = new ArrayList<>(asteroids.keySet());
    Collections.sort(
        sortedRatios,
        Comparator.comparingDouble(
            o -> (Math.PI / 2 - Math.atan2(o.xDiff, o.yDiff)) % (2 * Math.PI)));
    Queue<Asteroid> ratios = new ArrayDeque<>(sortedRatios);

    int count = 0;
    while (!ratios.isEmpty()) {
      Asteroid ratio = ratios.remove();
      Asteroid asteroid = asteroids.get(ratio).remove();

      if (++count == 200) {
        System.out.println(100 * (bestX + asteroid.xDiff) + bestY + asteroid.yDiff);
        break;
      }

      if (!asteroids.get(ratio).isEmpty()) {
        ratios.add(ratio);
      }
    }
  }

  private static int getGdc(int a, int b) {
    if (b == 0) return a;
    return getGdc(b, a % b);
  }

  private static class Asteroid implements Comparable<Asteroid> {
    int xDiff = 0;
    int yDiff = 0;

    public Asteroid(int xDiff, int yDiff) {
      this.xDiff = xDiff;
      this.yDiff = yDiff;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Asteroid asteroid = (Asteroid) o;
      return xDiff == asteroid.xDiff && yDiff == asteroid.yDiff;
    }

    @Override
    public int hashCode() {
      return Objects.hash(xDiff, yDiff);
    }

    @Override
    public int compareTo(Asteroid other) {
      if (xDiff != other.xDiff) {
        return Integer.compare(Math.abs(xDiff), Math.abs(other.xDiff));
      }

      if (yDiff != other.yDiff) {
        return Integer.compare(Math.abs(yDiff), Math.abs(other.yDiff));
      }

      return 0;
    }
  }
}
