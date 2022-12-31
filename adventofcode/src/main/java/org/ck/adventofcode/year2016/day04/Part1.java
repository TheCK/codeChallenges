package org.ck.adventofcode.year2016.day04;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20160401,
    name = "Day 4: Security Through Obscurity",
    url = "https://adventofcode.com/2016/day/4",
    category = "2016")
public class Part1 {
  public static void main(String[] args) {
    int sum = 0;

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
          sum += Integer.parseInt(parts[parts.length - 1]);
        }
      }
    }

    System.out.println(sum);
  }
}
