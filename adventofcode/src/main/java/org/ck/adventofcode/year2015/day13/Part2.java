package org.ck.adventofcode.year2015.day13;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Solution(
    id = 20151302,
    name = "Day 13: Knights of the Dinner Table - Part 2",
    url = "https://adventofcode.com/2015/day/13#part2",
    category = "2015")
public class Part2 {
  private static final Pattern pattern =
      Pattern.compile(
          "([a-zA-Z]+) would (gain|lose) (\\d+) happiness units by sitting next to ([a-zA-Z]+).");

  public static void main(String[] args) throws Exception {
    Map<String, Map<String, Integer>> likes = new HashMap<>();

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String line = in.nextLine();

        final Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
          likes.computeIfAbsent(matcher.group(1), (key) -> new HashMap<>());
          likes
              .get(matcher.group(1))
              .put(
                  matcher.group(4),
                  ("gain".equals(matcher.group(2)) ? 1 : -1) * Integer.parseInt(matcher.group(3)));
        }
      }
    }

    Set<String> attendees = new HashSet<>(likes.keySet());

    likes.put("me", new HashMap<>());
    for (String attendee : attendees) {
      likes.get(attendee).put("me", 0);
      likes.get("me").put(attendee, 0);
    }

    int max = 0;

    for (List<String> permutation : getPermutation(new ArrayList<>(likes.keySet()))) {
      int current = 0;

      for (int i = 0; i < permutation.size(); ++i) {
        current += likes.get(permutation.get(i)).get(permutation.get((i + 1) % permutation.size()));
        current += likes.get(permutation.get((i + 1) % permutation.size())).get(permutation.get(i));
      }

      max = Math.max(current, max);
    }

    System.out.println(max);
  }

  private static List<List<String>> getPermutation(List<String> people) {
    if (people.size() == 1) {
      return List.of(List.of(people.get(0)));
    }

    List<List<String>> permuations = new ArrayList<>();

    for (String person : people) {
      List<String> newPeople = new ArrayList<>(people);
      newPeople.remove(person);

      List<List<String>> furtherPermuations = getPermutation(newPeople);

      for (List<String> furtherPermutation : furtherPermuations) {
        List<String> perms = new ArrayList<>();
        perms.add(person);
        perms.addAll(furtherPermutation);

        permuations.add(perms);
      }
    }

    return permuations;
  }
}
