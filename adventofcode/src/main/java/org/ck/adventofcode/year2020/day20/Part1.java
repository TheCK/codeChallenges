package org.ck.adventofcode.year2020.day20;

import org.apache.commons.lang3.ArrayUtils;
import org.ck.codechallengelib.annotation.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Solution(
    id = 20202001,
    name = "Day 20: Jurassic Jigsaw",
    url = "https://adventofcode.com/2020/day/20",
    category = "2020")
public class Part1 {
  private static final Pattern tileNamePattern = Pattern.compile("Tile ([0-9]+):");

  public static void main(String[] args) {
    List<Tile> tiles = new ArrayList<>();
    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String line = in.nextLine();

        Matcher matcher = tileNamePattern.matcher(line);
        if (matcher.matches()) {
          Tile tile = new Tile(Long.parseLong(matcher.group(1)));

          do {
            line = in.nextLine();
            if (!line.isBlank()) {
              tile.addRow(line.toCharArray());
            }

          } while (!line.isBlank() && in.hasNextLine());

          tiles.add(tile);
        }
      }
    }

    for (int i = 0; i < tiles.size(); ++i) {
      for (int j = i + 1; j < tiles.size(); ++j) {
        if (tiles.get(i).fits(tiles.get(j))) {
          tiles.get(i).addNeighbour(tiles.get(j));
          tiles.get(j).addNeighbour(tiles.get(i));
        }
      }
    }

    System.out.println(
        tiles.stream()
            .filter(tile -> tile.getNeighbours().size() == 2)
            .mapToLong(Tile::getId)
            .reduce(1, (a, b) -> a * b));
  }

  private static class Tile {
    private long id;
    private List<char[]> pixels = new ArrayList<>();

    private List<Tile> neighbours = new ArrayList<>();

    public Tile(long id) {
      this.id = id;
    }

    public long getId() {
      return id;
    }

    public void addRow(char[] row) {
      pixels.add(row);
    }

    public List<Tile> getNeighbours() {
      return neighbours;
    }

    public void addNeighbour(Tile tile) {
      neighbours.add(tile);
    }

    public boolean fits(Tile other) {
      for (Edge thisEdge : new Edge[] {Edge.TOP, Edge.BOTTOM, Edge.LEFT, Edge.RIGHT}) {
        for (Edge otherEdge : Edge.values()) {
          if (Arrays.equals(getEdge(thisEdge), other.getEdge(otherEdge))) {
            return true;
          }
        }
      }

      return false;
    }

    private char[] getEdge(Edge edge) {
      switch (edge) {
        case TOP:
          return pixels.get(0);
        case BOTTOM:
          return pixels.get(pixels.size() - 1);
        case LEFT:
          char[] left = new char[pixels.size()];
          for (int i = 0; i < pixels.size(); ++i) {
            left[i] = pixels.get(i)[0];
          }
          return left;
        case RIGHT:
          char[] right = new char[pixels.size()];
          for (int i = 0; i < pixels.size(); ++i) {
            right[i] = pixels.get(i)[pixels.get(i).length - 1];
          }
          return right;
        case TOP_REVERSE:
          char[] topReverse = Arrays.copyOf(pixels.get(0), pixels.get(0).length);
          ArrayUtils.reverse(topReverse);
          return topReverse;
        case BOTTOM_REVERSE:
          char[] bottomReverse = Arrays.copyOf(pixels.get(pixels.size() - 1), pixels.get(0).length);
          ArrayUtils.reverse(bottomReverse);
          return bottomReverse;
        case LEFT_REVERSE:
          char[] leftReverse = new char[pixels.size()];
          for (int i = 0; i < pixels.size(); ++i) {
            leftReverse[leftReverse.length - i - 1] = pixels.get(i)[0];
          }
          return leftReverse;
        case RIGHT_REVERSE:
          char[] rightReverse = new char[pixels.size()];
          for (int i = 0; i < pixels.size(); ++i) {
            rightReverse[rightReverse.length - i - 1] = pixels.get(i)[pixels.get(i).length - 1];
          }
          return rightReverse;
      }

      return null;
    }

    private enum Edge {
      TOP,
      BOTTOM,
      LEFT,
      RIGHT,
      TOP_REVERSE,
      BOTTOM_REVERSE,
      LEFT_REVERSE,
      RIGHT_REVERSE;
    }
  }
}
