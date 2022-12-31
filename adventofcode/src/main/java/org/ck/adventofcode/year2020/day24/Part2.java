package org.ck.adventofcode.year2020.day24;

import org.ck.codechallengelib.annotation.Solution;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Solution(
    id = 20202402,
    name = "Day 24: Lobby Layout - Part 2",
    url = "https://adventofcode.com/2020/day/24",
    category = "2020")
public class Part2 {
  private static final Pattern directionPattern = Pattern.compile("(w|e|ne|nw|se|sw)");

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      Set<Tile> blackTiles = new HashSet<>();

      while (in.hasNextLine()) {
        Matcher matcher = directionPattern.matcher(in.nextLine());

        int x = 0;
        int y = 0;

        int start = 0;
        while (matcher.find(start)) {
          switch (matcher.group(1)) {
            case "w":
              --x;
              break;
            case "e":
              ++x;
              break;
            case "ne":
              x += y % 2 == 0 ? 0 : 1;
              --y;
              break;
            case "se":
              x += y % 2 == 0 ? 0 : 1;
              ++y;
              break;
            case "nw":
              x -= y % 2 == 0 ? 1 : 0;
              --y;
              break;
            case "sw":
              x -= y % 2 == 0 ? 1 : 0;
              ++y;
              break;
          }

          start = matcher.end();
        }

        Tile tile = new Tile(x, y);
        if (blackTiles.contains(tile)) {
          blackTiles.remove(tile);
        } else {
          blackTiles.add(tile);
        }
      }

      IntSummaryStatistics xStats = blackTiles.stream().mapToInt(Tile::getX).summaryStatistics();
      IntSummaryStatistics yStats = blackTiles.stream().mapToInt(Tile::getY).summaryStatistics();

      int xDimension = xStats.getMax() + Math.abs(xStats.getMin()) + 201;
      int xZero = 101 + xStats.getMax();
      int yDimension = yStats.getMax() + Math.abs(yStats.getMin()) + 201;
      int yZero = 101 + yStats.getMax();

      int[][] convey = new int[xDimension][yDimension];

      for (Tile tile : blackTiles) {
        convey[xZero + tile.getX()][yZero + tile.getY()] = 1;
      }

      for (int i = 0; i < 100; ++i) {
        int[][] newConvey = new int[convey.length][convey[0].length];

        for (int x = 0; x < convey.length; ++x) {
          for (int y = 0; y < convey[x].length; ++y) {
            int neighbours = 0;
            if (x > 0) {
              neighbours += convey[x - 1][y]; // w
            }
            if (x < convey.length - 2) {
              neighbours += convey[x + 1][y]; // e
            }
            if (y % 2 == 0) {
              if (y > 0) {
                neighbours += convey[x][y - 1]; // ne

                if (x > 0) {
                  neighbours += convey[x - 1][y - 1]; // nw
                }
              }

              if (y < convey[x].length - 2) {
                neighbours += convey[x][y + 1]; // se

                if (x > 0) {
                  neighbours += convey[x - 1][y + 1]; // sw
                }
              }
            } else {
              neighbours += convey[x][y - 1]; // nw

              if (x < convey.length - 2) {
                neighbours += convey[x + 1][y - 1]; // ne
              }

              if (y < convey[x].length - 2) {
                neighbours += convey[x][y + 1]; // sw

                if (x < convey.length - 2) {
                  neighbours += convey[x + 1][y + 1]; // se
                }
              }
            }

            if (convey[x][y] == 0 && neighbours == 2) {
              newConvey[x][y] = 1;
            } else if (convey[x][y] == 1 && (neighbours == 0 || neighbours > 2)) {
              newConvey[x][y] = 0;
            } else {
              newConvey[x][y] = convey[x][y];
            }
          }
        }

        convey = newConvey;
      }

      System.out.println(Arrays.stream(convey).flatMapToInt(Arrays::stream).sum());
    }
  }

  private static class Tile {
    private final int x;
    private final int y;

    public Tile(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int getX() {
      return x;
    }

    public int getY() {
      return y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Tile tile = (Tile) o;
      return x == tile.x && y == tile.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }
}
