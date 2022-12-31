package org.ck.adventofcode.year2020.day04;

import org.ck.codechallengelib.annotation.Solution;

import java.util.Scanner;

@Solution(
    id = 20200401,
    name = "Day 4: Passport Processing",
    url = "https://adventofcode.com/2020/day/4",
    category = "2020")
public class Part1 {
  private static String[] fields = new String[] {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int count = 0;

      StringBuilder builder = new StringBuilder();
      while (in.hasNextLine()) {
        String line = in.nextLine();

        if (!line.isBlank()) {
          builder.append(" ").append(line.trim());

          if (in.hasNextLine()) {
            continue;
          }
        }

        String data = builder.toString();
        boolean valid = true;
        for (String field : fields) {
          if (!data.contains(field + ":")) {
            valid = false;
            break;
          }
        }

        if (valid) {
          ++count;
        }
        builder = new StringBuilder();
      }

      System.out.println(count);
    }
  }
}
