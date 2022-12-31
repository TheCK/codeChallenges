package org.ck.adventofcode.year2020.day07;

import org.ck.codechallengelib.annotation.Solution;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Solution(
    id = 20200701,
    name = "Day 7: Handy Haversacks",
    url = "https://adventofcode.com/2020/day/7",
    category = "2020")
public class Part1 {
  private static final Pattern startPattern = Pattern.compile("^([a-z]+ [a-z]+) bags contain");
  private static final Pattern containsPattern = Pattern.compile("([0-9]+) ([a-z]+ [a-z]+) bag");

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      Map<String, Set<String>> bags = new HashMap<>();
      while (in.hasNextLine()) {
        String line = in.nextLine();

        Matcher startMatcher = startPattern.matcher(line);
        startMatcher.find();

        String outerBag = startMatcher.group(1);
        bags.computeIfAbsent(outerBag, newBag -> new HashSet<>());

        Matcher containsMatcher = containsPattern.matcher(line);
        int start = 0;
        while (containsMatcher.find(start)) {
          String innerBag = containsMatcher.group(2);
          bags.computeIfAbsent(innerBag, newBag -> new HashSet<>());

          bags.get(innerBag).add(outerBag);

          start = containsMatcher.end();
        }
      }

      Set<String> possibleBags = new HashSet<>();
      fillPossibleBags(bags, possibleBags, "shiny gold");
      System.out.println(possibleBags.size());
    }
  }

  private static void fillPossibleBags(
      Map<String, Set<String>> bags, Set<String> possibleBags, String bag) {
    for (String outerBag : bags.get(bag)) {
      possibleBags.add(outerBag);
      fillPossibleBags(bags, possibleBags, outerBag);
    }
  }
}
