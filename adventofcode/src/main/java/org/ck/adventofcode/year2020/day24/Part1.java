package org.ck.adventofcode.year2020.day24;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20202401,
    name = "Day 24: Lobby Layout",
    url = "https://adventofcode.com/2020/day/24",
    category = "2020")
public class Part1 {
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
            case "w" -> --x;
            case "e" -> ++x;
            case "ne" -> {
              x += y % 2 == 0 ? 0 : 1;
              --y;
            }
            case "se" -> {
              x += y % 2 == 0 ? 0 : 1;
              ++y;
            }
            case "nw" -> {
              x -= y % 2 == 0 ? 1 : 0;
              --y;
            }
            case "sw" -> {
              x -= y % 2 == 0 ? 1 : 0;
              ++y;
            }
            default -> throw new IllegalStateException("Unexpected value: " + matcher.group(1));
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

      System.out.println(blackTiles.size());
    }
  }

  private static class Tile {
    private final int x;
    private final int y;

    public Tile(int x, int y) {
      this.x = x;
      this.y = y;
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
