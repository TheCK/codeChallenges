package org.ck.adventofcode.year2021.day23;

import org.ck.codechallengelib.annotation.Solution;

import java.util.*;

@Solution(
    id = 20212302,
    name = "Day 23: Amphipod - Part 2",
    url = "https://adventofcode.com/2021/day/23#part2",
    category = "2021")
public class Part2 {
  private static final Map<String, Integer> costs =
          new HashMap<>() {
            {
              put("A", 1);
              put("B", 10);
              put("C", 100);
              put("D", 1000);
            }
          };

  private static Map<Character, Integer> offsets =
          new HashMap<>() {
            {
              put('a', 3);
              put('b', 5);
              put('c', 7);
              put('d', 9);
            }
          };

  public static void main(String[] args) {
    Map<String, String> net = new HashMap<>();
    net.put("h1", "");
    net.put("h2", "");
    net.put("h4", "");
    net.put("h6", "");
    net.put("h8", "");
    net.put("h10", "");
    net.put("h11", "");

    try (Scanner in = new Scanner(System.in)) {
      in.nextLine();
      in.nextLine();

      int level = 1;
      while (true) {
        String[] line = in.nextLine().split("");

        if (!in.hasNextLine()) {
          break;
        }

        net.put("a" + level, line[3]);
        net.put("b" + level, line[5]);
        net.put("c" + level, line[7]);
        net.put("d" + level, line[9]);

        ++level;
      }
    }

    Queue<State> queue = new PriorityQueue<>(Comparator.comparingLong(State::cost));
    queue.add(new State(net, 0, null));

    long best = Long.MAX_VALUE;
    Map<String, Long> cache = new HashMap<>();
    while (!queue.isEmpty()) {
      State current = queue.remove();
      if (current.cost >= best) {
        break;
      }

      for (Map.Entry<String, String> source : current.net.entrySet()) {
        if (!source.getValue().equals("") && canMoveFrom(current.net, source)) {
          for (Map.Entry<String, String> target : current.net.entrySet()) {
            if (target.getValue().equals("") && canMoveTo(current.net, source, target)) {
              String pod = source.getValue();

              Map<String, String> newNet = new HashMap<>(current.net);
              newNet.put(target.getKey(), pod);
              newNet.put(source.getKey(), "");

              State newState =
                      new State(
                              newNet,
                              current.cost
                                      + (long) getSteps(source.getKey(), target.getKey()) * costs.get(pod), current);

              if (newState.isFinished()) {
                best = Math.min(best, newState.cost);
              } else {
                String state = newState.toString();
                if (newState.cost < cache.getOrDefault(state, Long.MAX_VALUE) && newState.cost < best) {
                  cache.put(state, newState.cost);
                  queue.add(newState);
                }
              }
            }
          }
        }
      }
    }
    System.out.println(best);
  }

  private static int getSteps(String source, String target) {
    int hallwayFrom =
            source.charAt(0) == 'h'
                    ? Integer.parseInt(source.substring(1))
                    : offsets.get(source.charAt(0));
    int hallwayTo =
            target.charAt(0) == 'h'
                    ? Integer.parseInt(target.substring(1))
                    : offsets.get(target.charAt(0));

    return Math.abs(hallwayFrom - hallwayTo)
            + (source.charAt(0) == 'h' ? 0 : source.charAt(1) - '0')
            + (target.charAt(0) == 'h' ? 0 : target.charAt(1) - '0');
  }

  private static boolean canMoveFrom(
          final Map<String, String> net, final Map.Entry<String, String> source) {
    if (source.getKey().charAt(0) == 'h') {
      return true;
    }

    if (!source.getKey().startsWith(source.getValue().toLowerCase(Locale.ROOT))) {
      return true;
    }

    int level = source.getKey().charAt(1) - '0';

    while (net.containsKey("" + source.getKey().charAt(0) + level)) {
      if (!net.get("" + source.getKey().charAt(0) + level).startsWith(source.getValue().toLowerCase(Locale.ROOT))) {
        return true;
      }

      ++level;
    }

    return false;
  }

  private static boolean canMoveTo(
          final Map<String, String> net,
          final Map.Entry<String, String> source,
          final Map.Entry<String, String> target) {
    if (source.getKey().charAt(0) == target.getKey().charAt(0)) {
      return false;
    }

    if (!target.getKey().substring(0, 1).equals(source.getValue().toLowerCase(Locale.ROOT))
            && !target.getKey().contains("h")) {
      return false;
    }

    if ((source.getKey().charAt(0) == 'h' || canMoveUp(net, source.getKey()))
            && (target.getKey().charAt(0) == 'h' || canMoveUp(net, target.getKey()))) {
      int hallwayFrom =
              source.getKey().charAt(0) == 'h'
                      ? Integer.parseInt(source.getKey().substring(1))
                      : offsets.get(source.getKey().charAt(0));
      int hallwayTo =
              target.getKey().charAt(0) == 'h'
                      ? Integer.parseInt(target.getKey().substring(1))
                      : offsets.get(target.getKey().charAt(0));

      for (int i = Math.min(hallwayFrom, hallwayTo) + 1;
           i < Math.max(hallwayFrom, hallwayTo);
           ++i) {
        if (net.containsKey("h" + i) && !net.get("h" + i).equals("")) {
          return false;
        }
      }

      if (!target.getKey().contains("h")) {
        for (int i = target.getKey().charAt(1) - '0' + 1; net.containsKey("" + target.getKey().charAt(0) + i); ++i) {
          if (!net.get("" + target.getKey().charAt(0) + i).toLowerCase(Locale.ROOT).equals("" + target.getKey().charAt(0))) {
            return false;
          }
        }
      }

      return true;
    }

    return false;
  }

  private static boolean canMoveUp(final Map<String, String> net, final String field) {
    int level = field.charAt(1) - '0' - 1;

    while (level != 0) {
      if (!net.get("" + field.charAt(0) + level).equals("")) {
        return false;
      }

      --level;
    }

    return true;
  }

  private record State(Map<String, String> net, long cost, State old) {
    public boolean isFinished() {
      for (Map.Entry<String, String> entry: net.entrySet()) {
        if (!entry.getValue().equals("") && !entry.getKey().startsWith(entry.getValue().toLowerCase(Locale.ROOT))) {
          return false;
        }


      }

      return true;
    }

    @Override
    public String toString() {
      StringBuilder builder = new StringBuilder();

      List<String> keys = new ArrayList<>(net.keySet());
      Collections.sort(keys);

      for (String key: keys) {
        builder.append(net.get(key).equals("") ? "." : net.get(key));
      }

      return builder.toString();
    }
  }
}
