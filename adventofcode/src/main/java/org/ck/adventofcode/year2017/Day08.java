package org.ck.adventofcode.year2017;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.ToLongBiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20170801,
    name = "Day 8: I Heard You Like Registers",
    url = "https://adventofcode.com/2017/day/8",
    category = "2017")
@Solution(
    id = 20170802,
    name = "Day 8: I Heard You Like Registers - Part 2",
    url = "https://adventofcode.com/2017/day/8#part2",
    category = "2017")
public class Day08 extends AOCSolution {
  private static final Pattern LINE_PATTERN =
      Pattern.compile(
          "(?<register>\\w+) (?<command>\\w+) (?<value>-?\\d+) if"
              + " (?<checkRegister>\\w+) (?<condition>[><=!]+) (?<checkValue>-?\\d+)");

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, (max, registers) -> registers.values().stream().mapToLong(x -> x).max().getAsLong());
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, (max, registers) -> max);
  }

  private void run(final Scanner in, final ToLongBiFunction<Long, Map<String, Long>> getResult) {
    final Map<String, Long> registers = new HashMap<>();
    long max = 0;

    while (in.hasNextLine()) {
      final Matcher matcher = LINE_PATTERN.matcher(in.nextLine());

      if (matcher.find()) {
        final String register = matcher.group("register");
        final String command = matcher.group("command");
        final long value = Long.parseLong(matcher.group("value"));

        final String checkRegister = matcher.group("checkRegister");
        final String condition = matcher.group("condition");
        final long checkValue = Long.parseLong(matcher.group("checkValue"));

        if (conditionIsValid(registers, checkRegister, condition, checkValue)) {
          switch (command) {
            case "inc" -> registers.put(register, registers.getOrDefault(register, 0L) + value);
            case "dec" -> registers.put(register, registers.getOrDefault(register, 0L) - value);
            default -> throw new IllegalArgumentException();
          }

          max = Math.max(max, registers.get(register));
        }
      }
    }

    print(getResult.applyAsLong(max, registers));
  }

  private static boolean conditionIsValid(
      final Map<String, Long> registers,
      final String checkRegister,
      final String condition,
      final long checkValue) {
    long actualValue = registers.getOrDefault(checkRegister, 0L);

    return switch (condition) {
      case "==" -> actualValue == checkValue;
      case "!=" -> actualValue != checkValue;
      case ">=" -> actualValue >= checkValue;
      case "<=" -> actualValue <= checkValue;
      case ">" -> actualValue > checkValue;
      case "<" -> actualValue < checkValue;
      default -> throw new IllegalArgumentException();
    };
  }
}
