package org.ck.adventofcode.year2021.day22;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20212201,
    name = "Day 22: Reactor Reboot",
    url = "https://adventofcode.com/2021/day/21",
    category = "2021")
public class Part1 {
  private static final Pattern pattern =
      Pattern.compile("(on|off) x=(-?\\d+)..(-?\\d+),y=(-?\\d+)..(-?\\d+),z=(-?\\d+)..(-?\\d+)");

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      Set<Point> points = new HashSet<>();

      while (in.hasNextLine()) {
        Matcher matcher = pattern.matcher(in.nextLine());
        if (matcher.find()) {
          boolean on = "on".equals(matcher.group(1));

          int startX = Integer.parseInt(matcher.group(2));
          int endX = Integer.parseInt(matcher.group(3));

          int startY = Integer.parseInt(matcher.group(4));
          int endY = Integer.parseInt(matcher.group(5));

          int startZ = Integer.parseInt(matcher.group(6));
          int endZ = Integer.parseInt(matcher.group(7));

          for (int x = Math.max(-50, startX); x <= Math.min(50, endX); ++x) {
            for (int y = Math.max(-50, startY); y <= Math.min(50, endY); ++y) {
              for (int z = Math.max(-50, startZ); z <= Math.min(50, endZ); ++z) {
                Point point = new Point(x, y, z);

                if (on) {
                  points.add(point);
                } else {
                  points.remove(point);
                }
              }
            }
          }
        }
      }

      int count = 0;

      for (int x = -50; x <= 50; ++x) {
        for (int y = -50; y <= 50; ++y) {
          for (int z = -50; z <= 50; ++z) {
            Point point = new Point(x, y, z);

            if (points.contains(point)) {
              ++count;
            }
          }
        }
      }

      System.out.println(count);
    }
  }

  private record Point(int x, int y, int z) {}
}
