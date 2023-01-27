package org.ck.adventofcode.year2016.day25;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20162501,
    name = "Day 25: Clock Signal",
    url = "https://adventofcode.com/2016/day/25",
    category = "2016")
public class Part1 {
  public static void main(String[] args) {
    List<Command> commands = new ArrayList<>();

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        commands.add(Command.of(in.nextLine()));
      }
    }

    int a = 0;
    while (true) {
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

      List<Integer> output = new ArrayList<>();

      int p = 0;
      int steps = 0;
      while (p < commands.size() && output.size() < 100 && steps < 1000000) {
        p += commands.get(p).run(registers, commands, p, output);
        ++steps;
      }

      if (output.size() == 100) {
        boolean matches = true;

        for (int i = 0; i < 100; ++i) {
          if (output.get(i) != i % 2) {
            matches = false;
            break;
          }
        }

        if (matches) {
          break;
        }
      }

      ++a;
    }

    System.out.println(a);
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
          case "out":
            return new Output(matcher);
        }
      }

      return null;
    }

    public abstract int run(
        Map<String, Integer> registers,
        List<Command> commands,
        final int p,
        final List<Integer> output);

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
    public int run(
        final Map<String, Integer> registers,
        List<Command> commands,
        final int p,
        final List<Integer> output) {
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
    public int run(
        final Map<String, Integer> registers,
        List<Command> commands,
        final int p,
        final List<Integer> output) {
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
    public int run(
        final Map<String, Integer> registers,
        List<Command> commands,
        final int p,
        final List<Integer> output) {
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

  private static final class Output extends Command {
    private final String register;

    public Output(Matcher matcher) {
      register = matcher.group(2);
    }

    @Override
    public int run(
        final Map<String, Integer> registers,
        List<Command> commands,
        final int p,
        final List<Integer> output) {
      output.add(registers.get(register));
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
        firstIntermediate = Integer.valueOf(matcher.group(2));
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
    public int run(
        final Map<String, Integer> registers,
        List<Command> commands,
        final int p,
        final List<Integer> output) {
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
        firstIntermediate = Integer.valueOf(matcher.group(2));
      } catch (NumberFormatException e) {
        firstRegister = matcher.group(2);
        firstIntermediate = null;
      }

      try {
        secondRegister = null;
        secondIntermediate = Integer.valueOf(matcher.group(4));
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
    public int run(
        final Map<String, Integer> registers,
        List<Command> commands,
        final int p,
        final List<Integer> output) {
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
