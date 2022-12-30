package org.ck.hackerrank.languages.java.datastructures.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40204004,
    name = "Java Arraylist",
    url = "https://www.hackerrank.com/challenges/java-arraylist",
    category = "Java",
    subCategory = "Data Structures")
public class Solution {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int lines = in.nextInt();

      ArrayList<Integer>[] list = new ArrayList[lines];
      for (int i = 0; i < lines; ++i) {
        list[i] = new ArrayList<>();

        int nums = in.nextInt();
        for (int j = 0; j < nums; ++j) {
          list[i].add(in.nextInt());
        }
      }

      int queries = in.nextInt();
      for (int i = 0; i < queries; ++i) {
        int x = in.nextInt() - 1;
        int y = in.nextInt() - 1;

        if (x > list.length - 1 || y > list[x].size() - 1) {
          System.out.println("ERROR!");
        } else {
          System.out.println(list[x].get(y));
        }
      }
    }
  }
}
