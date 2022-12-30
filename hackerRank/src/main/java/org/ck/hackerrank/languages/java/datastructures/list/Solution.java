package org.ck.hackerrank.languages.java.datastructures.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40204006,
    name = "Java List",
    url = "https://www.hackerrank.com/challenges/java-list",
    category = "Java",
    subCategory = "Data Structures")
public class Solution {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int length = in.nextInt();
      List<Integer> array = new ArrayList<>();
      for (int i = 0; i < length; ++i) {
        array.add(in.nextInt());
      }

      int commands = in.nextInt();
      for (int i = 0; i < commands; ++i) {
        in.nextLine();
        String command = in.nextLine();

        switch (command) {
          case "Delete":
            {
              int position = in.nextInt();
              array.remove(position);
              break;
            }
          case "Insert":
            {
              int position = in.nextInt();
              int value = in.nextInt();
              array.add(position, value);
              break;
            }
        }
      }

      System.out.println(array.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
  }
}
