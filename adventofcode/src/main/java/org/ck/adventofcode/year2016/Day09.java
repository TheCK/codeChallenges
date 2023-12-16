package org.ck.adventofcode.year2016;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20160901,
    name = "Day 9: Explosives in Cyberspace",
    url = "https://adventofcode.com/2016/day/9",
    category = "2016")
@Solution(
    id = 20160902,
    name = "Day 9: Explosives in Cyberspace - Part 2",
    url = "https://adventofcode.com/2016/day/9#part2",
    category = "2016")
public class Day09 extends AOCSolution {
  private static final Pattern EXPAND_PATTERN =
      Pattern.compile("\\((?<length>\\d+)x(?<repeat>\\d+)\\)");

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, false);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, true);
  }

  private void run(final Scanner in, final boolean recursive) {
    long length = 0;

    while (in.hasNextLine()) {
      final String line = in.nextLine();
      length += decompress(line, 0, line.length(), recursive);
    }

    print(length);
  }

  private static long decompress(
      final String line, final int initialStart, final int initialEnd, final boolean recursive) {
    long length = 0;
    final Matcher matcher = EXPAND_PATTERN.matcher(line);

    int start = initialStart;
    while (start < initialEnd) {
      if (matcher.find(start) && matcher.start() < initialEnd) {
        final int repeatLength = Integer.parseInt(matcher.group("length"));
        final int repeat = Integer.parseInt(matcher.group("repeat"));

        if (recursive) {
          length +=
              (matcher.start() - start)
                  + repeat
                      * decompress(line, matcher.end(), matcher.end() + repeatLength, recursive);
        } else {
          length += (matcher.start() - start) + (long) repeat * repeatLength;
        }

        start = matcher.end() + repeatLength;
      } else {
        length += initialEnd - start;
        start += initialEnd - start;
      }
    }

    return length;
  }
}
