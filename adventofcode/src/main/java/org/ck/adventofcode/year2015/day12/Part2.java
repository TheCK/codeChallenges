package org.ck.adventofcode.year2015.day12;

import org.ck.codechallengelib.annotation.Solution;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

@Solution(
    id = 20151202,
    name = "Day 12: JSAbacusFramework.io - Part 2",
    url = "https://adventofcode.com/2015/day/12#part2",
    category = "2015")
public class Part2 {
  private static final Pattern number = Pattern.compile("(-?[0-9])+");

  public static void main(String[] args) throws Exception {
    try (Scanner in = new Scanner(System.in)) {
      String json = in.nextLine();

      ParseResult parsed = parse(json, 0);
      int sum = sum(parsed.result());

      System.out.println(sum);
    }
  }

  private static int sum(final Object parsed) {
    if (parsed instanceof List list) {
      int sum = 0;

      for (Object item : list) {
        sum += sum(item);
      }

      return sum;
    } else if (parsed instanceof Map map) {
      int sum = 0;

      if (!map.containsValue("red")) {
        for (Object item : map.values()) {
          sum += sum(item);
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
      List<Object> list = new ArrayList<>();

      int i = index;
      while (json.charAt(i) != ']') {
        ParseResult result = parse(json, i + 1);

        list.add(result.result());
        i = result.index();
      }

      return new ParseResult(list, i + 1);
    } else if (json.charAt(index) == '{') {
      Map<String, Object> map = new HashMap<>();

      int i = index;
      while (json.charAt(i) != '}') {
        final int end = json.indexOf('"', i + 2);

        String key = json.substring(i + 2, end);
        ParseResult result = parse(json, end + 2);

        map.put(key, result.result());
        i = result.index();
      }

      return new ParseResult(map, i + 1);
    } else if (json.charAt(index) == '"') {
      final int end = json.indexOf('"', index + 1);

      return new ParseResult(json.substring(index + 1, end), end + 1);
    } else {
      final int end =
          IntStream.of(
                  json.indexOf(',', index + 1),
                  json.indexOf(']', index + 1),
                  json.indexOf('}', index + 1))
              .filter(i -> i > 0)
              .min()
              .getAsInt();

      return new ParseResult(Integer.valueOf(json.substring(index, end)), end);
    }
  }

  private record ParseResult(Object result, int index) {}
}
