package org.ck.adventofcode.year2016;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20161701,
    name = "Day 17: Two Steps Forward",
    url = "https://adventofcode.com/2016/day/17",
    category = "2016")
@Solution(
    id = 20161702,
    name = "Day 17: Two Steps Forward",
    url = "https://adventofcode.com/2016/day/17#part2",
    category = "2016")
public class Day17 extends AOCSolution {
  private static final Set<Character> OPEN_DOORS = Set.of('b', 'c', 'd', 'e', 'f');

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, false);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, true);
  }

  private void run(final Scanner in, final boolean collectAll) {
    final String passcode = in.nextLine();

    final Queue<State> queue = new PriorityQueue<>(Comparator.comparingInt(s -> s.path().length()));
    queue.add(new State(0, 0, ""));

    final List<State> paths = new ArrayList<>();
    final MessageDigest md = getMd5();

    while (!queue.isEmpty()) {
      final State state = queue.poll();

      if (state.x() == 3 && state.y() == 3) {
        if (collectAll) {
          paths.add(state);
          continue;
        } else {
          print(state.path());
          break;
        }
      }

      md.update((passcode + state.path()).getBytes());
      final String hex = HexFormat.of().formatHex(md.digest());

      if (state.y > 0 && OPEN_DOORS.contains(hex.charAt(0))) {
        queue.add(new State(state.x(), state.y() - 1, state.path() + "U"));
      }

      if (state.y < 3 && OPEN_DOORS.contains(hex.charAt(1))) {
        queue.add(new State(state.x(), state.y() + 1, state.path() + "D"));
      }

      if (state.x > 0 && OPEN_DOORS.contains(hex.charAt(2))) {
        queue.add(new State(state.x() - 1, state.y(), state.path() + "L"));
      }

      if (state.x < 3 && OPEN_DOORS.contains(hex.charAt(3))) {
        queue.add(new State(state.x() + 1, state.y(), state.path() + "R"));
      }
    }

    if (collectAll) {
      print(
          paths.stream()
              .max(Comparator.comparingInt(s -> s.path().length()))
              .orElseThrow()
              .path()
              .length());
    }
  }

  private static MessageDigest getMd5() {
    try {
      return MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      throw new IllegalStateException(e);
    }
  }

  private record State(int x, int y, String path) {}
}
