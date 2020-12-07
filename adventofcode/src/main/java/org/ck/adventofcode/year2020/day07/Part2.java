package org.ck.adventofcode.year2020.day07;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Solution(
    id = 20200702,
    name = "Day 7: Handy Haversacks - Part 2",
    url = "https://adventofcode.com/2020/day/7#part2",
    category = "2020")
public class Part2 {
  private static final Pattern startPattern = Pattern.compile("^([a-z]+ [a-z]+) bags contain");
  private static final Pattern containsPattern = Pattern.compile("([0-9]+) ([a-z]+ [a-z]+) bag");

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      Map<String, Set<InnerBag>> bags = new HashMap<>();
      while (in.hasNextLine()) {
        String line = in.nextLine();

        Matcher startMatcher = startPattern.matcher(line);
        startMatcher.find();

        String outerBag = startMatcher.group(1);
        bags.computeIfAbsent(outerBag, newBag -> new HashSet<>());

        Matcher containsMatcher = containsPattern.matcher(line);
        int start = 0;
        while (containsMatcher.find(start)) {
          int count = Integer.parseInt(containsMatcher.group(1));
          String innerBag = containsMatcher.group(2);
          bags.computeIfAbsent(innerBag, newBag -> new HashSet<>());

          bags.get(outerBag).add(new InnerBag(innerBag, count));

          start = containsMatcher.end();
        }
      }

      System.out.println(countInnerBags(bags, "shiny gold") - 1);
    }
  }

  private static int countInnerBags(Map<String, Set<InnerBag>> bags, String bag) {
    int count = 0;

    for (InnerBag innerBag : bags.get(bag)) {
      count += innerBag.getCount() * countInnerBags(bags, innerBag.getColour());
    }

    return count + 1;
  }

  public static class InnerBag {
    private final String colour;
    private final int count;

    public InnerBag(String colour, int count) {
      this.colour = colour;
      this.count = count;
    }

    public String getColour() {
      return colour;
    }

    public int getCount() {
      return count;
    }
  }
}
