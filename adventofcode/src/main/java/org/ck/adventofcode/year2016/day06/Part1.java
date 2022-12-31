package org.ck.adventofcode.year2016.day06;

import org.ck.codechallengelib.annotation.Solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

@Solution(
    id = 20160601,
    name = "Day 6: Signals and Noise",
    url = "https://adventofcode.com/2016/day/6",
    category = "2016")
public class Part1 {
  public static void main(String[] args) {
    Map<Integer, Map<Character, Integer>> letters = new HashMap<>();

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String line = in.nextLine();
        for (int i = 0; i < line.length(); ++i) {
          letters.putIfAbsent(i, new HashMap<>());
          letters.get(i).putIfAbsent(line.charAt(i), 0);
          letters.get(i).compute(line.charAt(i), (key, v) -> v + 1);
        }
      }
    }

    System.out.println(
        letters.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .flatMap(
                e ->
                    e.getValue().entrySet().stream()
                        .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                        .limit(1)
                        .map(Map.Entry::getKey))
            .map(Object::toString)
            .collect(Collectors.joining()));
  }
}
