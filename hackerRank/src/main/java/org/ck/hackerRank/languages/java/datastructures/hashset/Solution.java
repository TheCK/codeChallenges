package org.ck.hackerRank.languages.java.datastructures.hashset;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40204009,
    name = "Java Hashset",
    url = "https://www.hackerrank.com/challenges/java-hashset",
    category = "Java",
    subCategory = "Data Structures")
public class Solution {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int t = in.nextInt();
      String[] pair_left = new String[t];
      String[] pair_right = new String[t];

      for (int i = 0; i < t; i++) {
        pair_left[i] = in.next();
        pair_right[i] = in.next();
      }

      Set<String> set = new HashSet<>();
      for (int i = 0; i < t; i++) {
        set.add(String.format("%s %s", pair_left[i], pair_right[i]));
        System.out.println(set.size());
      }
    }
  }
}
