package org.ck.adventofcode.year2016.day05;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20160502,
    name = "Day 5: How About a Nice Game of Chess? - Part 2",
    url = "https://adventofcode.com/2016/day/5#part2",
    category = "2016")
public class Part2 {
  public static void main(String[] args) throws Exception {
    try (Scanner in = new Scanner(System.in)) {
      String door = in.nextLine();

      Map<Integer, Character> password = new HashMap<>();

      long index = 0;
      while (password.size() < 8) {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update((door + index).getBytes());
        byte[] digest = md.digest();
        if (digest[0] == 0
            && digest[1] == 0
            && digest[2] >= 0
            && digest[2] < 0x10
            && (digest[2] & 0x0F) < 8
            && !password.containsKey((digest[2] & 0x0F))) {
          password.put(
              (digest[2] & 0x0F),
              (char)
                  (((digest[3] & 0xF0) / 16) + (((digest[3] & 0xF0) / 16) > 9 ? 'a' - 10 : '0')));
        }

        ++index;
      }

      System.out.println(
          password.entrySet().stream()
              .sorted(Map.Entry.comparingByKey())
              .map(c -> c.getValue().toString())
              .collect(Collectors.joining()));
    }
  }
}
