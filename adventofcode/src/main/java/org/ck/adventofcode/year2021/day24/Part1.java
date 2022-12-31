package org.ck.adventofcode.year2021.day24;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20212401,
    name = "Day 24: Arithmetic Logic Unit",
    url = "https://adventofcode.com/2021/day/24",
    category = "2021")
public class Part1 {
  private static final Pattern commandPatter =
      Pattern.compile("([a-z]{3}) ([a-z]) ?([a-z]|[-0-9]+)?");

  public static void main(String[] args) {
    Queue<String> commands = new ArrayDeque<>();

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        commands.add(in.nextLine());
      }
    }

    int[] number = new int[] {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9};

    Stack<State> stack = new Stack<>();
    int pos = 0;
    while (true) {
      while (!commands.peek().startsWith("inp")) {
        commands.remove();

        if (commands.isEmpty()) {
          break;
        }
      }

      if (commands.isEmpty()) {
        break;
      }

      for (int i = 0; i < 4; ++i) {
        commands.remove();
      }

      final Matcher pushMatcher = commandPatter.matcher(commands.remove());
      pushMatcher.find();
      int push = Integer.parseInt(pushMatcher.group(3));
      final Matcher compareMatcher = commandPatter.matcher(commands.remove());
      compareMatcher.find();
      int compare = Integer.parseInt(compareMatcher.group(3));

      for (int i = 0; i < 9; ++i) {
        commands.remove();
      }

      final Matcher addMatcher = commandPatter.matcher(commands.remove());
      addMatcher.find();
      int add = Integer.parseInt(addMatcher.group(3));

      if (push == 1) {
        stack.push(new State(pos, add));
      } else {
        State state = stack.pop();

        number[pos] = number[state.position] + state.value + compare;

        if (number[pos] > 9) {
          number[state.position] -= number[pos] - 9;
          number[pos] = 9;
        }
        if (number[pos] < 1) {
          number[state.position] += 1 - number[pos];
          number[pos] = 1;
        }
      }

      ++pos;
    }

    System.out.println(
        Arrays.stream(number).mapToObj(String::valueOf).collect(Collectors.joining()));
  }

  private record State(int position, int value) {}
}
