package org.ck.adventofcode.year2019.day03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.ck.codeChallengeLib.annotation.Solution;

@Solution(
    id = 20190302,
    name = "Day 3: Crossed Wires - Part 2",
    url = "https://adventofcode.com/2019/day/3#part2",
    category = "2019")
public class Part2 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      String[] cable1 = in.nextLine().split(",");
      String[] cable2 = in.nextLine().split(",");

      int x = 0;
      int y = 0;
      int cableDistance = 0;

      Map<Integer, List<Segment>> vertivalSegements = new HashMap<>();
      Map<Integer, List<Segment>> horizontalSegements = new HashMap<>();

      for (String step : cable1) {
        int length = Integer.parseInt(step.substring(1));

        switch (step.charAt(0)) {
          case 'R':
            horizontalSegements.computeIfAbsent(y, (value) -> new ArrayList<>());
            horizontalSegements.get(y).add(new Segment('R', x, x + length, cableDistance));
            x += length;
            cableDistance += length;
            break;
          case 'L':
            horizontalSegements.computeIfAbsent(y, (value) -> new ArrayList<>());
            horizontalSegements.get(y).add(new Segment('L', x - length, x, cableDistance));
            x -= length;
            cableDistance += length;
            break;
          case 'U':
            vertivalSegements.computeIfAbsent(x, (value) -> new ArrayList<>());
            vertivalSegements.get(x).add(new Segment('U', y, y + length, cableDistance));
            y += length;
            cableDistance += length;
            break;
          case 'D':
            vertivalSegements.computeIfAbsent(x, (value) -> new ArrayList<>());
            vertivalSegements.get(x).add(new Segment('D', y - length, y, cableDistance));
            y -= length;
            cableDistance += length;
            break;
        }
      }

      x = 0;
      y = 0;
      cableDistance = 0;

      int distance = Integer.MAX_VALUE;

      for (String step : cable2) {
        int length = Integer.parseInt(step.substring(1));

        switch (step.charAt(0)) {
          case 'R':
            for (int i = x; i < x + length; ++i) {
              if (vertivalSegements.get(i) != null) {
                for (Segment segment : vertivalSegements.get(i)) {
                  if (segment.getStart() < y && y < segment.getEnd()) {
                    distance =
                        Math.min(
                            distance,
                            cableDistance
                                + (i - x)
                                + segment.getDistanceAtBegining()
                                + Math.abs(y - segment.getStart()));
                  }
                }
              }
            }
            x += length;
            cableDistance += length;
            break;
          case 'L':
            for (int i = x - length; i < x; ++i) {
              if (vertivalSegements.get(i) != null) {
                for (Segment segment : vertivalSegements.get(i)) {
                  if (segment.getStart() < y && y < segment.getEnd()) {
                    distance =
                        Math.min(
                            distance,
                            cableDistance
                                + (x - i)
                                + segment.getDistanceAtBegining()
                                + Math.abs(y - segment.getStart()));
                  }
                }
              }
            }
            x -= length;
            cableDistance += length;
            break;
          case 'U':
            for (int i = y; i < y + length; ++i) {
              if (horizontalSegements.get(i) != null) {
                for (Segment segment : horizontalSegements.get(i)) {
                  if (segment.getStart() < x && x < segment.getEnd()) {
                    distance =
                        Math.min(
                            distance,
                            cableDistance
                                + (i - y)
                                + segment.getDistanceAtBegining()
                                + Math.abs(x - segment.getStart()));
                  }
                }
              }
            }
            y += length;
            cableDistance += length;
            break;
          case 'D':
            for (int i = y - length; i < y; ++i) {
              if (horizontalSegements.get(i) != null) {
                for (Segment segment : horizontalSegements.get(i)) {
                  if (segment.getStart() < x && x < segment.getEnd()) {
                    distance =
                        Math.min(
                            distance,
                            cableDistance
                                + (y - i)
                                + segment.getDistanceAtBegining()
                                + Math.abs(x - segment.getStart()));
                  }
                }
              }
            }
            y -= length;
            cableDistance += length;
            break;
        }
      }

      System.out.println(distance);
    }
  }

  private static class Segment {
    private char direction;

    private int start;
    private int end;
    private int distanceAtBegining;

    public Segment(char direction, int start, int end, int distanceAtBegining) {
      this.direction = direction;

      this.start = start;
      this.end = end;
      this.distanceAtBegining = distanceAtBegining;
    }

    public char getDirection() {
      return direction;
    }

    public int getStart() {
      return start;
    }

    public int getEnd() {
      return end;
    }

    public int getDistanceAtBegining() {
      return distanceAtBegining;
    }
  }
}
