package org.ck.adventofcode.year2022.day05;

import org.ck.codechallengelib.annotation.Solution;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Solution(
    id = 20220501,
    name = "Day 5: Supply Stacks",
    url = "https://adventofcode.com/2022/day/5",
    category = "2022")
public class Part1 {
  private static final Pattern COMMAND_PATTERN =
      Pattern.compile("move (\\d+) from (\\d+) to (\\d+)");

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      List<String> inputsLines = new ArrayList<>();

      String line = in.nextLine();
      while (!line.isEmpty()) {
        inputsLines.add(line);

        line = in.nextLine();
      }

      int numberOfStacks = inputsLines.get(inputsLines.size() - 1).trim().split("\\s+").length;

      List<Deque<Character>> stacks = new ArrayList<>();
      for (int i = 0; i < numberOfStacks; ++i) {
        stacks.add(new ArrayDeque<>());
      }

      for (int i = inputsLines.size() - 2; i >= 0; --i) {
        for (int stack = 0; stack < numberOfStacks; ++stack) {
          if ((stack * 4 + 1) < inputsLines.get(i).length()
              && inputsLines.get(i).charAt(stack * 4 + 1) != ' ') {
            stacks.get(stack).push(inputsLines.get(i).charAt(stack * 4 + 1));
          }
        }
      }

      while (in.hasNextLine()) {
        String command = in.nextLine();
        Matcher matcher = COMMAND_PATTERN.matcher(command);

        if (matcher.find()) {
          int count = Integer.parseInt(matcher.group(1));
          int from = Integer.parseInt(matcher.group(2)) - 1;
          int to = Integer.parseInt(matcher.group(3)) - 1;

          for (int i = 0; i < count; ++i) {
            stacks.get(to).push(stacks.get(from).pop());
          }
        }
      }

      StringBuilder builder = new StringBuilder();
      for (Deque<Character> stack : stacks) {
        builder.append(stack.pop());
      }
      System.out.println(builder);
    }
  }
}
