package org.ck.adventofcode.year2015.day04;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20150401,
    name = "Day 4: The Ideal Stocking Stuffer",
    url = "https://adventofcode.com/2015/day/4",
    category = "2015")
public class Part1 {
  public static void main(String[] args) throws Exception {
    MessageDigest md5 = MessageDigest.getInstance("MD5");

    try (Scanner in = new Scanner(System.in)) {
      String line = in.nextLine();

      int count = 1;
      while (true) {
        md5.reset();
        md5.update((line + count).getBytes());
        BigInteger hash = new BigInteger(1, md5.digest());

        if (hash.toString(16).length() < 28) {
          System.out.println(count);
          return;
        }

        ++count;
      }
    }
  }
}
