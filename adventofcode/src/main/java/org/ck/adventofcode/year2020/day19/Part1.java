package org.ck.adventofcode.year2020.day19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20201901,
    name = "Day 19: Monster Messages",
    url = "https://adventofcode.com/2020/day/19",
    category = "2020")
public class Part1 {
  private static final Pattern literalPattern = Pattern.compile("([0-9]+): \\\"([a-z])\\\"");

  public static void main(String[] args) {
    int count = 0;

    try (Scanner in = new Scanner(System.in)) {
      Map<Integer, Rule> rules = new HashMap<>();

      while (in.hasNextLine()) {
        String line = in.nextLine();

        if (line.contains(":")) {
          if (line.contains("\"")) {
            Matcher matcher = literalPattern.matcher(line);
            if (matcher.matches()) {
              rules.put(
                  Integer.valueOf(matcher.group(1)), new LiteralRule(matcher.group(2).charAt(0)));
            }
          } else {
            String[] elements = line.split(":");
            String[] subRules = elements[1].trim().split("\\|");

            SubRuleRule subRuleRule = new SubRuleRule();
            for (String subRule : subRules) {
              String[] values = subRule.trim().split(" ");

              subRuleRule.addSubRule(
                  Arrays.stream(values).map(Integer::valueOf).collect(Collectors.toList()));
            }

            rules.put(Integer.valueOf(elements[0]), subRuleRule);
          }
        } else if (!line.isBlank()) {
          Set<Integer> matchLengths = matchLine(rules, line, 0, 0);

          if (matchLengths.contains(line.length())) {
            ++count;
          }
        }
      }
    }

    System.out.println(count);
  }

  private static Set<Integer> matchLine(
      Map<Integer, Rule> rules, String line, Integer rule, int offset) {

    if (offset >= line.length()) {
      return Collections.emptySet();
    }

    if (rules.get(rule) instanceof LiteralRule) {
      if (line.charAt(offset) == ((LiteralRule) rules.get(rule)).getLiteral()) {
        return Collections.singleton(1);
      }
    } else if (rules.get(rule) instanceof SubRuleRule) {
      SubRuleRule subRuleRule = (SubRuleRule) rules.get(rule);
      Set<Integer> matchLengths = new HashSet<>();

      for (List<Integer> subRule : subRuleRule.getSubRules()) {
        Set<Integer> newOffsets = new HashSet<>();
        newOffsets.add(0);

        for (Integer newRule : subRule) {
          Set<Integer> subMatchLengths = new HashSet<>();
          for (int newOffset : newOffsets) {
            subMatchLengths.addAll(
                matchLine(rules, line, newRule, offset + newOffset).stream()
                    .map(x -> x + newOffset)
                    .collect(Collectors.toSet()));
          }
          newOffsets = subMatchLengths;
        }

        matchLengths.addAll(newOffsets);
      }

      return matchLengths;
    }

    return Collections.emptySet();
  }

  private interface Rule {}

  private static class SubRuleRule implements Rule {
    private final List<List<Integer>> subRules = new ArrayList<>();

    public void addSubRule(List<Integer> subRule) {
      subRules.add(subRule);
    }

    public List<List<Integer>> getSubRules() {
      return subRules;
    }
  }

  private static class LiteralRule implements Rule {
    private final char literal;

    public LiteralRule(char literal) {
      this.literal = literal;
    }

    public char getLiteral() {
      return literal;
    }
  }
}
