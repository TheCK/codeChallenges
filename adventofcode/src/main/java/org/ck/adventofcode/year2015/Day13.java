package org.ck.adventofcode.year2015;

import java.util.*;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20151301,
    name = "Day 13: Knights of the Dinner Table",
    url = "https://adventofcode.com/2015/day/13",
    category = "2015")
@Solution(
    id = 20151302,
    name = "Day 13: Knights of the Dinner Table - Part 2",
    url = "https://adventofcode.com/2015/day/13#part2",
    category = "2015")
public class Day13 extends AOCSolution {
  private static final Pattern PATTERN =
      Pattern.compile(
          "(?<first>[a-zA-Z]+) would (?<gain>gain|lose) (?<happiness>\\d+) happiness units by sitting next to (?<other>[a-zA-Z]+).");

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, likes -> {});
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        likes -> {
          final Set<String> attendees = new HashSet<>(likes.keySet());

          likes.put("me", new HashMap<>());
          for (String attendee : attendees) {
            likes.get(attendee).put("me", 0);
            likes.get("me").put(attendee, 0);
          }
        });
  }

  private void run(
      final Scanner in, final Consumer<Map<String, Map<String, Integer>>> initializer) {
    final Map<String, Map<String, Integer>> likes = new HashMap<>();

    while (in.hasNextLine()) {
      final String line = in.nextLine();

      final Matcher matcher = PATTERN.matcher(line);

      if (matcher.find()) {
        likes.computeIfAbsent(matcher.group("first"), key -> new HashMap<>());
        likes
            .get(matcher.group("first"))
            .put(
                matcher.group("other"),
                ("gain".equals(matcher.group("gain")) ? 1 : -1)
                    * Integer.parseInt(matcher.group("happiness")));
      }
    }

    initializer.accept(likes);

    int max = 0;

    for (List<String> permutation : getPermutation(new ArrayList<>(likes.keySet()))) {
      int current = 0;

      for (int i = 0; i < permutation.size(); ++i) {
        current += likes.get(permutation.get(i)).get(permutation.get((i + 1) % permutation.size()));
        current += likes.get(permutation.get((i + 1) % permutation.size())).get(permutation.get(i));
      }

      max = Math.max(current, max);
    }

    print(max);
  }

  private static List<List<String>> getPermutation(final List<String> people) {
    if (people.size() == 1) {
      return List.of(List.of(people.get(0)));
    }

    final List<List<String>> permutations = new ArrayList<>();

    for (String person : people) {
      final List<String> newPeople = new ArrayList<>(people);
      newPeople.remove(person);

      final List<List<String>> furtherPermutations = getPermutation(newPeople);

      for (final List<String> furtherPermutation : furtherPermutations) {
        final List<String> perms = new ArrayList<>();
        perms.add(person);
        perms.addAll(furtherPermutation);

        permutations.add(perms);
      }
    }

    return permutations;
  }
}
