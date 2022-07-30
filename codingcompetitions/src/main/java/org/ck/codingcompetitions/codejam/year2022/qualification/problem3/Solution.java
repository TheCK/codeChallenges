package org.ck.codingcompetitions.codejam.year2022.qualification.problem3;

import java.util.PriorityQueue;
import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 220220003,
    name = "Qualification Round - 3 - d1000000",
    url =
        "https://codingcompetitions.withgoogle.com/codejam/round/0000000000876ff1/0000000000a46471",
    category = "Code Jam",
    subCategory = "2022")
public class Solution {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tests = in.nextInt();

      for (int test = 1; test <= tests; ++test) {
        int dice = in.nextInt();

        PriorityQueue<Integer> available = new PriorityQueue<>();
        for (int die = 0; die < dice; ++die) {
          available.add(in.nextInt());
        }

        int straight = 0;
        while (available.size() > 0) {
          int next = available.poll();

          if (next > straight) {
            ++straight;
          }
        }

        System.out.printf("Case #%d: %d%n", test, straight);
      }
    }
  }
}
