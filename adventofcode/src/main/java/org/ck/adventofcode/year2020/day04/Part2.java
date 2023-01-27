package org.ck.adventofcode.year2020.day04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20200402,
    name = "Day 4: Passport Processing - Part 2",
    url = "https://adventofcode.com/2020/day/4#part2",
    category = "2020")
public class Part2 {
  private static final Map<Pattern, Function<String, Boolean>> VALIDATORS = new HashMap<>();

  private static final Set<String> EYE_COLOURS =
      Set.of("amb", "blu", "brn", "gry", "grn", "hzl", "oth");
  private static final Pattern ID_PATTERN = Pattern.compile("\\d{9}");
  private static final Pattern HAIR_PATTERN = Pattern.compile("#[0-9a-f]{6}");
  private static final Pattern HEIGHT_PATTERN = Pattern.compile("(\\d+)(in|cm)");
  private static final Pattern EXPIRY_PATTERN = Pattern.compile("20(2\\d|30)");
  private static final Pattern ISSUE_PATTERN = Pattern.compile("20(1\\d|20)");
  private static final Pattern BIRTH_PATTERN = Pattern.compile("(19[2-9]\\d|200[0-3])");

  static {
    VALIDATORS.put(Pattern.compile("byr:(\\S+)"), value -> BIRTH_PATTERN.matcher(value).matches());
    VALIDATORS.put(Pattern.compile("iyr:(\\S+)"), value -> ISSUE_PATTERN.matcher(value).matches());
    VALIDATORS.put(Pattern.compile("eyr:(\\S+)"), value -> EXPIRY_PATTERN.matcher(value).matches());
    VALIDATORS.put(
        Pattern.compile("hgt:(\\S+)"),
        value -> {
          Matcher matcher = HEIGHT_PATTERN.matcher(value);

          if (matcher.find()) {
            int height = Integer.parseInt(matcher.group(1));

            if ("cm".equals(matcher.group(2))) {
              return height >= 150 && height <= 193;
            }

            return height >= 59 && height <= 76;
          }

          return false;
        });
    VALIDATORS.put(Pattern.compile("hcl:(\\S+)"), value -> HAIR_PATTERN.matcher(value).matches());
    VALIDATORS.put(Pattern.compile("ecl:(\\S+)"), EYE_COLOURS::contains);
    VALIDATORS.put(Pattern.compile("pid:(\\S+)"), value -> ID_PATTERN.matcher(value).matches());
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int count = 0;

      StringBuilder builder = new StringBuilder();
      while (in.hasNextLine()) {
        String line = in.nextLine();

        if (!line.isBlank()) {
          builder.append(' ').append(line.trim());

          if (in.hasNextLine()) {
            continue;
          }
        }

        String data = builder.toString();
        boolean valid = true;
        for (Map.Entry<Pattern, Function<String, Boolean>> validator : VALIDATORS.entrySet()) {
          Matcher matcher = validator.getKey().matcher(data);

          if (!matcher.find()
              || Boolean.FALSE.equals(validator.getValue().apply(matcher.group(1)))) {
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
