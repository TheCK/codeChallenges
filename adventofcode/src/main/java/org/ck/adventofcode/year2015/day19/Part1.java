package org.ck.adventofcode.year2015.day19;

import java.util.*;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20151901,
    name = "Day 19: Medicine for Rudolph",
    url = "https://adventofcode.com/2015/day/19",
    category = "2015")
public class Part1 {

  public static void main(String[] args) throws Exception {
    try (Scanner in = new Scanner(System.in)) {
      Map<String, Set<String>> replacements = new HashMap<>();

      while (in.hasNextLine()) {
        String line = in.nextLine();

        if (line.isBlank()) {
          break;
        }

        final String[] split = line.split(" => ");
        replacements.computeIfAbsent(split[0], (key) -> new HashSet<>());
        replacements.get(split[0]).add(split[1]);
      }

      String value = in.nextLine();

      Set<String> replaced = new HashSet<>();
      for (Map.Entry<String, Set<String>> entry : replacements.entrySet()) {
        String key = entry.getKey();

        for (String replace : entry.getValue()) {
          int index = 0;
          while (index >= 0) {
            int start = value.indexOf(key, index);

            if (start >= 0) {
              index = start + key.length();
              replaced.add(value.substring(0, start) + replace + value.substring(index));
            } else {
              index = start;
            }
          }
        }
      }

      System.out.println(replaced.size());
    }
  }
}
