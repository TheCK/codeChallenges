package org.ck.adventofcode.year2016.day17;

import java.security.MessageDigest;
import java.util.*;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20161702,
    name = "Day 17: Two Steps Forward",
    url = "https://adventofcode.com/2016/day/17#part2",
    category = "2016")
public class Part2 {
  private static final Set<Character> open =
      new HashSet<>() {
        {
          add('b');
          add('c');
          add('d');
          add('e');
          add('f');
        }
      };

  public static void main(String[] args) throws Exception {
    try (Scanner in = new Scanner(System.in)) {
      String passcode = in.nextLine();

      Queue<State> queue = new PriorityQueue<>(Comparator.comparingInt(s -> s.path().length()));
      queue.add(new State(0, 0, ""));

      List<State> paths = new ArrayList<>();

      while (!queue.isEmpty()) {
        State state = queue.poll();

        if (state.x() == 3 && state.y() == 3) {
          paths.add(state);
          continue;
        }

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update((passcode + state.path()).getBytes());
        String hex = HexFormat.of().formatHex(md.digest());

        if (state.y > 0 && open.contains(hex.charAt(0))) {
          queue.add(new State(state.x(), state.y() - 1, state.path() + "U"));
        }

        if (state.y < 3 && open.contains(hex.charAt(1))) {
          queue.add(new State(state.x(), state.y() + 1, state.path() + "D"));
        }

        if (state.x > 0 && open.contains(hex.charAt(2))) {
          queue.add(new State(state.x() - 1, state.y(), state.path() + "L"));
        }

        if (state.x < 3 && open.contains(hex.charAt(3))) {
          queue.add(new State(state.x() + 1, state.y(), state.path() + "R"));
        }
      }

      System.out.println(
          paths.stream()
              .max(Comparator.comparingInt(s -> s.path().length()))
              .get()
              .path()
              .length());
    }
  }

  private record State(int x, int y, String path) {}
}
