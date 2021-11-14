package org.ck.adventofcode.year2020.day20;

import org.apache.commons.lang3.ArrayUtils;
import org.ck.codeChallengeLib.annotation.Solution;

import java.util.*;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Solution(
    id = 20202002,
    name = "Day 20: Jurassic Jigsaw - Part 2",
    url = "https://adventofcode.com/2020/day/20",
    category = "2020",
    solved = false)
public class Part2 {
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

    Tile topLeft = tiles.stream().filter(tile -> tile.getNeighbours().size() == 2).findAny().get();
  }

  private static class Tile {
    private static final String format = "%s-%s";

    private static final Map<String, Consumer<Tile>> actions =
        new HashMap<>() {
          {
            /*
            TOP,
            BOTTOM,
            LEFT,
            RIGHT,
            TOP_REVERSE,
            BOTTOM_REVERSE,
            LEFT_REVERSE,
            RIGHT_REVERSE;
                   */
            put(String.format(format, Edge.TOP, Edge.TOP), Tile::flipX);
            put(String.format(format, Edge.TOP, Edge.TOP), Tile::flipBoth);
            put(String.format(format, Edge.TOP, Edge.BOTTOM), Tile::nothing);
            put(String.format(format, Edge.TOP, Edge.BOTTOM_REVERSE), Tile::flipY);

            // TODO
            put(String.format(format, Edge.TOP, Edge.LEFT), null /* Tile::rotateCC */);
            put(String.format(format, Edge.TOP, Edge.LEFT_REVERSE), Tile::flipBoth);
            put(String.format(format, Edge.TOP, Edge.RIGHT), Tile::nothing);
            put(String.format(format, Edge.TOP, Edge.RIGHT_REVERSE), Tile::flipY);
          }
        };

    private static void nothing(Tile tile) {
      // nothing
    }

    private static void flipBoth(Tile tile) {
      flipY(tile);
      flipX(tile);
    }

    private static void flipX(Tile tile) {}

    private static void flipY(Tile tile) {}

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

    public Tile getNeighbour(Edge edge) {
      Tile neighbour = null;

      for (Tile other : neighbours) {
        for (Edge otherEdge : Edge.values()) {
          if (Arrays.equals(getEdge(edge), other.getEdge(otherEdge))) {
            other.arrange(edge, otherEdge);
            neighbour = other;
          }
        }

        if (neighbour != null) {
          break;
        }
      }

      return neighbour;
    }

    public void arrange(Edge other, Edge own) {
      actions.get(String.format(format, other, own));
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
