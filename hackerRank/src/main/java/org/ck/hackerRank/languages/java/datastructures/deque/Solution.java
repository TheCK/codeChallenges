package org.ck.hackerRank.languages.java.datastructures.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40204013,
    name = "Java Dequeue",
    url = "https://www.hackerrank.com/challenges/java-dequeue",
    category = "Java",
    subCategory = "Data Structures")
public class Solution {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      Deque<Integer> deque = new ArrayDeque<>();
      Set<Integer> set = new HashSet<>();
      int n = in.nextInt();
      int m = in.nextInt();

      int unique = Integer.MIN_VALUE;

      for (int i = 0; i < n; i++) {
        int num = in.nextInt();

        deque.add(num);
        set.add(num);

        unique = Math.max(unique, set.size());

        if (deque.size() == m) {
          Integer removed = deque.removeFirst();

          if (!deque.contains(removed)) {
            set.remove(removed);
          }
        }
      }

      System.out.println(unique);
    }
  }
}
