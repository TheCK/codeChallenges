package org.ck.adventofcode.year2017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20170701,
    name = "Day 7: Recursive Circus",
    url = "https://adventofcode.com/2017/day/7",
    category = "2017")
@Solution(
    id = 20170702,
    name = "Day 7: Recursive Circus - Part 2",
    url = "https://adventofcode.com/2017/day/7#part2",
    category = "2017",
    solved = false)
public class Day07 extends AOCSolution {
  private static final Pattern LINE_PATTERN =
      Pattern.compile("(?<name>\\w+) \\((?<weight>\\d+)\\) ?(-> (?<above>[\\w, ]+))?");

  @Override
  protected void runPartOne(final Scanner in) {
    final List<Program> programs = new ArrayList<>();

    while (in.hasNextLine()) {
      final Matcher matcher = LINE_PATTERN.matcher(in.nextLine());

      if (matcher.find()) {
        if (matcher.group("above") == null) {
          programs.add(
              new Program(
                  matcher.group("name"), Integer.parseInt(matcher.group("weight")), new String[0]));
        } else {
          programs.add(
              new Program(
                  matcher.group("name"),
                  Integer.parseInt(matcher.group("weight")),
                  matcher.group("above").split(", ")));
        }
      }
    }

    final List<String> names = programs.stream().map(Program::name).collect(Collectors.toList());
    programs.forEach(program -> Arrays.stream(program.above()).forEach(names::remove));

    print(names.get(0));
  }

  @Override
  protected void runPartTwo(final Scanner in) {}

  private record Program(String name, int weight, String[] above) {}
}
