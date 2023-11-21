package org.ck.adventofcode.year2017.day08;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20170802,
    name = "Day 8: I Heard You Like Registers - Part 2",
    url = "https://adventofcode.com/2017/day/8#part2",
    category = "2017")
public class Part2 {
  private static final Pattern LINE_PATTERN =
      Pattern.compile(
          "(?<register>\\w+) (?<command>\\w+) (?<value>-?\\d+) if"
              + " (?<checkRegister>\\w+) (?<condition>[><=!]+) (?<checkValue>-?\\d+)");

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      Map<String, Long> registers = new HashMap<>();
      long max = 0;

      while (in.hasNextLine()) {
        final Matcher matcher = LINE_PATTERN.matcher(in.nextLine());

        if (matcher.find()) {
          String register = matcher.group("register");
          String command = matcher.group("command");
          long value = Long.parseLong(matcher.group("value"));

          String checkRegister = matcher.group("checkRegister");
          String condition = matcher.group("condition");
          long checkValue = Long.parseLong(matcher.group("checkValue"));

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

      System.out.println(max);
    }
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
