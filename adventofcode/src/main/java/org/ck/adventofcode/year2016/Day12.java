package org.ck.adventofcode.year2016;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20161201,
    name = "Day 12: Leonardo's Monorail",
    url = "https://adventofcode.com/2016/day/12",
    category = "2016")
@Solution(
    id = 20161202,
    name = "Day 12: Leonardo's Monorail - Part 2",
    url = "https://adventofcode.com/2016/day/12#part2",
    category = "2016")
public class Day12 extends AOCSolution {
  @Override
  protected void runPartOne(final Scanner in) {
    run(in, 0);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, 1);
  }

  private void run(final Scanner in, final int registerC) {
    final List<Command> commands = new ArrayList<>();

    while (in.hasNextLine()) {
      commands.add(Command.of(in.nextLine()));
    }

    final Map<String, Integer> registers = new HashMap<>();
    registers.put("a", 0);
    registers.put("b", 0);
    registers.put("c", registerC);
    registers.put("d", 0);

    int p = 0;
    while (p < commands.size()) {
      p += commands.get(p).run(registers);
    }

    print(registers.get("a"));
  }

  private abstract static class Command {
    private static final Pattern pattern =
        Pattern.compile("([a-z]{3}) ([a-z]|\\d+)( (-?\\d|[a-z]))?");

    public static Command of(String line) {
      final Matcher matcher = pattern.matcher(line);

      if (matcher.find()) {
        String command = matcher.group(1);

        switch (command) {
          case "cpy":
            return new Copy(matcher);
          case "inc":
            return new Increment(matcher);
          case "dec":
            return new Decrement(matcher);
          case "jnz":
            return new Jump(matcher);
          default:
            throw new IllegalArgumentException("Unknown command: " + command);
        }
      }

      return null;
    }

    public abstract int run(Map<String, Integer> registers);
  }

  private static final class Copy extends Command {
    private String copyFrom;
    private Integer value;
    private String copyTo;

    public Copy(Matcher matcher) {
      try {
        value = Integer.valueOf(matcher.group(2));
      } catch (NumberFormatException e) {
        copyFrom = matcher.group(2);
      }

      copyTo = matcher.group(4);
    }

    @Override
    public int run(final Map<String, Integer> registers) {
      registers.put(copyTo, value != null ? value : registers.get(copyFrom));

      return 1;
    }
  }

  private static final class Increment extends Command {
    private String register;

    public Increment(Matcher matcher) {
      register = matcher.group(2);
    }

    @Override
    public int run(final Map<String, Integer> registers) {
      registers.put(register, registers.get(register) + 1);

      return 1;
    }
  }

  private static final class Decrement extends Command {
    private String register;

    public Decrement(Matcher matcher) {
      register = matcher.group(2);
    }

    @Override
    public int run(final Map<String, Integer> registers) {
      registers.put(register, registers.get(register) - 1);

      return 1;
    }
  }

  private static final class Jump extends Command {
    private String register;
    private Integer value;
    private Integer distance;

    public Jump(Matcher matcher) {
      try {
        value = Integer.valueOf(matcher.group(2));
      } catch (NumberFormatException e) {
        register = matcher.group(2);
      }

      distance = Integer.valueOf(matcher.group(4));
    }

    @Override
    public int run(final Map<String, Integer> registers) {
      if ((value != null && value != 0) || (value == null && registers.get(register) != 0)) {
        return distance;
      }

      return 1;
    }
  }
}
