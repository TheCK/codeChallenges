package org.ck.adventofcode.year2015.day12;

import org.ck.codechallengelib.annotation.Solution;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Solution(
    id = 20151201,
    name = "Day 12: JSAbacusFramework.io",
    url = "https://adventofcode.com/2015/day/12",
    category = "2015")
public class Part1 {
  private static final Pattern number = Pattern.compile("(-?[0-9])+");

  public static void main(String[] args) throws Exception {
    try (Scanner in = new Scanner(System.in)) {
      String json = in.nextLine();

      int sum = 0;
      final Matcher matcher = number.matcher(json);

      int offset = 0;
      while (matcher.find(offset)) {
        sum += Integer.parseInt(matcher.group(0));
        offset = matcher.end();
      }

      System.out.println(sum);
    }
  }
}
