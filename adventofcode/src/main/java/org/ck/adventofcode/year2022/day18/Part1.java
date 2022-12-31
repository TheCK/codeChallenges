package org.ck.adventofcode.year2022.day18;

import org.ck.codechallengelib.annotation.Solution;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@Solution(
    id = 20221801,
    name = "Day 18: Boiling Boulders",
    url = "https://adventofcode.com/2022/day/18",
    category = "2022")
public class Part1 {
  public static void main(String[] args) {
    Set<Point> cubes = new HashSet<>();

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String[] coords = in.nextLine().split(",");
        cubes.add(
            new Point(
                Integer.parseInt(coords[0]),
                Integer.parseInt(coords[1]),
                Integer.parseInt(coords[2])));
      }
    }

    int visible = 0;

    for (Point cube : cubes) {
      Set<Point> neighbours = getNeighbours(cubes, cube);
      visible += 6 - neighbours.size();
    }

    System.out.println(visible);
  }

  private static Set<Point> getNeighbours(final Set<Point> cubes, final Point cube) {
    Set<Point> neighbours = new HashSet<>(cubes);

    neighbours.retainAll(
        Set.of(
            new Point(cube.x() - 1, cube.y(), cube.z()),
            new Point(cube.x() + 1, cube.y(), cube.z()),
            new Point(cube.x(), cube.y() - 1, cube.z()),
            new Point(cube.x(), cube.y() + 1, cube.z()),
            new Point(cube.x(), cube.y(), cube.z() - 1),
            new Point(cube.x(), cube.y(), cube.z() + 1)));

    return neighbours;
  }

  record Point(int x, int y, int z) {}
}
