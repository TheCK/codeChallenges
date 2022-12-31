package org.ck.adventofcode.year2020.day25;

import java.util.Scanner;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20202501,
    name = "Day 25: Combo Breaker",
    url = "https://adventofcode.com/2020/day/25",
    category = "2020")
public class Part1 {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      long pubKey1 = in.nextLong();
      long pubKey2 = in.nextLong();

      long subject = 7;
      long value = 1;
      long loops = 0;
      while (value != pubKey1) {
        value *= subject;
        value %= 20201227;
        ++loops;
      }

      value = 1;
      for (long i = 0; i < loops; ++i) {
        value *= pubKey2;
        value %= 20201227;
      }

      System.out.println(value);
    }
  }
}
