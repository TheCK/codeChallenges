package org.ck.hackerrank.corecs.algorithms.implementation.sockmerchant;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 10209,
    name = "Sock Merchant",
    url = "https://www.hackerrank.com/challenges/sock-merchant",
    category = "Algorithms",
    subCategory = "Implementation")
public class Solution {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt();

      int[] socks = new int[n];
      for (int i = 0; i < n; ++i) {
        socks[i] = in.nextInt();
      }

      Map<Integer, Long> groupedSocks =
          Arrays.stream(socks).boxed().collect(groupingBy(sock -> sock, counting()));

      System.out.println(
          groupedSocks.values().stream().mapToLong(count -> count.longValue() / 2).sum());
    }
  }
}
