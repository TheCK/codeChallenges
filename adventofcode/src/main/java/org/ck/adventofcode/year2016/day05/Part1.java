package org.ck.adventofcode.year2016.day05;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20160501,
    name = "Day 5: How About a Nice Game of Chess?",
    url = "https://adventofcode.com/2016/day/5",
    category = "2016")
public class Part1 {
  public static void main(String[] args) throws Exception {
    try (Scanner in = new Scanner(System.in)) {
      String door = in.nextLine();

      List<Character> password = new ArrayList<>();

      long index = 0;
      while (password.size() < 8) {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update((door + index).getBytes());
        byte[] digest = md.digest();
        if (digest[0] == 0 && digest[1] == 0 && digest[2] >= 0 && digest[2] < 0x10) {
          password.add((char) ((digest[2] & 0x0F) + ((digest[2] & 0x0F) > 9 ? 'a' - 10 : '0')));
        }

        ++index;
      }

      System.out.println(password.stream().map(c -> c.toString()).collect(Collectors.joining()));
    }
  }
}
