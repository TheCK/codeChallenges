package org.ck.adventofcode.year2020.day15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.ck.codeChallengeLib.annotation.Solution;

@Solution(
    id = 20201501,
    name = "Day 15: Rambunctious Recitation",
    url = "https://adventofcode.com/2020/day/15",
    category = "2020")
public class Part1 {
  public static void main(String[] args) {
    Map<Integer, Integer> lastMentioned = new HashMap<>();
    try (Scanner in = new Scanner(System.in)) {
      in.useDelimiter("\\D+");

      List<Integer> startingNumbers = new ArrayList<>();
      while (in.hasNextInt()) {
        startingNumbers.add(in.nextInt());
      }

      for (int i = 0; i < startingNumbers.size() - 1; ++i) {
        lastMentioned.put(startingNumbers.get(i), i);
      }

      int lastNumber = startingNumbers.get(startingNumbers.size() - 1);

      for (int i = startingNumbers.size(); i < 2020; ++i) {
        int newNumber = 0;
        if (lastMentioned.containsKey(lastNumber)) {
          newNumber = i - 1 - lastMentioned.get(lastNumber);
        }

        lastMentioned.put(lastNumber, i - 1);
        lastNumber = newNumber;
      }

      System.out.println(lastNumber);
    }
  }
}
