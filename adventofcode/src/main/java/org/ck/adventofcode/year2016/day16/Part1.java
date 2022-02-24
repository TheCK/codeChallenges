package org.ck.adventofcode.year2016.day16;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.Scanner;

@Solution(
    id = 20161601,
    name = "Day 16: Dragon Checksum",
    url = "https://adventofcode.com/2016/day/16",
    category = "2016")
public class Part1 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      String data = in.nextLine();
      int space = in.nextInt();

      while (data.length() < space) {
        StringBuilder b = new StringBuilder();

        for (int i = data.length() - 1; i >= 0; --i) {
          if (data.charAt(i) == '1') {
            b.append("0");
          } else {
            b.append("1");
          }
        }

        data += "0" + b;
      }

      while (data.length() > space || data.length() % 2 == 0) {
        StringBuilder check = new StringBuilder();

        for (int i = 0; i < Math.min(space, data.length()); i += 2) {
          if (data.startsWith("00", i) || data.startsWith("11", i)) {
            check.append("1");
          } else {
            check.append("0");
          }
        }

        data = check.toString();
      }

      System.out.println(data);
    }
  }
}
