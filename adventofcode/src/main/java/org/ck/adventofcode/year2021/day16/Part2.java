package org.ck.adventofcode.year2021.day16;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20211602,
    name = "Day 16: Packet Decoder - Part 2",
    url = "https://adventofcode.com/2021/day/16#part2",
    category = "2021")
public class Part2 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      final String line = in.nextLine();
      StringBuilder builder = new StringBuilder(new BigInteger(line, 16).toString(2));

      while (builder.length() < line.length() * 4) {
        builder.insert(0, "0");
      }

      ParsingResult result = parse(builder.toString(), 0);

      System.out.println(result.result());
    }
  }

  private static ParsingResult parse(final String binary, int index) {
    index += 3;

    int id = Integer.parseInt(binary.substring(index, index + 3), 2);
    index += 3;

    long calc = 0;

    if (id == 4) {
      StringBuilder builder = new StringBuilder();

      do {
        builder.append(binary, index + 1, index + 5);
        index += 5;
      } while (binary.charAt(index - 5) == '1');

      calc = Long.parseLong(builder.toString(), 2);
    } else {
      char type = binary.charAt(index);
      ++index;

      List<Long> arguments = new ArrayList<>();
      if (type == '0') {
        int length = Integer.parseInt(binary.substring(index, index + 15), 2);
        index += 15;

        int start = index;

        while (index < start + length) {
          final ParsingResult result = parse(binary, index);
          arguments.add(result.result());
          index = result.index();
        }
      } else {
        int packets = Integer.parseInt(binary.substring(index, index + 11), 2);
        index += 11;

        for (int i = 0; i < packets; ++i) {
          final ParsingResult result = parse(binary, index);
          arguments.add(result.result());
          index = result.index();
        }
      }

      calc =
          switch (id) {
            case 0 -> arguments.stream().mapToLong(x -> x).sum();
            case 1 -> arguments.stream().mapToLong(x -> x).reduce(1, (x, y) -> x * y);
            case 2 -> arguments.stream().mapToLong(x -> x).min().orElseThrow();
            case 3 -> arguments.stream().mapToLong(x -> x).max().orElseThrow();
            case 5 -> arguments.get(0) > arguments.get(1) ? 1 : 0;
            case 6 -> arguments.get(0) < arguments.get(1) ? 1 : 0;
            case 7 -> arguments.get(0).equals(arguments.get(1)) ? 1 : 0;
            default -> calc;
          };
    }

    return new ParsingResult(index, calc);
  }

  private record ParsingResult(int index, long result) {}
}
