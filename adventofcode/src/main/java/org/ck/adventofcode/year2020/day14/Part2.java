package org.ck.adventofcode.year2020.day14;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20201402,
    name = "Day 14: Docking Data - Part 2",
    url = "https://adventofcode.com/2020/day/14#part2",
    category = "2020")
public class Part2 {
  private static final Pattern maskPattern = Pattern.compile("mask = ([01X]+)");
  private static final Pattern setPattern = Pattern.compile("mem\\[([0-9]+)\\] = ([0-9]+)");

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      Map<Long, Long> memory = new HashMap<>();
      String mask = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";

      while (in.hasNextLine()) {
        String line = in.nextLine();

        Matcher maskMatcher = maskPattern.matcher(line);
        if (maskMatcher.matches()) {
          mask = maskMatcher.group(1);
        } else {
          Matcher setMatcher = setPattern.matcher(line);
          if (setMatcher.find()) {
            Long value = Long.valueOf(setMatcher.group(2));
            String binaryAddress = Long.toString(Long.parseLong(setMatcher.group(1)), 2);

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < mask.length(); ++i) {
              if (mask.charAt(i) == '0') {
                if (i < mask.length() - binaryAddress.length()) {
                  builder.append('0');
                } else {
                  builder.append(
                      binaryAddress.charAt(binaryAddress.length() - (mask.length() - i)));
                }
              } else {
                builder.append(mask.charAt(i));
              }
            }

            write(memory, builder.toString(), value);
          }
        }
      }

      System.out.println(memory.values().stream().mapToLong(Long::longValue).sum());
    }
  }

  private static void write(Map<Long, Long> memory, String address, Long value) {
    if (address.indexOf('X') == -1) {
      memory.put(Long.parseLong(address, 2), value);
      return;
    }

    write(memory, address.replaceFirst("X", "0"), value);
    write(memory, address.replaceFirst("X", "1"), value);
  }
}
