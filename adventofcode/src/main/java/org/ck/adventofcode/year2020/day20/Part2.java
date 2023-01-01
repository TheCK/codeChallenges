package org.ck.adventofcode.year2020.day20;

import java.util.*;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.ArrayUtils;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20202002,
    name = "Day 20: Jurassic Jigsaw - Part 2",
    url = "https://adventofcode.com/2020/day/20",
    category = "2020")
public class Part2 {
  private static final Pattern tileNamePattern = Pattern.compile("Tile (\\d+):");

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

    Tile topLeft =
        tiles.stream().filter(tile -> tile.getNeighbours().size() == 2).findAny().orElseThrow();

    while (topLeft.getNeighbour(Tile.Edge.TOP) != null
        || topLeft.getNeighbour(Tile.Edge.LEFT) != null) {
      topLeft.rotateCW();
    }

    Tile first = topLeft;
    Tile tile = topLeft;

    List<List<Character>> bigMap = new ArrayList<>();

    int row = 0;

    while (tile != null) {
      List<char[]> pixels = tile.getPixels();

      for (int y = 0; y < pixels.size() - 2; ++y) {
        char[] currentRow = pixels.get(y);
        while (bigMap.size() <= (row * (pixels.size() - 2)) + y) {
          bigMap.add(new ArrayList<>());
        }

        for (int x = 0; x < currentRow.length - 2; ++x) {
          bigMap.get((row * (pixels.size() - 2)) + y).add(pixels.get(y + 1)[x + 1]);
        }
      }

      Tile right = tile.getNeighbour(Tile.Edge.RIGHT);
      if (right != null) {
        tile = right;
      } else {
        ++row;

        tile = first.getNeighbour(Tile.Edge.BOTTOM);
        first = tile;
      }
    }

    Tile bigTile = new Tile(0);

    for (List<Character> currentRow : bigMap) {
      char[] newRow = new char[currentRow.size()];

      for (int i = 0; i < currentRow.size(); ++i) {
        newRow[i] = currentRow.get(i);
      }

      bigTile.addRow(newRow);
    }

    int state = 0;

    while (state < 8) {
      switch (state) {
        case 1, 2, 3, 5, 6, 7 -> bigTile.rotateCW();
        case 4 -> bigTile.flipX();
      }

      int monsters = bigTile.countMonsters();
      if (monsters > 0) {
        System.out.println(bigTile.countRoughness(monsters));
        break;
      }

      ++state;
    }
  }

  private static class Tile {
    private static final String FORMAT = "%s-%s";

    private static final Map<String, Consumer<Tile>> actions =
        new HashMap<>() {
          {
            put(String.format(FORMAT, Edge.TOP, Edge.TOP), Tile::nothing);
            put(String.format(FORMAT, Edge.TOP, Edge.TOP_REVERSE), Tile::nothing);
            put(String.format(FORMAT, Edge.TOP, Edge.BOTTOM), Tile::nothing);
            put(String.format(FORMAT, Edge.TOP, Edge.BOTTOM_REVERSE), Tile::nothing);
            put(String.format(FORMAT, Edge.TOP, Edge.LEFT), Tile::nothing);
            put(String.format(FORMAT, Edge.TOP, Edge.LEFT_REVERSE), Tile::nothing);
            put(String.format(FORMAT, Edge.TOP, Edge.RIGHT), Tile::nothing);
            put(String.format(FORMAT, Edge.TOP, Edge.RIGHT_REVERSE), Tile::nothing);

            put(String.format(FORMAT, Edge.LEFT, Edge.TOP), Tile::nothing);
            put(String.format(FORMAT, Edge.LEFT, Edge.TOP_REVERSE), Tile::nothing);
            put(String.format(FORMAT, Edge.LEFT, Edge.BOTTOM), Tile::nothing);
            put(String.format(FORMAT, Edge.LEFT, Edge.BOTTOM_REVERSE), Tile::nothing);
            put(String.format(FORMAT, Edge.LEFT, Edge.LEFT), Tile::nothing);
            put(String.format(FORMAT, Edge.LEFT, Edge.LEFT_REVERSE), Tile::nothing);
            put(String.format(FORMAT, Edge.LEFT, Edge.RIGHT), Tile::nothing);
            put(String.format(FORMAT, Edge.LEFT, Edge.RIGHT_REVERSE), Tile::nothing);

            put(
                String.format(FORMAT, Edge.RIGHT, Edge.TOP),
                tile -> {
                  tile.rotateCCW();
                  tile.flipX();
                });
            put(String.format(FORMAT, Edge.RIGHT, Edge.TOP_REVERSE), Tile::rotateCCW);
            put(String.format(FORMAT, Edge.RIGHT, Edge.BOTTOM), Tile::rotateCW);
            put(
                String.format(FORMAT, Edge.RIGHT, Edge.BOTTOM_REVERSE),
                tile -> {
                  tile.rotateCW();
                  tile.flipX();
                });

            put(String.format(FORMAT, Edge.RIGHT, Edge.LEFT), Tile::nothing);
            put(String.format(FORMAT, Edge.RIGHT, Edge.LEFT_REVERSE), Tile::flipX);
            put(String.format(FORMAT, Edge.RIGHT, Edge.RIGHT), Tile::flipY);
            put(String.format(FORMAT, Edge.RIGHT, Edge.RIGHT_REVERSE), Tile::flipBoth);

            put(String.format(FORMAT, Edge.BOTTOM, Edge.TOP), Tile::nothing);
            put(String.format(FORMAT, Edge.BOTTOM, Edge.TOP_REVERSE), Tile::flipY);
            put(String.format(FORMAT, Edge.BOTTOM, Edge.BOTTOM), Tile::flipX);
            put(String.format(FORMAT, Edge.BOTTOM, Edge.BOTTOM_REVERSE), Tile::flipBoth);

            put(
                String.format(FORMAT, Edge.BOTTOM, Edge.LEFT),
                tile -> {
                  tile.rotateCW();
                  tile.flipY();
                });
            put(String.format(FORMAT, Edge.BOTTOM, Edge.LEFT_REVERSE), Tile::rotateCW);
            put(String.format(FORMAT, Edge.BOTTOM, Edge.RIGHT), Tile::rotateCCW);
            put(
                String.format(FORMAT, Edge.BOTTOM, Edge.RIGHT_REVERSE),
                tile -> {
                  tile.rotateCCW();
                  tile.flipY();
                });
          }
        };
    private final long id;
    private List<char[]> pixels = new ArrayList<>();
    private final List<Tile> neighbours = new ArrayList<>();

    public Tile(long id) {
      this.id = id;
    }

    public List<char[]> getPixels() {
      return pixels;
    }

    private void nothing() {
      // do nothing
    }

    private void flipBoth() {
      flipY();
      flipX();
    }

    private void flipX() {
      List<char[]> newPixels = new ArrayList<>();

      for (int i = 0; i < pixels.size(); ++i) {
        newPixels.add(new char[pixels.get(0).length]);
      }

      for (int x = 0; x < pixels.size(); ++x) {
        for (int y = 0; y < pixels.get(x).length; ++y) {
          newPixels.get(pixels.size() - y - 1)[x] = pixels.get(y)[x];
        }
      }

      pixels = newPixels;
    }

    private void flipY() {
      List<char[]> newPixels = new ArrayList<>();

      for (int i = 0; i < pixels.size(); ++i) {
        newPixels.add(new char[pixels.get(0).length]);
      }

      for (int x = 0; x < pixels.size(); ++x) {
        for (int y = 0; y < pixels.get(x).length; ++y) {
          newPixels.get(y)[pixels.get(y).length - x - 1] = pixels.get(y)[x];
        }
      }

      pixels = newPixels;
    }

    private void rotateCCW() {
      rotateCW();
      rotateCW();
      rotateCW();
    }

    public void rotateCW() {
      List<char[]> newPixels = new ArrayList<>();

      for (int i = 0; i < pixels.get(0).length; ++i) {
        newPixels.add(new char[pixels.size()]);
      }

      for (int x = 0; x < pixels.size(); ++x) {
        for (int y = pixels.get(x).length - 1; y >= 0; --y) {
          newPixels.get(x)[newPixels.size() - y - 1] = pixels.get(y)[x];
        }
      }

      pixels = newPixels;
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
      actions.get(String.format(FORMAT, other, own)).accept(this);
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

    public int countMonsters() {
      int monsters = 0;

      for (int y = 0; y < pixels.size() - 2; ++y) {
        for (int x = 0; x < pixels.get(y).length - 19; ++x) {
          if (pixels.get(y)[x + 18] == '#'
              && pixels.get(y + 1)[x] == '#'
              && pixels.get(y + 1)[x + 5] == '#'
              && pixels.get(y + 1)[x + 6] == '#'
              && pixels.get(y + 1)[x + 11] == '#'
              && pixels.get(y + 1)[x + 12] == '#'
              && pixels.get(y + 1)[x + 17] == '#'
              && pixels.get(y + 1)[x + 18] == '#'
              && pixels.get(y + 1)[x + 19] == '#'
              && pixels.get(y + 2)[x + 1] == '#'
              && pixels.get(y + 2)[x + 4] == '#'
              && pixels.get(y + 2)[x + 7] == '#'
              && pixels.get(y + 2)[x + 10] == '#'
              && pixels.get(y + 2)[x + 13] == '#'
              && pixels.get(y + 2)[x + 16] == '#') {
            ++monsters;
          }
        }
      }

      return monsters;
    }

    public int countRoughness(final int monsters) {
      int roughness = 0;

      for (char[] pixel : pixels) {
        for (final char c : pixel) {
          if (c == '#') {
            ++roughness;
          }
        }
      }

      return roughness - monsters * 15;
    }

    private enum Edge {
      TOP,
      BOTTOM,
      LEFT,
      RIGHT,
      TOP_REVERSE,
      BOTTOM_REVERSE,
      LEFT_REVERSE,
      RIGHT_REVERSE
    }
  }
}
