package org.ck.adventofcode.year2017.day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20170701,
    name = "Day 7: Recursive Circus",
    url = "https://adventofcode.com/2017/day/7",
    category = "2017")
public class Part1 {
  private static final Pattern LINE_PATTERN =
      Pattern.compile("(?<name>\\w+) \\((?<weight>\\d+)\\) ?(-> (?<above>[\\w, ]+))?");

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      List<Program> programs = new ArrayList<>();

      while (in.hasNextLine()) {
        final Matcher matcher = LINE_PATTERN.matcher(in.nextLine());

        if (matcher.find()) {
          if (matcher.group("above") == null) {
            programs.add(
                new Program(
                    matcher.group("name"),
                    Integer.parseInt(matcher.group("weight")),
                    new String[0]));
          } else {
            programs.add(
                new Program(
                    matcher.group("name"),
                    Integer.parseInt(matcher.group("weight")),
                    matcher.group("above").split(", ")));
          }
        }
      }

      List<String> names = programs.stream().map(Program::name).collect(Collectors.toList());
      programs.forEach(program -> Arrays.stream(program.above()).forEach(names::remove));

      System.out.println(names.get(0));
    }
  }

  private record Program(String name, int weight, String[] above) {}
}
