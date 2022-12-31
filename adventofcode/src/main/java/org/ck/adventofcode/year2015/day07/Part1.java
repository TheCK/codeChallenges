package org.ck.adventofcode.year2015.day07;

import org.ck.codechallengelib.annotation.Solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Solution(
    id = 20150701,
    name = "Day 7: Some Assembly Required",
    url = "https://adventofcode.com/2015/day/7",
    category = "2015")
public class Part1 {
  public static final Map<String, String> commands = new HashMap<>();

  public static void main(String[] args) throws Exception {

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String[] split = in.nextLine().split(" -> ");
        commands.put(split[1], split[0]);
      }
    }

    System.out.println(calculate("a"));
  }

  private static int calculate(String wire) {
    try {
      return Integer.parseInt(wire);
    } catch (NumberFormatException e) {
      // TODO ignore
    }

    String command = commands.get(wire);
    String[] split = command.split(" ");

    if (command.contains("OR")) {
      int a = calculate(split[0]);
      commands.put(split[0], String.valueOf(a));
      int b = calculate(split[2]);
      commands.put(split[2], String.valueOf(b));

      return a | b;
    } else if (command.contains("AND")) {
      int a = calculate(split[0]);
      commands.put(split[0], String.valueOf(a));
      int b = calculate(split[2]);
      commands.put(split[2], String.valueOf(b));

      return a & b;
    } else if (command.contains("NOT")) {
      int a = calculate(split[1]);
      commands.put(split[1], String.valueOf(a));

      return (~a) & 0xFFFF;
    } else if (command.contains("LSHIFT")) {
      int a = calculate(split[0]);
      commands.put(split[0], String.valueOf(a));

      return (a << Integer.parseInt(split[2])) & 0xFFFF;
    } else if (command.contains("RSHIFT")) {
      int a = calculate(split[0]);
      commands.put(split[0], String.valueOf(a));

      return (a >> Integer.parseInt(split[2])) & 0xFFFF;
    }

    return calculate(split[0]);
  }
}
