package org.ck.hackerrank.languages.java.datastructures.java1darray2;

import java.util.Scanner;
import java.util.Stack;

@org.ck.codechallengelib.annotation.Solution(
    id = 40204005,
    name = "Java 1D Array (Part 2)",
    url = "https://www.hackerrank.com/challenges/java-1d-array",
    category = "Java",
    subCategory = "Data Structures")
public class Solution {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int games = in.nextInt();

      for (int i = 0; i < games; ++i) {
        int length = in.nextInt();
        int leap = in.nextInt();

        int[] game = new int[length];
        for (int j = 0; j < length; ++j) {
          game[j] = in.nextInt();
        }

        boolean[] visited = new boolean[length];
        Stack<Integer> locations = new Stack<>();
        locations.push(0);

        boolean solvable = false;
        while (!locations.isEmpty()) {
          Integer location = locations.pop();
          visited[location] = true;

          if (location > 0 && game[location - 1] == 0 && !visited[location - 1]) {
            locations.push(location - 1);
          }

          if (game[location + 1] == 0 && !visited[location + 1]) {
            if (location + 1 >= length - 1) {
              solvable = true;
              break;
            }

            locations.push(location + 1);
          }

          if (location + leap > length - 1
              || (location + leap == length - 1 && game[length - 1] == 0)) {
            solvable = true;
            break;
          }

          if (game[location + leap] == 0 && !visited[location + leap]) {
            locations.push(location + leap);
          }
        }

        System.out.println(solvable ? "YES" : "NO");
      }
    }
  }
}
