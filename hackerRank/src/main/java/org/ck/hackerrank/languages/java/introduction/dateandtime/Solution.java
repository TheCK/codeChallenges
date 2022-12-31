package org.ck.hackerrank.languages.java.introduction.dateandtime;

import java.time.LocalDateTime;
import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 40201012,
    name = "Java Date and Time",
    url = "https://www.hackerrank.com/challenges/java-date-and-time",
    category = "Java",
    subCategory = "Introduction")
public class Solution {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int month = in.nextInt();
      int day = in.nextInt();
      int year = in.nextInt();

      LocalDateTime localDateTime = LocalDateTime.of(year, month, day, 0, 0);

      System.out.println(localDateTime.getDayOfWeek());
    }
  }
}
