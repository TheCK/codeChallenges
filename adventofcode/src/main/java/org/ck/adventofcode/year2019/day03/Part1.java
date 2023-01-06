package org.ck.adventofcode.year2019.day03;

import java.util.*;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20190301,
    name = "Day 3: Crossed Wires",
    url = "https://adventofcode.com/2019/day/3",
    category = "2019")
public class Part1 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      String[] cable1 = in.nextLine().split(",");
      String[] cable2 = in.nextLine().split(",");

      int x = 0;
      int y = 0;

      Map<Integer, List<Segment>> vertivalSegements = new HashMap<>();
      Map<Integer, List<Segment>> horizontalSegements = new HashMap<>();

      for (String step : cable1) {
        int length = Integer.parseInt(step.substring(1));

        switch (step.charAt(0)) {
          case 'R' -> {
            horizontalSegements.computeIfAbsent(y, (value) -> new ArrayList<>());
            horizontalSegements.get(y).add(new Segment(x, x + length));
            x += length;
          }
          case 'L' -> {
            horizontalSegements.computeIfAbsent(y, (value) -> new ArrayList<>());
            horizontalSegements.get(y).add(new Segment(x - length, x));
            x -= length;
          }
          case 'U' -> {
            vertivalSegements.computeIfAbsent(x, (value) -> new ArrayList<>());
            vertivalSegements.get(x).add(new Segment(y, y + length));
            y += length;
          }
          case 'D' -> {
            vertivalSegements.computeIfAbsent(x, (value) -> new ArrayList<>());
            vertivalSegements.get(x).add(new Segment(y - length, y));
            y -= length;
          }
          default -> throw new IllegalStateException("Unexpected value: " + step.charAt(0));
        }
      }

      x = 0;
      y = 0;
      int distance = Integer.MAX_VALUE;
      for (String step : cable2) {
        int length = Integer.parseInt(step.substring(1));

        switch (step.charAt(0)) {
          case 'R' -> {
            for (int i = x; i < x + length; ++i) {
              if (vertivalSegements.get(i) != null) {
                for (Segment segment : vertivalSegements.get(i)) {
                  if (segment.getStart() < y && y < segment.getEnd()) {
                    distance = Math.min(distance, Math.abs(i) + Math.abs(y));
                  }
                }
              }
            }
            x += length;
          }
          case 'L' -> {
            for (int i = x - length; i < x; ++i) {
              if (vertivalSegements.get(i) != null) {
                for (Segment segment : vertivalSegements.get(i)) {
                  if (segment.getStart() < y && y < segment.getEnd()) {
                    distance = Math.min(distance, Math.abs(i) + Math.abs(y));
                  }
                }
              }
            }
            x -= length;
          }
          case 'U' -> {
            for (int i = y; i < y + length; ++i) {
              if (horizontalSegements.get(i) != null) {
                for (Segment segment : horizontalSegements.get(i)) {
                  if (segment.getStart() < x && x < segment.getEnd()) {
                    distance = Math.min(distance, Math.abs(i) + Math.abs(x));
                  }
                }
              }
            }
            y += length;
          }
          case 'D' -> {
            for (int i = y - length; i < y; ++i) {
              if (horizontalSegements.get(i) != null) {
                for (Segment segment : horizontalSegements.get(i)) {
                  if (segment.getStart() < x && x < segment.getEnd()) {
                    distance = Math.min(distance, Math.abs(i) + Math.abs(x));
                  }
                }
              }
            }
            y -= length;
          }
          default -> throw new IllegalStateException("Unexpected value: " + step.charAt(0));
        }
      }

      System.out.println(distance);
    }
  }

  private static class Segment {
    int start;
    int end;

    public Segment(int start, int end) {
      this.start = start;
      this.end = end;
    }

    public int getStart() {
      return start;
    }

    public int getEnd() {
      return end;
    }
  }
}
