package org.ck.adventofcode.year2015.day23;

import java.util.*;
import java.util.regex.Pattern;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20152301,
    name = "Day 23: Opening the Turing Lock",
    url = "https://adventofcode.com/2015/day/23",
    category = "2015")
public class Part1 {
  private static final Pattern pattern = Pattern.compile("([a-z]{3}) (([a-z]),?)? ([+-]\\d)");

  public static void main(String[] args) throws Exception {
    List<Command> commands = new ArrayList<>();

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String line = in.nextLine();

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
    }

    int pointer = 0;

    Map<String, Integer> registers = new HashMap<>();
    registers.put("a", 0);
    registers.put("b", 0);

    while (pointer < commands.size()) {
      Command command = commands.get(pointer);

      switch (command.name()) {
        case "hlf":
          registers.compute(command.register(), (key, value) -> value / 2);
          ++pointer;
          break;
        case "tpl":
          registers.compute(command.register(), (key, value) -> value * 3);
          ++pointer;
          break;
        case "inc":
          registers.compute(command.register(), (key, value) -> value + 1);
          ++pointer;
          break;
        case "jmp":
          pointer += command.intermediate();
          break;
        case "jie":
          if (registers.get(command.register()) % 2 == 0) {
            pointer += command.intermediate();
          } else {
            ++pointer;
          }
          break;
        case "jio":
          if (registers.get(command.register()) == 1) {
            pointer += command.intermediate();
          } else {
            ++pointer;
          }
          break;
      }
    }

    System.out.println(registers.get("b"));
  }

  private record Command(String name, String register, int intermediate) {}
}
