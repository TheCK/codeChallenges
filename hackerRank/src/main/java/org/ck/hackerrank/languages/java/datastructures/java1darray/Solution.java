package org.ck.hackerrank.languages.java.datastructures.java1darray;

import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40204001,
    name = "Java 1D Array",
    url = "https://www.hackerrank.com/challenges/java-1d-array-introduction",
    category = "Java",
    subCategory = "Data Structures")
public class Solution {

  public static void main(String[] args) {
    try (Scanner scan = new Scanner(System.in)) {
      int n = scan.nextInt();

      int a[] = new int[n];
      for (int i = 0; i < n; ++i) {
        a[i] = scan .nextInt();
      }

      // Prints each sequential element in array a
      for (int i = 0; i < a.length; i++) {
        System.out.println(a[i]);
      }
    }
  }
}
