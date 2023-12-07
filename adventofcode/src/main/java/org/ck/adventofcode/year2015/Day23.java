package org.ck.adventofcode.year2015;

import java.util.*;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20152301,
    name = "Day 23: Opening the Turing Lock",
    url = "https://adventofcode.com/2015/day/23",
    category = "2015")
@Solution(
    id = 20152302,
    name = "Day 23: Opening the Turing Lock - Part 2",
    url = "https://adventofcode.com/2015/day/23#part2",
    category = "2015")
public class Day23 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, 0);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, 1);
  }

  private void run(final Scanner in, final int aStart) {
    final List<Command> commands = getCommands(in);

    int pointer = 0;

    final Map<String, Integer> registers = new HashMap<>();
    registers.put("a", aStart);
    registers.put("b", 0);

    while (pointer < commands.size()) {
      Command command = commands.get(pointer);

      switch (command.name()) {
        case "hlf" -> {
          registers.compute(command.register(), (key, value) -> value / 2);
          ++pointer;
        }
        case "tpl" -> {
          registers.compute(command.register(), (key, value) -> value * 3);
          ++pointer;
        }
        case "inc" -> {
          registers.compute(command.register(), (key, value) -> value + 1);
          ++pointer;
        }
        case "jmp" -> pointer += command.intermediate();
        case "jie" -> {
          if (registers.get(command.register()) % 2 == 0) {
            pointer += command.intermediate();
          } else {
            ++pointer;
          }
        }
        case "jio" -> {
          if (registers.get(command.register()) == 1) {
            pointer += command.intermediate();
          } else {
            ++pointer;
          }
        }
        default -> throw new IllegalStateException("Unexpected value: " + command.name());
      }
    }

    print(registers.get("b"));
  }

  private static List<Command> getCommands(final Scanner in) {
    final List<Command> commands = new ArrayList<>();

    while (in.hasNextLine()) {
      final String line = in.nextLine();

      final String[] split1 = line.split(", ");
      final String[] split2 = split1[0].split(" ");

      int intermediate = 0;
      String register = "";

      if (split1.length > 1) {
        intermediate = Integer.parseInt(split1[1]);
        register = split2[1];
      } else {
        try {
          intermediate = Integer.parseInt(split2[1]);
        } catch (NumberFormatException e) {
          register = split2[1];
        }
      }

      commands.add(new Command(split2[0], register, intermediate));
    }
    return commands;
  }

  private record Command(String name, String register, int intermediate) {}
}
