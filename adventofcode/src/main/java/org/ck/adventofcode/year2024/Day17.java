package org.ck.adventofcode.year2024;

import java.math.BigInteger;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20241701,
    name = "Day 17: Chronospatial Computer",
    url = "https://adventofcode.com/2024/day/17",
    category = "2024")
@Solution(
    id = 20241702,
    name = "Day 17: Chronospatial Computer - Part 2",
    url = "https://adventofcode.com/2024/day/17#part2",
    category = "2024")
public class Day17 extends AOCSolution {
  private static final BigInteger EIGHT = BigInteger.valueOf(8);

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, UnaryOperator.identity(), (output, original) -> true, (output, a) -> output);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, a -> BigInteger.ZERO, String::equals, (output, a) -> a.toString());
  }

  private void run(
      final Scanner in,
      final UnaryOperator<BigInteger> getActualA,
      final BiPredicate<String, String> shouldBreak,
      BiFunction<String, BigInteger, String> getOutput) {
    final BigInteger a = new BigInteger(in.nextLine().split(" ")[2]);
    final BigInteger b = new BigInteger(in.nextLine().split(" ")[2]);
    final BigInteger c = new BigInteger(in.nextLine().split(" ")[2]);
    in.nextLine();
    final String original = in.nextLine().split(" ")[1];

    Queue<BigInteger> possibleAs = new PriorityQueue<>();
    possibleAs.add(getActualA.apply(a));

    while (!possibleAs.isEmpty()) {
      final BigInteger startA = possibleAs.poll();
      for (int i = 0; i < 8; ++i) {
        final BigInteger actualA = startA.add(BigInteger.valueOf(i));
        final Computer computer =
            new Computer(original.split(","), Map.of("a", actualA, "b", b, "c", c));
        final List<Integer> output = computer.run();
        final String outputString =
            output.stream().map(String::valueOf).collect(Collectors.joining(","));

        if (shouldBreak.test(outputString, original)) {
          print(getOutput.apply(outputString, actualA));
          possibleAs.clear();
          break;
        }

        if (original.endsWith(outputString)) {
          final BigInteger shift = actualA.multiply(EIGHT);
          if (!shift.equals(BigInteger.ZERO)) {
            possibleAs.add(shift);
          }
        }
      }
    }
  }

  private static class Computer {
    private final String[] commands;
    private final Map<String, BigInteger> registers = new HashMap<>();

    public Computer(final String[] commands, final Map<String, BigInteger> initialRegisters) {
      this.commands = commands;
      this.registers.putAll(initialRegisters);
    }

    public List<Integer> run() {
      final List<Integer> output = new ArrayList<>();

      int p = 0;
      while (p < commands.length) {
        p +=
            getCommand(commands[p])
                .applyAsInt(registers, Integer.parseInt(commands[p + 1]), p, output);
      }

      return output;
    }

    private ToIntQuadFunction getCommand(final String command) {
      return switch (command) {
        case "0" -> this::adv;
        case "1" -> this::bxl;
        case "2" -> this::bst;
        case "3" -> this::jnz;
        case "4" -> this::bxc;
        case "5" -> this::out;
        case "6" -> this::bdv;
        case "7" -> this::cdv;
        default -> throw new IllegalStateException("Unexpected command: " + command);
      };
    }

    private BigInteger getComboOperand(final Map<String, BigInteger> registers, final int operand) {
      if (operand < 4) {
        return BigInteger.valueOf(operand);
      }

      return switch (operand) {
        case 4 -> registers.get("a");
        case 5 -> registers.get("b");
        case 6 -> registers.get("c");
        default -> throw new IllegalStateException("Unexpected value: " + operand);
      };
    }

    private int adv(
        final Map<String, BigInteger> registers,
        final int operand,
        final int p,
        final List<Integer> output) {
      registers.put(
          "a",
          registers
              .get("a")
              .divide(BigInteger.TWO.pow(getComboOperand(registers, operand).intValue())));
      return 2;
    }

    public int bxl(
        final Map<String, BigInteger> registers,
        final int operand,
        final int p,
        final List<Integer> output) {
      registers.put("b", registers.get("b").xor(BigInteger.valueOf(operand)));
      return 2;
    }

    public int bst(
        final Map<String, BigInteger> registers,
        final int operand,
        final int p,
        final List<Integer> output) {
      registers.put("b", getComboOperand(registers, operand).mod(EIGHT));
      return 2;
    }

    public int jnz(
        final Map<String, BigInteger> registers,
        final int operand,
        final int p,
        final List<Integer> output) {
      if (!registers.get("a").equals(BigInteger.ZERO)) {
        return operand - p;
      }
      return 2;
    }

    public int bxc(
        final Map<String, BigInteger> registers,
        final int operand,
        final int p,
        final List<Integer> output) {
      registers.put("b", registers.get("b").xor(registers.get("c")));
      return 2;
    }

    public int out(
        final Map<String, BigInteger> registers,
        final int operand,
        final int p,
        final List<Integer> output) {
      output.add(getComboOperand(registers, operand).mod(EIGHT).intValue());
      return 2;
    }

    public int bdv(
        final Map<String, BigInteger> registers,
        final int operand,
        final int p,
        final List<Integer> output) {
      registers.put(
          "b",
          registers
              .get("a")
              .divide(BigInteger.TWO.pow(getComboOperand(registers, operand).intValue())));
      return 2;
    }

    public int cdv(
        final Map<String, BigInteger> registers,
        final int operand,
        final int p,
        final List<Integer> output) {
      registers.put(
          "c",
          registers
              .get("a")
              .divide(BigInteger.TWO.pow(getComboOperand(registers, operand).intValue())));
      return 2;
    }
  }

  private interface ToIntQuadFunction {
    int applyAsInt(
        final Map<String, BigInteger> registers,
        final int operand,
        final int p,
        final List<Integer> output);
  }
}
