package org.ck.adventofcode.year2024;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20242101,
    name = "Day 21: Keypad Conundrum",
    url = "https://adventofcode.com/2024/day/21",
    category = "2024")
@Solution(
    id = 20242102,
    name = "Day 21: Keypad Conundrum - Part 2",
    url = "https://adventofcode.com/2024/day/21#part2",
    category = "2024")
public class Day21 extends AOCSolution {
  private static final Map<Character, Position> NUM_PAD = new HashMap<>();
  private static final Map<Character, Position> DIR_PAD = new HashMap<>();

  static {
    initNumPadMovements();
    initDirPadMovements();
  }

  private static void initNumPadMovements() {
    NUM_PAD.put('0', new Position(1, 0));
    NUM_PAD.put('1', new Position(0, 1));
    NUM_PAD.put('2', new Position(1, 1));
    NUM_PAD.put('3', new Position(2, 1));
    NUM_PAD.put('4', new Position(0, 2));
    NUM_PAD.put('5', new Position(1, 2));
    NUM_PAD.put('6', new Position(2, 2));
    NUM_PAD.put('7', new Position(0, 3));
    NUM_PAD.put('8', new Position(1, 3));
    NUM_PAD.put('9', new Position(2, 3));
    NUM_PAD.put('A', new Position(2, 0));
  }

  private static void initDirPadMovements() {
    DIR_PAD.put('^', new Position(1, 1));
    DIR_PAD.put('<', new Position(0, 0));
    DIR_PAD.put('v', new Position(1, 0));
    DIR_PAD.put('>', new Position(2, 0));
    DIR_PAD.put('A', new Position(2, 1));
  }

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, 2);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, 25);
  }

  private void run(final Scanner in, final int intermediateRobots) {
    final List<String> codes = new ArrayList<>();
    while (in.hasNextLine()) {
      codes.add(in.nextLine());
    }

    long result = 0;
    for (String code : codes) {
      Position currentPosition = NUM_PAD.get('A');
      final StringBuilder keyPresses = new StringBuilder();

      for (char c : code.toCharArray()) {
        final Position nextPosition = NUM_PAD.get(c);
        keyPresses.append(getKeyPresses(currentPosition, nextPosition));
        keyPresses.append('A');

        currentPosition = nextPosition;
      }

      final Map<CacheKey, Long> cache = new HashMap<>();

      char current = 'A';
      long length = 0;
      for (final char next : "%sA".formatted(keyPresses).toCharArray()) {
        length += getKeyPresses(current, next, cache, intermediateRobots - 1);
        current = next;
      }

      result += (length - 1) * Long.parseLong(code.replaceAll("\\D", ""));
    }

    print(result);
  }

  private long getKeyPresses(
      final char one, final char two, final Map<CacheKey, Long> cache, int depth) {
    final CacheKey cacheKey = new CacheKey(one, two, depth);

    if (cache.containsKey(cacheKey)) {
      return cache.get(cacheKey);
    }

    final Set<String> presses = getCombos(DIR_PAD.get(one), DIR_PAD.get(two), 1);

    if (depth == 0) {
      return presses.stream().findFirst().orElseThrow().length();
    }

    long min = Long.MAX_VALUE;

    for (final String press : presses) {
      char current = 'A';
      long result = 0;
      for (final char next : "%sA".formatted(press).toCharArray()) {
        result += getKeyPresses(current, next, cache, depth - 1);
        current = next;
      }

      min = Math.min(min, result);
    }

    cache.put(cacheKey, min - 1);
    return min - 1;
  }

  private Set<String> getCombos(
      final Position currentPosition, final Position nextPosition, final int invalidKeyY) {
    final List<Character> keyPresses = new ArrayList<>();

    final int xDiff = currentPosition.x() - nextPosition.x();
    final int yDiff = currentPosition.y() - nextPosition.y();

    for (int i = yDiff; i < 0; ++i) {
      keyPresses.add('^');
    }

    for (int i = 0; i < yDiff; ++i) {
      keyPresses.add('v');
    }

    for (int i = xDiff; i < 0; ++i) {
      keyPresses.add('>');
    }

    for (int i = 0; i < xDiff; ++i) {
      keyPresses.add('<');
    }

    return shuffle(keyPresses).stream()
        .filter(
            keys -> {
              if (currentPosition.y() == invalidKeyY
                  && xDiff != 0
                  && nextPosition.x() == 0
                  && keys.startsWith("<".repeat(xDiff))) {
                return false;
              }

              return !(currentPosition.x() == 0
                  && nextPosition.y() == invalidKeyY
                  && (keys.startsWith("^") || keys.startsWith("v")));
            })
        .collect(Collectors.toSet());
  }

  private Set<String> shuffle(final List<Character> chars) {
    if (chars.isEmpty()) {
      return Set.of("A");
    }

    if (chars.size() == 1) {
      return Set.of(chars.getFirst() + "A");
    }

    Set<String> result = new HashSet<>();

    for (int i = 0; i < chars.size(); ++i) {
      final List<Character> remaining =
          Stream.concat(chars.stream().limit(i), chars.stream().skip(i + 1L)).toList();

      Set<String> others = shuffle(remaining);
      for (String other : others) {
        result.add(chars.get(i) + other);
      }
    }

    return result;
  }

  private String getKeyPresses(final Position currentPosition, final Position nextPosition) {
    final StringBuilder keyPresses = new StringBuilder();

    final int xDiff = currentPosition.x() - nextPosition.x();
    final int yDiff = currentPosition.y() - nextPosition.y();

    if (currentPosition.y() == 0 && nextPosition.x() == 0) {
      if (yDiff < 0) {
        keyPresses.append("^".repeat(-1 * yDiff));
      }

      if (yDiff > 0) {
        keyPresses.append("v".repeat(yDiff));
      }

      if (xDiff > 0) {
        keyPresses.append("<".repeat(xDiff));
      }

      if (xDiff < 0) {
        keyPresses.append(">".repeat(-1 * xDiff));
      }

      return keyPresses.toString();
    }

    if (xDiff > 0) {
      keyPresses.append("<".repeat(xDiff));
    }

    if (yDiff < 0) {
      keyPresses.append("^".repeat(-1 * yDiff));
    }

    if (yDiff > 0) {
      keyPresses.append("v".repeat(yDiff));
    }

    if (xDiff < 0) {
      keyPresses.append(">".repeat(-1 * xDiff));
    }

    return keyPresses.toString();
  }

  private record CacheKey(char start, char end, int depth) {}

  private record Position(int x, int y) {}
}
