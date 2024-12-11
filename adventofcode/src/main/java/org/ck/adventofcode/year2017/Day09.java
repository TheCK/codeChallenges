package org.ck.adventofcode.year2017;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.ToIntFunction;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20170901,
    name = "Day 9: Stream Processing",
    url = "https://adventofcode.com/2017/day/9",
    category = "2017")
@Solution(
    id = 20170902,
    name = "Day 9: Stream Processing - Part 2",
    url = "https://adventofcode.com/2017/day/9#part2",
    category = "2017")
public class Day09 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, result -> count(result.result(), 1));
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, ParseResult::garbageCount);
  }

  private void run(final Scanner in, final ToIntFunction<ParseResult> getResult) {
    final String line = in.nextLine();

    print(getResult.applyAsInt(parse(line, 1)));
  }

  private int count(final List<?> result, final int value) {
    int count = value;

    for (Object o : result) {
      if (o instanceof List<?> list) {
        count += count(list, value + 1);
      }
    }

    return count;
  }

  private static ParseResult parse(final String line, final int start) {
    final List<Object> result = new ArrayList<>();
    int index = start;
    int garbageCount = 0;

    while (line.charAt(index) != '}') {
      if (line.charAt(index) == '{') {
        final ParseResult parseResult = parse(line, index + 1);

        result.add(parseResult.result());
        garbageCount += parseResult.garbageCount();
        index = parseResult.newIndex() + 1;
      } else if (line.charAt(index) == ',') {
        ++index;
      } else if (line.charAt(index) == '<') {
        final ParseResult parseResult = parseGarbage(line, index + 1);

        garbageCount += parseResult.garbageCount();
        index = parseResult.newIndex() + 1;
      }
    }

    return new ParseResult(result, index, garbageCount);
  }

  private static ParseResult parseGarbage(final String line, final int start) {
    int index = start;
    int garbageCount = 0;

    while (line.charAt(index) != '>') {
      if (line.charAt(index) == '!') {
        index += 2;
      } else {
        ++garbageCount;
        ++index;
      }
    }

    return new ParseResult(null, index, garbageCount);
  }

  private record ParseResult(List<Object> result, int newIndex, int garbageCount) {}
}
