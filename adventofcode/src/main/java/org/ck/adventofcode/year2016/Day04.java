package org.ck.adventofcode.year2016;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20160401,
    name = "Day 4: Security Through Obscurity",
    url = "https://adventofcode.com/2016/day/4",
    category = "2016")
@Solution(
    id = 20160402,
    name = "Day 4: Security Through Obscurity - Part 2",
    url = "https://adventofcode.com/2016/day/4#part2",
    category = "2016")
public class Day04 extends AOCSolution {
  private static List<String> WANTED_ROOM = List.of("northpole", "object", "storage");

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, parts -> Integer.parseInt(parts[parts.length - 1]));
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        parts -> {
          final int id = Integer.parseInt(parts[parts.length - 1]);

          final List<String> name = new ArrayList<>();
          for (int i = 0; i < parts.length - 1; ++i) {
            final char[] chars = parts[i].toCharArray();

            for (int j = 0; j < chars.length; ++j) {
              chars[j] -= 'a';
              chars[j] = (char) ((chars[j] + id) % 26);
              chars[j] += 'a';
            }

            name.add(new String(chars));
          }

          return name.equals(WANTED_ROOM) ? id : 0;
        });
  }

  private void run(final Scanner in, final ToIntFunction<String[]> getLineValue) {
    int sum = 0;

    while (in.hasNextLine()) {
      final String[] input = in.nextLine().split("\\[");

      final Map<Character, Long> counts =
          input[0]
              .chars()
              .filter(c -> c >= 'a' && c <= 'z')
              .mapToObj(c -> (Character) (char) c)
              .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

      final String checksum =
          counts.entrySet().stream()
              .sorted(
                  (e1, e2) ->
                      e1.getValue().equals(e2.getValue())
                          ? e1.getKey().compareTo(e2.getKey())
                          : e2.getValue().compareTo(e1.getValue()))
              .limit(5)
              .map(c -> c.getKey().toString())
              .collect(Collectors.joining());

      if (input[1].startsWith(checksum)) {
        final String[] parts = input[0].split("-");
        sum += getLineValue.applyAsInt(parts);
      }
    }

    print(sum);
  }
}
