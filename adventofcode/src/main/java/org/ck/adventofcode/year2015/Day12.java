package org.ck.adventofcode.year2015;

import java.util.*;
import java.util.stream.IntStream;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20151201,
    name = "Day 12: JSAbacusFramework.io",
    url = "https://adventofcode.com/2015/day/12",
    category = "2015")
@Solution(
    id = 20151202,
    name = "Day 12: JSAbacusFramework.io - Part 2",
    url = "https://adventofcode.com/2015/day/12#part2",
    category = "2015")
public class Day12 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, false);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, true);
  }

  private void run(final Scanner in, final boolean ignoreRed) {
    final String json = in.nextLine();

    final ParseResult parsed = parse(json, 0);

    print(sum(parsed.result(), ignoreRed));
  }

  private static int sum(final Object parsed, final boolean ignoreRed) {
    // TODO make this a switch as soon as Google merges my PR
    if (parsed instanceof List<?> list) {
      int sum = 0;

      for (Object item : list) {
        sum += sum(item, ignoreRed);
      }

      return sum;
    } else if (parsed instanceof Map<?, ?> map) {
      int sum = 0;

      if (!(ignoreRed && map.containsValue("red"))) {
        for (Object item : map.values()) {
          sum += sum(item, ignoreRed);
        }
      }

      return sum;
    } else if (parsed instanceof Integer number) {
      return number;
    } else {
      return 0;
    }
  }

  private static ParseResult parse(final String json, final int index) {
    if (json.charAt(index) == '[') {
      final List<Object> list = new ArrayList<>();

      int i = index;
      while (json.charAt(i) != ']') {
        final ParseResult result = parse(json, i + 1);

        list.add(result.result());
        i = result.index();
      }

      return new ParseResult(list, i + 1);
    } else if (json.charAt(index) == '{') {
      final Map<String, Object> map = new HashMap<>();

      int i = index + 1;
      while (json.charAt(i) != '}') {
        final int end = json.indexOf('"', i + 2);

        final String key = json.substring(i + 2, end);
        final ParseResult result = parse(json, end + 2);

        map.put(key, result.result());
        i = result.index();
      }

      return new ParseResult(map, i + 1);
    } else if (json.charAt(index) == '"') {
      final int end = json.indexOf('"', index + 1);

      return new ParseResult(json.substring(index + 1, end), end + 1);
    } else {
      final int end =
          IntStream.of(json.indexOf(',', index), json.indexOf(']', index), json.indexOf('}', index))
              .filter(i -> i > 0)
              .min()
              .getAsInt();

      try {
        return new ParseResult(Integer.valueOf(json.substring(index, end)), end);
      } catch (NumberFormatException e) {
        return new ParseResult(0, end);
      }
    }
  }

  private record ParseResult(Object result, int index) {}
}
