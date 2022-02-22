package org.ck.adventofcode.year2016.day09;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.Scanner;

@Solution(
    id = 20160901,
    name = "Day 9: Explosives in Cyberspace",
    url = "https://adventofcode.com/2016/day/9",
    category = "2016")
public class Part1 {
  public static void main(String[] args) {
    int length = 0;

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        length += decompress(in.nextLine());
      }
    }

    System.out.println(length);
  }

  private static int decompress(final String line) {
    StringBuilder builder = new StringBuilder();

    int index = 0;
    while (index < line.length()) {
      if (line.charAt(index) == '(') {
        int xOffset = 1;
        while (line.charAt(index + xOffset) != 'x') {
          ++xOffset;
        }

        int closingOffest = xOffset + 1;
        while (line.charAt(index + closingOffest) != ')') {
          ++closingOffest;
        }

        int repeatLength = Integer.parseInt(line.substring(index + 1, index + xOffset));
        int repeatCount =
            Integer.parseInt(line.substring(index + xOffset + 1, index + closingOffest));

        for (int i = 0; i < repeatCount; ++i) {
          builder.append(line, index + closingOffest + 1, index + closingOffest + repeatLength + 1);
        }

        index += closingOffest + repeatLength + 1;
      } else {
        builder.append(line.charAt(index));
        ++index;
      }
    }

    return builder.length();
  }
}
