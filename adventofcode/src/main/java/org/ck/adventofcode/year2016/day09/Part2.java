package org.ck.adventofcode.year2016.day09;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20160902,
    name = "Day 9: Explosives in Cyberspace - Part 2",
    url = "https://adventofcode.com/2016/day/9#part2",
    category = "2016",
    solved = false)
public class Part2 {
  public static void main(String[] args) {
    long length = 0;

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String line = in.nextLine();

        List<Character> zipped = line.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        while (zipped.contains('(')) {
          zipped = decompress(zipped);
        }

        length += zipped.size();
      }
    }

    System.out.println(length);
  }

  private static List<Character> decompress(final List<Character> zipped) {
    List<Character> expanded = new LinkedList<>();

    final Iterator<Character> iterator = zipped.iterator();
    while (iterator.hasNext()) {
      char c = iterator.next();
      if (c == '(') {
        StringBuilder length = new StringBuilder();
        c = iterator.next();

        while (c != 'x') {
          length.append(c);
          c = iterator.next();
        }

        StringBuilder count = new StringBuilder();
        c = iterator.next();

        while (c != ')') {
          count.append(c);
          c = iterator.next();
        }

        int repeatLength = Integer.parseInt(length.toString());
        int repeatCount = Integer.parseInt(count.toString());

        List<Character> repeat = new LinkedList<>();
        for (int i = 0; i < repeatLength; ++i) {
          repeat.add(iterator.next());
        }

        for (int i = 0; i < repeatCount; ++i) {
          expanded.addAll(repeat);
        }
      } else {
        expanded.add(c);
      }
    }

    return expanded;
  }
}
