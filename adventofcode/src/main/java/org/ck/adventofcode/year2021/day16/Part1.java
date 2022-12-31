package org.ck.adventofcode.year2021.day16;

import org.ck.codechallengelib.annotation.Solution;

import java.math.BigInteger;
import java.util.Scanner;

@Solution(
    id = 20211601,
    name = "Day 16: Packet Decoder",
    url = "https://adventofcode.com/2021/day/16",
    category = "2021")
public class Part1 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      StringBuilder builder = new StringBuilder(new BigInteger(in.nextLine(), 16).toString(2));
      while (builder.length() % 4 != 0) {
        builder.insert(0, "0");
      }

      ParsingResult result = parse(builder.toString(), 0);

      System.out.println(result.version());
    }
  }

  private static ParsingResult parse(final String binary, int index) {
    int version = Integer.parseInt(binary.substring(index, index + 3), 2);
    index += 3;

    int id = Integer.parseInt(binary.substring(index, index + 3), 2);
    index += 3;

    if (id == 4) {
      do {
        index += 5;
      } while (binary.charAt(index - 5) == '1');
    } else {
      char type = binary.charAt(index);
      ++index;

      if (type == '0') {
        int length = Integer.parseInt(binary.substring(index, index + 15), 2);
        index += 15;

        int start = index;

        while (index < start + length) {
          final ParsingResult result = parse(binary, index);
          version += result.version();
          index = result.index();
        }
      } else {
        int packets = Integer.parseInt(binary.substring(index, index + 11), 2);
        index += 11;

        for (int i = 0; i < packets; ++i) {
          final ParsingResult result = parse(binary, index);
          version += result.version();
          index = result.index();
        }
      }
    }

    return new ParsingResult(index, version);
  }

  private static final record ParsingResult(int index, int version) {}
}
