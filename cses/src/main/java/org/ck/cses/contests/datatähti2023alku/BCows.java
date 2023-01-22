package org.ck.cses.contests.datatähti2023alku;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 104302,
    name = "B - Cows",
    url = "https://cses.fi/430/task/B",
    category = "Contests",
    subCategory = "Datatähti 2023 alku")
public class BCows {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int height = in.nextInt();
      int width = in.nextInt();
      in.nextLine();

      Point firstFence = null;
      Point lastFence = null;
      Set<Point> cows = new HashSet<>();

      for (int y = 0; y < height; ++y) {
        String line = in.nextLine();

        for (int x = 0; x < width; ++x) {
          char character = line.charAt(x);

          if (character == '@') {
            cows.add(new Point(x, y));
          } else if (character == '*') {
            if (firstFence == null) {
              firstFence = new Point(x, y);
            } else {
              lastFence = new Point(x, y);
            }
          }
        }
      }

      Point finalFirstFence = firstFence;
      Point finalLastFence = lastFence;

      System.out.println(
          cows.stream()
              .filter(cow -> cow.getY() > finalFirstFence.getY())
              .filter(cow -> cow.getY() < finalLastFence.getY())
              .filter(cow -> cow.getX() > finalFirstFence.getX())
              .filter(cow -> cow.getX() < finalLastFence.getX())
              .count());
    }
  }

  private static final class Point {
    final int x;
    final int y;

    public Point(final int x, final int y) {
      this.x = x;
      this.y = y;
    }

    public int getX() {
      return x;
    }

    public int getY() {
      return y;
    }
  }
}
