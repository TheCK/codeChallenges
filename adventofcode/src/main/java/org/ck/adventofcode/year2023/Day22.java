package org.ck.adventofcode.year2023;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20232201,
    name = "Day 22: ",
    url = "https://adventofcode.com/2023/day/22",
    category = "2023",
    solved = false)
@Solution(
    id = 20232202,
    name = "Day 22:  - Part 2",
    url = "https://adventofcode.com/2023/day/22#part2",
    category = "2023",
    solved = false)
public class Day22 extends AOCSolution {
  private static final Pattern PATTERN =
      Pattern.compile(
          "(?<startX>\\d+),(?<startY>\\d+),(?<startZ>\\d+)~(?<endX>\\d+),(?<endY>\\d+),(?<endZ>\\d+)");

  @Override
  protected void runPartOne(final Scanner in) {
    run(in);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in);
  }

  private void run(final Scanner in) {
    final List<Brick> bricks = new ArrayList<>();

    while (in.hasNextLine()) {
      final String line = in.nextLine();
      final Matcher matcher = PATTERN.matcher(line);

      if (matcher.find()) {
        final int startX = Integer.parseInt(matcher.group("startX"));
        final int startY = Integer.parseInt(matcher.group("startY"));
        final int startZ = Integer.parseInt(matcher.group("startZ"));
        final int endX = Integer.parseInt(matcher.group("endX"));
        final int endY = Integer.parseInt(matcher.group("endY"));
        final int endZ = Integer.parseInt(matcher.group("endZ"));

        bricks.add(new Brick(new Point(startX, startY, startZ), new Point(endX, endY, endZ)));
      }
    }

    settle(bricks);

    print(bricks);
  }

  private void settle(final List<Brick> bricks) {
    while (!bricks.stream().allMatch(Brick::isSettled)) {
      for (final Brick brick : bricks) {
        int collidesIn = Math.min(brick.start.z, brick.end.z) - 1;
        boolean collisionIsSettled = false;

        for (final Brick other : bricks) {
          if (!brick.equals(other)) {
            final int startZ = brick.start.z;
            final int endZ = brick.end.z;

            // int diffZ =

            for (int thisX = Math.min(brick.start.x, brick.end.x);
                thisX <= Math.max(brick.start.x, brick.end.x);
                thisX++) {
              for (int thisY = Math.min(brick.start.y, brick.end.y);
                  thisY <= Math.max(brick.start.y, brick.end.y);
                  thisY++) {}
            }
          }
        }

        brick.moveDown(collidesIn);
        if (brick.start.z == 1 || brick.end.z == 1 || collisionIsSettled) {
          brick.setSettled(true);

          continue;
        }
      }
    }
  }

  private static final class Brick {
    private Point start;
    private Point end;

    private boolean settled = false;

    public Brick(Point start, Point end) {
      this.start = start;
      this.end = end;
    }

    private boolean isSettled() {
      return settled;
    }

    private void setSettled(final boolean settled) {
      this.settled = settled;
    }

    private void moveDown(final int steps) {
      start.moveDown(steps);
      end.moveDown(steps);
    }
  }

  private static final class Point {
    private int x;
    private int y;
    private int z;

    public Point(int x, int y, int z) {
      this.x = x;
      this.y = y;
      this.z = z;
    }

    private void moveDown(final int steps) {
      z -= steps;
    }
  }
}
