package org.ck.adventofcode.year2022.day17;

import org.ck.codechallengelib.annotation.Solution;

import java.util.*;
import java.util.stream.Collectors;

@Solution(
    id = 20221702,
    name = "Day 17: Pyroclastic Flow - Part 2",
    url = "https://adventofcode.com/2022/day/17#part2",
    category = "2022")
public class Part2 {
  public static void main(String[] args) {
    Map<State, Context> cache = new HashMap<>();
    Set<Rock> lastRocks =
        new LinkedHashSet<>() {
          @Override
          public boolean add(final Rock rock) {
            boolean added = super.add(rock);

            if (size() > 10) {
              Iterator<Rock> iterator = iterator();
              iterator.next();
              iterator.remove();
            }

            return added;
          }
        };

    try (Scanner in = new Scanner(System.in)) {
      String pattern = in.nextLine();

      long maxHeight = 0;
      Set<Point> solid = new HashSet<>();

      int patternPosition = 0;
      boolean cycleFound = false;
      for (long i = 0; i < 1_000_000_000_000L; ++i) {
        Rock rock = getRock(i, maxHeight);

        if (!cycleFound) {
          long finalHeight = maxHeight;
          Set<Point> lastPoints =
              solid.stream()
                  .filter(p -> p.y() > finalHeight - 10)
                  .map(p -> new Point(p.x(), p.y() - finalHeight))
                  .collect(Collectors.toSet());
          State state = new State(rock.getClass(), patternPosition, lastPoints);

          if (cache.containsKey(state)) {
            cycleFound = true;
            Context context = cache.get(state);

            long cycleHeight = maxHeight - context.height();
            long cycleRocks = i - context.rockNumber();

            long cycles = (1_000_000_000_000L - i) / cycleRocks;
            long heightDiff = cycleHeight * cycles;

            maxHeight = maxHeight + heightDiff;
            i = i + cycleRocks * cycles;

            solid.clear();
            context
                .lastRocks()
                .forEach(
                    oldRock -> {
                      oldRock.moveUp(heightDiff + cycleHeight);
                      solid.addAll(oldRock.settle());
                    });
            rock = getRock(i, maxHeight);
          } else {
            cache.put(state, new Context(i, maxHeight, new HashSet<>(lastRocks)));
          }
        }

        while (true) {
          if (pattern.charAt(patternPosition) == '<') {
            rock.moveLeft(solid);
          } else {
            rock.moveRight(solid);
          }
          patternPosition = (patternPosition + 1) % pattern.length();

          if (!rock.moveDown(solid)) {
            lastRocks.add(rock);
            Set<Point> newRock = rock.settle();

            maxHeight = Math.max(maxHeight, newRock.stream().mapToLong(Point::y).max().orElse(0));

            solid.addAll(newRock);
            break;
          }
        }
      }

      System.out.println(maxHeight);
    }
  }

  private static Rock getRock(final long i, final long maxHeight) {
    return switch ((int) (i % 5)) {
      case 0 -> new Dash(maxHeight);
      case 1 -> new Plus(maxHeight);
      case 2 -> new L(maxHeight);
      case 3 -> new I(maxHeight);
      case 4 -> new Block(maxHeight);
      default -> throw new IllegalStateException("Unexpected value: " + i % 5);
    };
  }

  record Point(long x, long y) {}

  abstract static class Rock {
    long x;
    long y;

    private final long xMin;
    private final long xMax;
    private final long yOffset;

    private Rock(long x, long y, long xMin, long xMax, long yOffset) {
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

    public void moveUp(final long distance) {
      y += distance;
    }

    public Set<Point> settle() {
      return getPositions(0, 0);
    }

    protected abstract Set<Point> getPositions(int xOffset, int yOffset);
  }

  private static class Dash extends Rock {
    public Dash(final long y) {
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
    public Plus(final long y) {
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
    public L(final long y) {
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
    public I(final long y) {
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
    public Block(final long y) {
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

  record State(Class<? extends Rock> rockType, int patternPosition, Set<Point> lastPoints) {}

  record Context(long rockNumber, long height, Set<Rock> lastRocks) {}
}
