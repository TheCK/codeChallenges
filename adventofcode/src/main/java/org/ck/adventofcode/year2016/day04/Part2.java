package org.ck.adventofcode.year2016.day04;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

@Solution(
    id = 20160402,
    name = "Day 4: Security Through Obscurity - Part 2",
    url = "https://adventofcode.com/2016/day/4#part2",
    category = "2016")
public class Part2 {
  private static List<String> wantedRoom = List.of("northpole", "object", "storage");

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String[] input = in.nextLine().split("\\[");

        final Map<Character, Long> counts =
            input[0]
                .chars()
                .filter(c -> c >= 'a' && c <= 'z')
                .mapToObj(c -> (Character) (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        final String checksum =
            counts.entrySet().stream()
                .sorted(
                    (e1, e2) -> {
                      if (e1.getValue() == e2.getValue()) {
                        return e1.getKey().compareTo(e2.getKey());
                      }

                      return e2.getValue().compareTo(e1.getValue());
                    })
                .limit(5)
                .map(c -> c.getKey().toString())
                .collect(Collectors.joining());

        if (input[1].startsWith(checksum)) {
          String[] parts = input[0].split("-");
          int id = Integer.parseInt(parts[parts.length - 1]);

          List<String> name = new ArrayList<>();
          for (int i = 0; i < parts.length - 1; ++i) {
            char[] chars = parts[i].toCharArray();

            for (int j = 0; j < chars.length; ++j) {
              chars[j] -= 'a';
              chars[j] = (char) ((chars[j] + id) % 26);
              chars[j] += 'a';
            }

            name.add(new String(chars));
          }

          if (name.equals(wantedRoom)) {
            System.out.println(id);
          }
        }
      }
    }
  }
}
