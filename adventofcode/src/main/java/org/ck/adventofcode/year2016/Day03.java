package org.ck.adventofcode.year2016;

import static java.lang.Math.max;
import static java.lang.Math.min;

import java.util.*;
import java.util.function.Function;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20160301,
    name = "Day 3: Squares With Three Sides",
    url = "https://adventofcode.com/2016/day/3",
    category = "2016")
@Solution(
    id = 20160302,
    name = "Day 3: Squares With Three Sides - Part 2",
    url = "https://adventofcode.com/2016/day/3#part2",
    category = "2016")
public class Day03 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(
        in,
        scanner -> Set.of(new Triangle(scanner.nextInt(), scanner.nextInt(), scanner.nextInt())));
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        scanner -> {
          final int a1 = scanner.nextInt();
          final int b1 = scanner.nextInt();
          final int c1 = scanner.nextInt();

          final int a2 = scanner.nextInt();
          final int b2 = scanner.nextInt();
          final int c2 = scanner.nextInt();

          final int a3 = scanner.nextInt();
          final int b3 = scanner.nextInt();
          final int c3 = scanner.nextInt();

          return Set.of(
              new Triangle(a1, a2, a3), new Triangle(b1, b2, b3), new Triangle(c1, c2, c3));
        });
  }

  private void run(final Scanner in, final Function<Scanner, Set<Triangle>> getNextTriangles) {
    long count = 0;

    while (in.hasNextInt()) {
      count += getNextTriangles.apply(in).stream().filter(Triangle::isValid).count();
    }

    print(count);
  }

  private record Triangle(int a, int b, int c) {
    public boolean isValid() {
      int s = min(min(a, b), c);
      int m = max(min(a, b), min(max(a, b), c));
      int l = max(max(a, b), c);

      return (s + m > l);
    }
  }
}
