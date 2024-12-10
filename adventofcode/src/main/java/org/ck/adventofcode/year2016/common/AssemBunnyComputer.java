package org.ck.adventofcode.year2016.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AssemBunnyComputer {

  private final List<Command> commands = new ArrayList<>();
  private final Map<String, Integer> registers = new HashMap<>();

  public AssemBunnyComputer(
      final List<String> initialCommands, final Map<String, Integer> initialRegisters) {
    this.commands.addAll(initialCommands.stream().map(Command::of).toList());
    this.registers.putAll(initialRegisters);
  }

  public void run() {
    runWithWantedOutput(Integer.MAX_VALUE, Integer.MAX_VALUE);
  }

  public List<Integer> runWithWantedOutput(final int wantedOutput, final int maxSteps) {
    final List<Integer> output = new ArrayList<>();

    int p = 0;
    while (p < commands.size() && p < maxSteps && output.size() < wantedOutput) {
      p += commands.get(p).run(registers, commands, p, output);
    }

    return output;
  }

  public int getRegisterValue(final String register) {
    return registers.get(register);
  }

  private abstract static class Command {
    private static final Pattern COMMAND_PATTERN =
        Pattern.compile(
            "(?<command>[a-z]{3}) (?<firstOperand>[a-z]|-?\\d+)( (?<secondOperand>-?\\d+|[a-z]))?");

    public static Command of(final String line) {
      final Matcher matcher = COMMAND_PATTERN.matcher(line);

      if (matcher.find()) {
        return switch (matcher.group("command")) {
          case "cpy" -> new Copy(matcher);
          case "inc" -> new Increment(matcher);
          case "dec" -> new Decrement(matcher);
          case "jnz" -> new Jump(matcher);
          case "tgl" -> new Toggle(matcher);
          case "out" -> new Output(matcher);
          default -> null;
        };
      }

      return null;
    }

    public abstract int run(
        final Map<String, Integer> registers,
        final List<Command> commands,
        final int p,
        final List<Integer> output);

    public abstract Command toggle();
  }

  private static final class Increment extends Command {
    private final String register;

    public Increment(final Matcher matcher) {
      register = matcher.group("firstOperand");
    }

    public Increment(final String register) {
      this.register = register;
    }

    @Override
    public int run(
        final Map<String, Integer> registers,
        final List<Command> commands,
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

    public Decrement(final Matcher matcher) {
      register = matcher.group("firstOperand");
    }

    public Decrement(final String register) {
      this.register = register;
    }

    @Override
    public int run(
        final Map<String, Integer> registers,
        final List<Command> commands,
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

    public Toggle(final Matcher matcher) {
      register = matcher.group("firstOperand");
    }

    @Override
    public int run(
        final Map<String, Integer> registers,
        final List<Command> commands,
        final int p,
        final List<Integer> output) {
      final int index = p + registers.get(register);

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
      register = matcher.group("firstOperand");
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

    private final String secondRegister;
    private final Integer secondIntermediate;

    public Copy(Matcher matcher) {
      try {
        firstIntermediate = Integer.valueOf(matcher.group("firstOperand"));
        firstRegister = null;
      } catch (final NumberFormatException e) {
        firstRegister = matcher.group("firstOperand");
        firstIntermediate = null;
      }

      secondRegister = matcher.group("secondOperand");
      secondIntermediate = null;
    }

    public Copy(
        final String firstRegister,
        final Integer firstIntermediate,
        final String secondRegister,
        final Integer secondIntermediate) {
      this.firstRegister = firstRegister;
      this.firstIntermediate = firstIntermediate;

      this.secondRegister = secondRegister;
      this.secondIntermediate = secondIntermediate;
    }

    @Override
    public int run(
        final Map<String, Integer> registers,
        final List<Command> commands,
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
        firstIntermediate = Integer.valueOf(matcher.group("firstOperand"));
      } catch (final NumberFormatException e) {
        firstRegister = matcher.group("firstOperand");
        firstIntermediate = null;
      }

      try {
        secondRegister = null;
        secondIntermediate = Integer.valueOf(matcher.group("secondOperand"));
      } catch (final NumberFormatException e) {
        secondRegister = matcher.group("secondOperand");
        secondIntermediate = null;
      }
    }

    public Jump(
        final String firstRegister,
        final Integer firstIntermediate,
        final String secondRegister,
        final Integer secondIntermediate) {
      this.firstRegister = firstRegister;
      this.firstIntermediate = firstIntermediate;

      this.secondRegister = secondRegister;
      this.secondIntermediate = secondIntermediate;
    }

    @Override
    public int run(
        final Map<String, Integer> registers,
        final List<Command> commands,
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
