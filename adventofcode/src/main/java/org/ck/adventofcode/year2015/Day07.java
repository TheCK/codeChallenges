package org.ck.adventofcode.year2015;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.ToIntFunction;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20150701,
    name = "Day 7: Some Assembly Required",
    url = "https://adventofcode.com/2015/day/7",
    category = "2015")
@Solution(
    id = 20150702,
    name = "Day 7: Some Assembly Required - Part 2",
    url = "https://adventofcode.com/2015/day/7#part2",
    category = "2015")
public class Day07 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, commands -> calculate(commands, "a"));
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        commands -> {
          final int a = calculate(new HashMap<>(commands), "a");
          commands.put("b", String.valueOf(a));

          return calculate(commands, "a");
        });
  }

  private void run(final Scanner in, final ToIntFunction<Map<String, String>> printer) {
    final Map<String, String> commands = new HashMap<>();

    while (in.hasNextLine()) {
      final String[] split = in.nextLine().split(" -> ");
      commands.put(split[1], split[0]);
    }

    print(printer.applyAsInt(commands));
  }

  private static int calculate(final Map<String, String> commands, final String wire) {
    try {
      return Integer.parseInt(wire);
    } catch (NumberFormatException e) {
      // ignore
    }

    final String command = commands.get(wire);
    final String[] split = command.split(" ");

    if (command.contains("OR")) {
      final int a = calculate(commands, split[0]);
      commands.put(split[0], String.valueOf(a));
      final int b = calculate(commands, split[2]);
      commands.put(split[2], String.valueOf(b));

      return a | b;
    } else if (command.contains("AND")) {
      final int a = calculate(commands, split[0]);
      commands.put(split[0], String.valueOf(a));
      final int b = calculate(commands, split[2]);
      commands.put(split[2], String.valueOf(b));

      return a & b;
    } else if (command.contains("NOT")) {
      final int a = calculate(commands, split[1]);
      commands.put(split[1], String.valueOf(a));

      return (~a) & 0xFFFF;
    } else if (command.contains("LSHIFT")) {
      final int a = calculate(commands, split[0]);
      commands.put(split[0], String.valueOf(a));

      return (a << Integer.parseInt(split[2])) & 0xFFFF;
    } else if (command.contains("RSHIFT")) {
      final int a = calculate(commands, split[0]);
      commands.put(split[0], String.valueOf(a));

      return (a >> Integer.parseInt(split[2])) & 0xFFFF;
    }

    return calculate(commands, split[0]);
  }
}
