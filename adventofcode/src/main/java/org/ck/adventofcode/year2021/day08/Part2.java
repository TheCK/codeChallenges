package org.ck.adventofcode.year2021.day08;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.*;

import static java.util.stream.Collectors.toSet;

@Solution(
    id = 20210802,
    name = "Day 8: Seven Segment Search - Part 2",
    url = "https://adventofcode.com/2021/day/8#part2",
    category = "2021")
public class Part2 {
  public static Set<Integer> unique = new HashSet<>(Arrays.asList(2, 3, 4, 7));

  public static void main(String[] args) {
    int sum = 0;

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String[] parts = in.nextLine().split(" \\| ");

        String[] config = parts[0].split(" ");
        Arrays.sort(
            config,
            (s1, s2) -> {
              int l1 = s1.length();
              int l2 = s2.length();

              if (l1 == 5) {
                l1 = Integer.MAX_VALUE;
              }
              if (l2 == 5) {
                l2 = Integer.MAX_VALUE;
              }

              return Integer.compare(l1, l2);
            });

        Map<Integer, Set<Integer>> numbers = new HashMap<>();
        for (String value : config) {
          Set<Integer> segments = value.chars().boxed().collect(toSet());

          switch (segments.size()) {
            case 2:
              numbers.put(1, segments);
              break;
            case 3:
              numbers.put(7, segments);
              break;
            case 4:
              numbers.put(4, segments);
              break;
            case 7:
              numbers.put(8, segments);
              break;
            case 6:
              if (!segments.containsAll(numbers.get(1))) {
                numbers.put(6, segments);
              } else if (segments.containsAll(numbers.get(4))) {
                numbers.put(9, segments);
              } else {
                numbers.put(0, segments);
              }
              break;
            case 5:
              if (segments.containsAll(numbers.get(1))) {
                numbers.put(3, segments);
              } else if (numbers.get(9).containsAll(segments)) {
                numbers.put(5, segments);
              } else {
                numbers.put(2, segments);
              }
              break;
          }
        }

        String[] displays = parts[1].split(" ");
        int number = 0;
        for (String display : displays) {
          Set<Integer> segments = display.chars().boxed().collect(toSet());

          number *= 10;
          for (Map.Entry<Integer, Set<Integer>> entry : numbers.entrySet()) {
            if (entry.getValue().containsAll(segments) && segments.containsAll(entry.getValue())) {
              number += entry.getKey();
              break;
            }
          }
        }

        sum += number;
      }
    }

    System.out.println(sum);
  }
}
