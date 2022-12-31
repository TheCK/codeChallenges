package org.ck.adventofcode.year2021.day17;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20211701,
    name = "Day 17: Trick Shot",
    url = "https://adventofcode.com/2021/day/17",
    category = "2021")
public class Part1 {
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

        int maxH = 0;

        for (int initDx = 7; initDx < 100; ++initDx) {
          for (int initDy = 0; initDy < 10000; ++initDy) {
            int h = 0;
            int max = 0;

            int x = 0;
            int y = 0;
            int dx = initDx;
            int dy = initDy;
            while (x <= maxX && y >= minY) {
              x += Math.max(dx--, 0);
              y += dy--;

              max = Math.max(y, max);

              if (x >= minX && x <= maxX && y >= minY && y <= maxY) {
                h = Math.max(h, max);
              }
            }

            maxH = Math.max(maxH, h);
          }
        }

        System.out.println(maxH);
      }
    }
  }
}
