package org.ck.adventofcode.year2022.day17;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.*;

@Solution(
    id = 20221702,
    name = "Day 17: Pyroclastic Flow - Part 2",
    url = "https://adventofcode.com/2022/day/17#part2",
    category = "2022",
    solved = false)
public class Part2 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      String pattern = in.nextLine();

      int maxHeight = 0;
      Set<Point> solid = new HashSet<>();

      List<Integer> heightDiffs = new ArrayList<>();
      List<Integer> patternDiffs = new ArrayList<>();

      int patternPosition = 0;
      for (int i = 0; i < 2022; ++i) {
        if (i != 0 && i % 5 == 0 && i % pattern.length() == 0) {
          if (checkForLoop(heightDiffs, patternDiffs)) {
            System.err.println("i:" + i);
            System.err.println("h:" + maxHeight);
          }
        }

        Rock rock = getRock(i, maxHeight);
        int oldPatternPosition = patternPosition;
        int oldMaxHeight = maxHeight;

        while (true) {
          if (pattern.charAt(patternPosition % pattern.length()) == '<') {
            rock.moveLeft(solid);
          } else {
            rock.moveRight(solid);
          }
          ++patternPosition;

          if (!rock.moveDown(solid)) {
            Set<Point> newRock = rock.settle();

            maxHeight = Math.max(maxHeight, newRock.stream().mapToInt(Point::y).max().orElse(0));

            solid.addAll(newRock);
            break;
          }
        }

        heightDiffs.add(maxHeight - oldMaxHeight);
        patternDiffs.add(patternPosition - oldPatternPosition);
      }

      System.out.println(maxHeight);
    }
  }

  private static boolean checkForLoop(
      final List<Integer> heightDiffs, final List<Integer> patternDiffs) {
    for (int i = 0; i < heightDiffs.size() / 2; ++i) {
      if (!heightDiffs.get(i).equals(heightDiffs.get(heightDiffs.size() / 2 + i))) {
        return false;
      }
    }

    for (int i = 0; i < patternDiffs.size() / 2; ++i) {
      if (!patternDiffs.get(i).equals(patternDiffs.get(patternDiffs.size() / 2 + i))) {
        return false;
      }
    }

    return true;
  }

  private static void print(final Set<Point> solid, final int maxHeight, final Set<Point> rock) {
    System.err.println("");
    for (int y = maxHeight; y > 0; --y) {
      StringBuilder line = new StringBuilder();

      for (int x = 0; x < 7; ++x) {
        if (solid.contains(new Point(x, y))) {
          line.append('#');
        } else if (rock.contains(new Point(x, y))) {
          line.append('@');
        } else {
          line.append('.');
        }
      }

      System.err.println(line);
      System.err.flush();
    }
  }

  private static Rock getRock(final int i, final int maxHeight) {
    return switch (i % 5) {
      case 0 -> new Dash(maxHeight);
      case 1 -> new Plus(maxHeight);
      case 2 -> new L(maxHeight);
      case 3 -> new I(maxHeight);
      case 4 -> new Block(maxHeight);
      default -> throw new IllegalStateException("Unexpected value: " + i % 5);
    };
  }

  record Point(int x, int y) {}

  abstract static class Rock {
    int x;
    int y;

    private final int xMin;
    private final int xMax;
    private final int yOffset;

    private Rock(int x, int y, int xMin, int xMax, int yOffset) {
      this.x = x;
      this.y = y;

      this.xMin = xMin;
      this.xMax = xMax;
      this.yOffset = yOffset;
    }

    public void moveLeft(final Set<Point> taken) {
      if (x - 1 >= xMin && getPositions(-1, 0).stream().noneMatch(taken::contains)) {
        --x;
      }
    }

    public void moveRight(final Set<Point> taken) {
      if (x + 1 <= xMax && getPositions(1, 0).stream().noneMatch(taken::contains)) {
        ++x;
      }
    }

    public boolean moveDown(final Set<Point> taken) {
      if (y - yOffset - 1 > 0 && getPositions(0, -1).stream().noneMatch(taken::contains)) {
        --y;
        return true;
      }

      return false;
    }

    public Set<Point> settle() {
      return getPositions(0, 0);
    }

    protected abstract Set<Point> getPositions(int xOffset, int yOffset);
  }

  private static class Dash extends Rock {
    public Dash(final int y) {
      super(2, y + 4, 0, 3, 0);
    }

    @Override
    protected Set<Point> getPositions(int xOffset, int yOffset) {
      return Set.of(
          new Point(x + xOffset, y + yOffset),
          new Point(x + xOffset + 1, y + yOffset),
          new Point(x + xOffset + 2, y + yOffset),
          new Point(x + xOffset + 3, y + yOffset));
    }
  }

  private static class Plus extends Rock {
    public Plus(final int y) {
      super(3, y + 5, 1, 5, 1);
    }

    protected Set<Point> getPositions(int xOffset, int yOffset) {
      return Set.of(
          new Point(x + xOffset, y + yOffset),
          new Point(x + xOffset + 1, y + yOffset),
          new Point(x + xOffset - 1, y + yOffset),
          new Point(x + xOffset, y + yOffset + 1),
          new Point(x + xOffset, y + yOffset - 1));
    }
  }

  private static class L extends Rock {
    public L(final int y) {
      super(4, y + 4, 2, 6, 0);
    }

    @Override
    protected Set<Point> getPositions(int xOffset, int yOffset) {
      return Set.of(
          new Point(x + xOffset, y + yOffset),
          new Point(x + xOffset - 1, y + yOffset),
          new Point(x + xOffset - 2, y + yOffset),
          new Point(x + xOffset, y + yOffset + 1),
          new Point(x + xOffset, y + yOffset + 2));
    }
  }

  private static class I extends Rock {
    public I(final int y) {
      super(2, y + 4, 0, 6, 0);
    }

    @Override
    protected Set<Point> getPositions(int xOffset, int yOffset) {
      return Set.of(
          new Point(x + xOffset, y + yOffset),
          new Point(x + xOffset, y + yOffset + 1),
          new Point(x + xOffset, y + yOffset + 2),
          new Point(x + xOffset, y + yOffset + 3));
    }
  }

  private static class Block extends Rock {
    public Block(final int y) {
      super(2, y + 4, 0, 5, 0);
    }

    @Override
    protected Set<Point> getPositions(int xOffset, int yOffset) {
      return Set.of(
          new Point(x + xOffset, y + yOffset),
          new Point(x + xOffset, y + yOffset + 1),
          new Point(x + xOffset + 1, y + yOffset),
          new Point(x + xOffset + 1, y + yOffset + 1));
    }
  }
}
