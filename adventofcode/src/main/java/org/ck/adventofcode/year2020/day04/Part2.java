package org.ck.adventofcode.year2020.day04;

import org.ck.codechallengelib.annotation.Solution;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Solution(
    id = 20200402,
    name = "Day 4: Passport Processing - Part 2",
    url = "https://adventofcode.com/2020/day/4#part2",
    category = "2020")
public class Part2 {
  private static Map<Pattern, Function<String, Boolean>> validators = new HashMap<>();

  private static List<String> eyeColours =
      Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth");
  private static Pattern idPattern = Pattern.compile("[0-9]{9}");
  private static Pattern hairPattern = Pattern.compile("#[0-9a-f]{6}");
  private static Pattern heightPattern = Pattern.compile("([0-9]+)(in|cm)");
  private static Pattern expiryPattern = Pattern.compile("20(2[0-9]|30)");
  private static Pattern issuePattern = Pattern.compile("20(1[0-9]|20)");
  private static Pattern birthPattern = Pattern.compile("(19[2-9][0-9]|200[0-3])");

  static {
    validators.put(Pattern.compile("byr:(\\S+)"), (value) -> birthPattern.matcher(value).matches());
    validators.put(Pattern.compile("iyr:(\\S+)"), (value) -> issuePattern.matcher(value).matches());
    validators.put(
        Pattern.compile("eyr:(\\S+)"), (value) -> expiryPattern.matcher(value).matches());
    validators.put(
        Pattern.compile("hgt:(\\S+)"),
        (value) -> {
          Matcher matcher = heightPattern.matcher(value);

          if (matcher.find()) {
            int height = Integer.parseInt(matcher.group(1));

            if ("cm".equals(matcher.group(2))) {
              return height >= 150 && height <= 193;
            }

            return height >= 59 && height <= 76;
          }

          return false;
        });
    validators.put(Pattern.compile("hcl:(\\S+)"), (value) -> hairPattern.matcher(value).matches());
    validators.put(Pattern.compile("ecl:(\\S+)"), (value) -> eyeColours.contains(value));
    validators.put(Pattern.compile("pid:(\\S+)"), (value) -> idPattern.matcher(value).matches());
  }

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
        for (Map.Entry<Pattern, Function<String, Boolean>> validator : validators.entrySet()) {
          Matcher matcher = validator.getKey().matcher(data);

          if (!matcher.find() || !validator.getValue().apply(matcher.group(1))) {
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
