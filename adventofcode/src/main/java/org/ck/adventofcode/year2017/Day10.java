package org.ck.adventofcode.year2017;

import java.util.Arrays;
import java.util.HexFormat;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20171001,
    name = "Day 10: Knot Hash",
    url = "https://adventofcode.com/2017/day/10",
    category = "2017")
@Solution(
    id = 20171002,
    name = "Day 10: Knot Hash - Part 2",
    url = "https://adventofcode.com/2017/day/10#part2",
    category = "2017")
public class Day10 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(
        in,
        line -> Arrays.stream(line.split(",")).map(Integer::valueOf).toList(),
        1,
        list -> String.valueOf(list[0] * list[1]));
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        line -> (line + "\u0011\u001F\u0049\u002F\u0017").chars().boxed().toList(),
        64,
        list -> {
          byte[] bytes = new byte[16];

          for (int i = 0; i < list.length; ++i) {
            bytes[i / 16] = (byte) (bytes[i / 16] ^ list[i]);
          }

          return HexFormat.of().formatHex(bytes);
        });
  }

  private void run(
      final Scanner in,
      final Function<String, List<Integer>> getLengthsFromLine,
      final int rounds,
      final Function<int[], String> getResult) {
    int listLength = in.nextInt();
    in.nextLine();

    final int[] list = new int[listLength];
    for (int i = 0; i < listLength; ++i) {
      list[i] = i;
    }

    final List<Integer> lengths = getLengthsFromLine.apply(in.nextLine());

    int index = 0;
    int skipSize = 0;

    for (int round = 0; round < rounds; ++round) {
      for (int length : lengths) {
        int start = index;
        int end = (start + length - 1) % list.length;

        for (int i = 0; i < length / 2; ++i) {
          final int temp = list[end];
          list[end] = list[start];
          list[start] = temp;

          start = (start + 1) % list.length;
          --end;
          if (end < 0) {
            end = list.length - 1;
          }
        }

        index = (index + length + skipSize) % list.length;
        ++skipSize;
      }
    }

    print(getResult.apply(list));
  }
}
