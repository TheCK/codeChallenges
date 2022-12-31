package org.ck.adventofcode.year2020.day14;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20201401,
    name = "Day 14: Docking Data",
    url = "https://adventofcode.com/2020/day/14",
    category = "2020")
public class Part1 {
  private static final Pattern maskPattern = Pattern.compile("mask = ([01X]+)");
  private static final Pattern setPattern = Pattern.compile("mem\\[([0-9]+)\\] = ([0-9]+)");

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      Map<Integer, Long> memory = new HashMap<>();
      String mask = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";

      while (in.hasNextLine()) {
        String line = in.nextLine();

        Matcher maskMatcher = maskPattern.matcher(line);
        if (maskMatcher.matches()) {
          mask = maskMatcher.group(1);
        } else {
          Matcher setMatcher = setPattern.matcher(line);
          if (setMatcher.find()) {
            Integer address = Integer.valueOf(setMatcher.group(1));
            String binary = Long.toString(Long.parseLong(setMatcher.group(2)), 2);

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < mask.length(); ++i) {
              switch (mask.charAt(i)) {
                case 'X':
                  if (i < mask.length() - binary.length()) {
                    builder.append('0');
                  } else {
                    builder.append(binary.charAt(binary.length() - (mask.length() - i)));
                  }
                  break;
                case '1':
                  builder.append('1');
                  break;
                case '0':
                  builder.append('0');
                  break;
              }
            }

            memory.put(address, Long.valueOf(builder.toString(), 2));
          }
        }
      }

      System.out.println(memory.values().stream().mapToLong(Long::longValue).sum());
    }
  }
}
