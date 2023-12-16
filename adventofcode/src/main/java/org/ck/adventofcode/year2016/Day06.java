package org.ck.adventofcode.year2016;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20160601,
    name = "Day 6: Signals and Noise",
    url = "https://adventofcode.com/2016/day/6",
    category = "2016")
@Solution(
    id = 20160602,
    name = "Day 6: Signals and Noise - Part 2",
    url = "https://adventofcode.com/2016/day/6#part2",
    category = "2016")
public class Day06 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, Map.Entry.<Character, Integer>comparingByValue().reversed());
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, Map.Entry.comparingByValue());
  }

  private void run(final Scanner in, final Comparator<Map.Entry<Character, Integer>> letterSorter) {
    final Map<Integer, Map<Character, Integer>> letters = new HashMap<>();

    while (in.hasNextLine()) {
      final String line = in.nextLine();
      for (int i = 0; i < line.length(); ++i) {
        letters.putIfAbsent(i, new HashMap<>());
        letters.get(i).putIfAbsent(line.charAt(i), 0);
        letters.get(i).compute(line.charAt(i), (key, v) -> v + 1);
      }
    }

    print(
        letters.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .flatMap(
                e ->
                    e.getValue().entrySet().stream()
                        .sorted(letterSorter)
                        .limit(1)
                        .map(Map.Entry::getKey))
            .map(Object::toString)
            .collect(Collectors.joining()));
  }
}
