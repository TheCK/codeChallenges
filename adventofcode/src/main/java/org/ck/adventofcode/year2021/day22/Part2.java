package org.ck.adventofcode.year2021.day22;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Solution(
    id = 20212202,
    name = "Day 22: Reactor Reboot - Part 2",
    url = "https://adventofcode.com/2021/day/21#part2",
    category = "2022")
public class Part2 {
  private static final Pattern pattern =
      Pattern.compile("(on|off) x=(-?\\d+)..(-?\\d+),y=(-?\\d+)..(-?\\d+),z=(-?\\d+)..(-?\\d+)");

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      List<Cube> cubes = new ArrayList<>();

      while (in.hasNextLine()) {
        Matcher matcher = pattern.matcher(in.nextLine());
        if (matcher.find()) {
          Cube cube =
              new Cube(
                  "on".equals(matcher.group(1)),
                  Long.parseLong(matcher.group(2)),
                  Long.parseLong(matcher.group(3)),
                  Long.parseLong(matcher.group(4)),
                  Long.parseLong(matcher.group(5)),
                  Long.parseLong(matcher.group(6)),
                  Long.parseLong(matcher.group(7)));

          List<Cube> newCubes = new ArrayList<>();

          if (cube.on) {
            newCubes.add(cube);
          }

          for (Cube other : cubes) {
            other.intersect(cube).ifPresent(newCubes::add);
          }

          cubes.addAll(newCubes);
        }
      }

      System.out.println(cubes.stream().mapToLong(Cube::calculateVolume).sum());
    }
  }

  private record Cube(boolean on, long startX, long endX, long startY, long endY, long startZ, long endZ) {
    public Optional<Cube> intersect(Cube other) {
      Cube intersection = new Cube(
              !on,
              Math.max(startX,other.startX),
              Math.min(endX,other.endX),
              Math.max(startY,other.startY),
              Math.min(endY,other.endY),
              Math.max(startZ,other.startZ),
              Math.min(endZ,other.endZ));

      if((intersection.startX <= intersection.endX)
              && (intersection.startY <= intersection.endY)
              && (intersection.startZ <= intersection.endZ)) {
        return Optional.of(intersection);
      }

      return Optional.empty();
    }

    public long calculateVolume() {
      return (on ? 1 : -1) * (endX - startX + 1) * (endY - startY + 1) * (endZ - startZ + 1);
    }
  }
}
