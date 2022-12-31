package org.ck.adventofcode.year2019.day10;

import org.ck.codechallengelib.annotation.Solution;

import java.util.*;

@Solution(
    id = 20191001,
    name = "Day 10: Monitoring Station",
    url = "https://adventofcode.com/2019/day/10",
    category = "2019")
public class Part1 {
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
          maxVisibleAsteroids = Math.max(maxVisibleAsteroids, visibleAsteroids);
        }
      }
    }

    System.out.println(maxVisibleAsteroids);
  }

  private static int getGdc(int a, int b) {
    if (b == 0) return a;
    return getGdc(b, a % b);
  }
}
