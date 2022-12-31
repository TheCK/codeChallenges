package org.ck.adventofcode.year2021.day17;

import org.ck.codechallengelib.annotation.Solution;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Solution(
    id = 20211702,
    name = "Day 17: Trick Shot - Part 2",
    url = "https://adventofcode.com/2021/day/17#part2",
    category = "2021")
public class Part2 {
  private static final Pattern number =
      Pattern.compile("target area: x=(-?[0-9]+)..(-?[0-9]+), y=(-?[0-9]+)..(-?[0-9]+)");

  public static void main(String[] args) {

    try (Scanner in = new Scanner(System.in)) {
      final Matcher matcher = number.matcher(in.nextLine());

      if (matcher.find()) {
        int minX = Integer.parseInt(matcher.group(1));
        int maxX = Integer.parseInt(matcher.group(2));
        int minY = Integer.parseInt(matcher.group(3));
        int maxY = Integer.parseInt(matcher.group(4));

        Set<InitialCondition> inits = new HashSet<>();

        for (int initDx = 0; initDx <= maxX; ++initDx) {
          for (int initDy = minY; initDy < 10000; ++initDy) {
            int x = 0;
            int y = 0;
            int dx = initDx;
            int dy = initDy;
            while (x <= maxX && y >= minY) {
              x += Math.max(dx--, 0);
              y += dy--;

              if (x >= minX && x <= maxX && y >= minY && y <= maxY) {
                inits.add(new InitialCondition(initDx, initDy));
              }
            }
          }
        }

        System.out.println(inits.size());
      }
    }
  }

  private static final record InitialCondition(int dx, int dy) {}
}
