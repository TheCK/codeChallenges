package org.ck.adventofcode.year2015.day04;

import org.ck.codechallengelib.annotation.Solution;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Scanner;

@Solution(
    id = 20150402,
    name = "Day 4: The Ideal Stocking Stuffer - Part 2",
    url = "https://adventofcode.com/2015/day/4#part2",
    category = "2015")
public class Part2 {
  public static void main(String[] args) throws Exception {
    MessageDigest md5 = MessageDigest.getInstance("MD5");

    try (Scanner in = new Scanner(System.in)) {
      String line = in.nextLine();

      int count = 1;
      while (true) {
        md5.reset();
        md5.update((line + count).getBytes());
        BigInteger hash = new BigInteger(1, md5.digest());

        if (hash.toString(16).length() < 27) {
          System.out.println(count);
          return;
        }

        ++count;
      }
    }
  }
}
