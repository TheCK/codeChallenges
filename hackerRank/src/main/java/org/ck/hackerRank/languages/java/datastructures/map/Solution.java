package org.ck.hackerRank.languages.java.datastructures.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 40204007,
    name = "Java Map",
    url = "https://www.hackerrank.com/challenges/phone-book",
    category = "Java",
    subCategory = "Data Structures")
public class Solution {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int count = in.nextInt();
      in.nextLine();

      Map<String, String> phoneBook = new HashMap<>();
      for (int i = 0; i < count; ++i) {
        String name = in.nextLine();
        String number = in.nextLine();

        phoneBook.put(name, number);
      }

      while (in.hasNext()) {
        String name = in.nextLine();

        if (phoneBook.containsKey(name)) {
          System.out.println(name + "=" + phoneBook.get(name));
        } else {
          System.out.println("Not found");
        }
      }
    }
  }
}
