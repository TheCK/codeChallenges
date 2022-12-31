package org.ck.codingcompetitions.kickstart.year2020.rounda.problem1;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 120200101,
    name = "Round A - 1 - Allocation",
    url =
        "https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ffc7/00000000001d3f56",
    category = "Kick Start",
    subCategory = "2020")
public class Solution {

  public static final int MAX_PRICE = 1000;

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int cases = in.nextInt();

      for (int caze = 1; caze <= cases; ++caze) {
        int houses = in.nextInt();
        int budget = in.nextInt();

        int[] prices = new int[MAX_PRICE];
        for (int j = 0; j < houses; ++j) {
          prices[in.nextInt() - 1]++;
        }

        int affordable = 0;
        for (int price = 1; price <= MAX_PRICE; ++price) {
          while (prices[price - 1] != 0) {
            if (budget >= price) {
              budget -= price;
              prices[price - 1]--;
              ++affordable;
            } else {
              break;
            }
          }

          if (price > budget) {
            break;
          }
        }

        System.out.printf("Case #%d: %d%n", caze, affordable);
      }
    }
  }
}
