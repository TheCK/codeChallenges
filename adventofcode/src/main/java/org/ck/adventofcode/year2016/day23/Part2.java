package org.ck.adventofcode.year2016.day23;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Solution(
    id = 20162302,
    name = "Day 23: Safe Cracking - Part 2",
    url = "https://adventofcode.com/2016/day/23",
    category = "2016")
public class Part2 {
  public static void main(String[] args) {
    List<Command> commands = new ArrayList<>();
    int a = 0;

    try (Scanner in = new Scanner(System.in)) {
      a = in.nextInt();
      in.nextLine();

      while (in.hasNextLine()) {
        commands.add(Command.of(in.nextLine()));
      }
    }

    int finalA = a;
    Map<String, Integer> registers =
        new HashMap<>() {
          {
            put("a", finalA);
            put("b", 0);
            put("c", 0);
            put("d", 0);
          }
        };

    int p = 0;
    while (p < commands.size()) {
      p += commands.get(p).run(registers, commands, p);
    }

    System.out.println(registers.get("a"));
  }

  private abstract static class Command {
    private static final Pattern pattern =
        Pattern.compile("([a-z]{3}) ([a-z]|-?\\d+)( (-?\\d+|[a-z]))?");

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
          case "tgl":
            return new Toggle(matcher);
        }
      }

      return null;
    }

    public abstract int run(Map<String, Integer> registers, List<Command> commands, final int p);

    public abstract Command toggle();
  }

  private static final class Increment extends Command {
    private final String register;

    public Increment(Matcher matcher) {
      register = matcher.group(2);
    }

    public Increment(String register) {
      this.register = register;
    }

    @Override
    public int run(final Map<String, Integer> registers, List<Command> commands, final int p) {
      registers.put(register, registers.get(register) + 1);

      return 1;
    }

    @Override
    public Command toggle() {
      return new Decrement(register);
    }
  }

  private static final class Decrement extends Command {
    private final String register;

    public Decrement(Matcher matcher) {
      register = matcher.group(2);
    }

    public Decrement(String register) {
      this.register = register;
    }

    @Override
    public int run(final Map<String, Integer> registers, List<Command> commands, final int p) {
      registers.put(register, registers.get(register) - 1);

      return 1;
    }

    @Override
    public Command toggle() {
      return new Increment(register);
    }
  }

  private static final class Toggle extends Command {
    private final String register;

    public Toggle(Matcher matcher) {
      register = matcher.group(2);
    }

    @Override
    public int run(final Map<String, Integer> registers, List<Command> commands, final int p) {
      int index = p + registers.get(register);

      if (index < commands.size()) {
        commands.set(index, commands.get(index).toggle());
      }

      return 1;
    }

    @Override
    public Command toggle() {
      return new Increment(register);
    }
  }

  private static final class Copy extends Command {
    private String firstRegister;
    private Integer firstIntermediate;

    private String secondRegister;
    private Integer secondIntermediate;

    public Copy(Matcher matcher) {
      try {
        firstRegister = null;
        firstIntermediate = Integer.parseInt(matcher.group(2));
      } catch (NumberFormatException e) {
        firstRegister = matcher.group(2);
        firstIntermediate = null;
      }

      secondRegister = matcher.group(4);
      secondIntermediate = null;
    }

    public Copy(
        String firstRegister,
        Integer firstIntermediate,
        String secondRegister,
        Integer secondIntermediate) {
      this.firstRegister = firstRegister;
      this.firstIntermediate = firstIntermediate;

      this.secondRegister = secondRegister;
      this.secondIntermediate = secondIntermediate;
    }

    @Override
    public int run(final Map<String, Integer> registers, List<Command> commands, final int p) {
      if (secondRegister != null) {
        registers.put(
            secondRegister,
            firstIntermediate != null ? firstIntermediate : registers.get(firstRegister));
      }

      return 1;
    }

    @Override
    public Command toggle() {
      return new Jump(firstRegister, firstIntermediate, secondRegister, secondIntermediate);
    }
  }

  private static final class Jump extends Command {
    private String firstRegister;
    private Integer firstIntermediate;

    private String secondRegister;
    private Integer secondIntermediate;

    public Jump(Matcher matcher) {
      try {
        firstRegister = null;
        firstIntermediate = Integer.parseInt(matcher.group(2));
      } catch (NumberFormatException e) {
        firstRegister = matcher.group(2);
        firstIntermediate = null;
      }

      try {
        secondRegister = null;
        secondIntermediate = Integer.parseInt(matcher.group(4));
      } catch (NumberFormatException e) {
        secondRegister = matcher.group(4);
        secondIntermediate = null;
      }
    }

    public Jump(
        String firstRegister,
        Integer firstIntermediate,
        String secondRegister,
        Integer secondIntermediate) {
      this.firstRegister = firstRegister;
      this.firstIntermediate = firstIntermediate;

      this.secondRegister = secondRegister;
      this.secondIntermediate = secondIntermediate;
    }

    @Override
    public int run(final Map<String, Integer> registers, List<Command> commands, final int p) {
      if ((firstIntermediate != null && firstIntermediate != 0)
          || (firstIntermediate == null && registers.get(firstRegister) != 0)) {
        return secondIntermediate != null ? secondIntermediate : registers.get(secondRegister);
      }

      return 1;
    }

    @Override
    public Command toggle() {
      return new Copy(firstRegister, firstIntermediate, secondRegister, secondIntermediate);
    }
  }
}
