package org.ck.adventofcode.year2016.day21;

import org.ck.codechallengelib.annotation.Solution;

import java.util.Scanner;

@Solution(
    id = 20162101,
    name = "Day 21: Scrambled Letters and Hash",
    url = "https://adventofcode.com/2016/day/21",
    category = "2016")
public class Part1 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      StringBuilder password = new StringBuilder(in.nextLine());

      while (in.hasNextLine()) {
        String[] step = in.nextLine().split(" ");

        if ("swap".equals(step[0]) && "position".equals(step[1])) {
          int x = Integer.parseInt(step[2]);
          int y = Integer.parseInt(step[5]);

          String temp = password.substring(x, x + 1);
          password.replace(x, x + 1, password.substring(y, y + 1));
          password.replace(y, y + 1, temp);
        } else if ("swap".equals(step[0]) && "letter".equals(step[1])) {
          int x = password.indexOf(step[2]);
          int y = password.indexOf(step[5]);

          String temp = password.substring(x, x + 1);
          password.replace(x, x + 1, password.substring(y, y + 1));
          password.replace(y, y + 1, temp);
        } else if ("rotate".equals(step[0]) && "left".equals(step[1])) {
          int count = Integer.parseInt(step[2]);

          password = new StringBuilder(password.substring(count) + password.substring(0, count));
        } else if ("rotate".equals(step[0]) && "right".equals(step[1])) {
          int count = Integer.parseInt(step[2]);

          password =
              new StringBuilder(
                  password.substring(password.length() - count)
                      + password.substring(0, password.length() - count));
        } else if ("rotate".equals(step[0]) && "based".equals(step[1])) {
          int count = password.indexOf(step[6]);

          count += (count > 3 ? 2 : 1);
          count %= password.length();

          password =
              new StringBuilder(
                  password.substring(password.length() - count)
                      + password.substring(0, password.length() - count));
        } else if ("reverse".equals(step[0])) {
          int start = Integer.parseInt(step[2]);
          int stop = Integer.parseInt(step[4]);

          StringBuilder toReverse = new StringBuilder(password.substring(start, stop + 1));
          password =
              new StringBuilder(
                  password.substring(0, start)
                      + toReverse.reverse()
                      + password.substring(stop + 1));
        } else if ("move".equals(step[0])) {
          int x = Integer.parseInt(step[2]);
          int y = Integer.parseInt(step[5]);

          char temp = password.charAt(x);
          password.deleteCharAt(x);
          password.insert(y, temp);
        }
      }

      System.out.println(password);
    }
  }
}
