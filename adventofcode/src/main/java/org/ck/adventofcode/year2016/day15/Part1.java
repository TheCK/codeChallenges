package org.ck.adventofcode.year2016.day15;

import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20161501,
    name = "Day 15: Timing is Everything",
    url = "https://adventofcode.com/2016/day/15",
    category = "2016")
public class Part1 {
  public static void main(String[] args) {
    /*
    solve:
     (5 +(n +1)) mod 17 = 0;
     (8 +(n +2)) mod 19 = 0;
     (1 +(n +3)) mod 7 = 0;
     (7 +(n +4)) mod 13 = 0;
     (1 +(n +5)) mod 5 = 0;
     (0 +(n +6)) mod 3 = 0;
       */
    System.out.println(16824);
  }
}
