package org.ck.adventofcode.year2024;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20242301,
    name = "Day 23: LAN Party",
    url = "https://adventofcode.com/2024/day/23",
    category = "2024")
@Solution(
    id = 20242302,
    name = "Day 23: LAN Party - Part 2",
    url = "https://adventofcode.com/2024/day/23#part2",
    category = "2024")
public class Day23 extends AOCSolution {

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, Day23::getGroupsOfThree);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, Day23::getLargestGroup);
  }

  private void run(final Scanner in, final Function<Map<String, Set<String>>, String> getResult) {
    final Map<String, Set<String>> reachable = new HashMap<>();

    while (in.hasNextLine()) {
      final String[] names = in.nextLine().split("-");

      reachable.computeIfAbsent(names[0], k -> new HashSet<>()).add(names[1]);
      reachable.computeIfAbsent(names[1], k -> new HashSet<>()).add(names[0]);
    }

    print(getResult.apply(reachable));
  }

  private static String getGroupsOfThree(Map<String, Set<String>> reachable) {
    final Set<String> tNames =
        reachable.keySet().stream()
            .filter(name -> name.startsWith("t"))
            .collect(Collectors.toSet());

    final Set<Set<String>> networks = new HashSet<>();

    for (String tName : tNames) {
      for (String second : reachable.get(tName)) {
        for (String third : reachable.get(tName)) {
          if (reachable.get(second).contains(third)) {
            networks.add(Set.of(tName, second, third));
          }
        }
      }
    }

    return String.valueOf(networks.size());
  }

  private static String getLargestGroup(Map<String, Set<String>> reachable) {
    Set<String> largestNetwork = new HashSet<>();

    for (String tName : reachable.keySet()) {
      Set<String> network = new HashSet<>();
      network.add(tName);

      for (String second : reachable.get(tName)) {
        for (String third : reachable.get(tName)) {
          if (second.equals(third)) {
            continue;
          }

          if (reachable.get(second).contains(third)) {
            network.add(second);
            network.add(third);
          }
        }
      }

      final Iterator<String> iterator = network.iterator();
      while (iterator.hasNext()) {
        final String name = iterator.next();

        for (String other : network) {
          if (name.equals(other)) {
            continue;
          }

          if (!reachable.get(other).contains(name)) {
            iterator.remove();
            break;
          }
        }
      }

      if (network.size() > largestNetwork.size()) {
        largestNetwork = network;
      }
    }

    return largestNetwork.stream().sorted().collect(Collectors.joining(","));
  }
}
