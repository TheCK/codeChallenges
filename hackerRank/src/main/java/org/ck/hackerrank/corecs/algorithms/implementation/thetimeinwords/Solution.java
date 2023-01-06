package org.ck.hackerrank.corecs.algorithms.implementation.thetimeinwords;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 10243,
    name = "The Time in Words",
    url = "https://www.hackerrank.com/challenges/the-time-in-words",
    category = "Algorithms",
    subCategory = "Implementation")
public class Solution {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int hours = in.nextInt();
      int minutes = in.nextInt();

      StringBuilder builder = new StringBuilder();
      if (minutes == 0) {
        printNumber(builder, hours);
        builder.append(" o' clock");
      } else if (minutes == 30) {
        builder.append("half past ");
        printNumber(builder, hours);
      } else if (minutes < 30) {
        printNumber(builder, minutes);
        if (minutes != 15) {
          builder.append(" minute");

          if (minutes > 1) {
            builder.append("s");
          }
        }

        builder.append(" past ");
        printNumber(builder, hours);
      } else {
        printNumber(builder, 60 - minutes);

        if (hours == 12) {
          hours = 0;
        }

        if (minutes != 45) {
          builder.append(" minute");

          if (minutes < 59) {
            builder.append("s");
          }
        }

        builder.append(" to ");
        printNumber(builder, hours + 1);
      }

      System.out.println(builder);
    }
  }

  private static void printNumber(StringBuilder builder, int number) {
    switch (number) {
      case 1 -> builder.append("one");
      case 2 -> builder.append("two");
      case 3 -> builder.append("three");
      case 4 -> builder.append("four");
      case 5 -> builder.append("five");
      case 6 -> builder.append("six");
      case 7 -> builder.append("seven");
      case 8 -> builder.append("eight");
      case 9 -> builder.append("nine");
      case 10 -> builder.append("ten");
      case 11 -> builder.append("eleven");
      case 12 -> builder.append("twelve");
      case 13 -> builder.append("thirteen");
      case 14 -> builder.append("fourteen");
      case 15 -> builder.append("quarter");
      case 16 -> builder.append("sixteen");
      case 17 -> builder.append("seventeen");
      case 18 -> builder.append("eighteen");
      case 19 -> builder.append("nineteen");
      case 20 -> builder.append("twenty");
      case 21 -> builder.append("twenty one");
      case 22 -> builder.append("twenty two");
      case 23 -> builder.append("twenty three");
      case 24 -> builder.append("twenty four");
      case 25 -> builder.append("twenty five");
      case 26 -> builder.append("twenty six");
      case 27 -> builder.append("twenty seven");
      case 28 -> builder.append("twenty eight");
      case 29 -> builder.append("twenty nine");
      default -> throw new IllegalStateException("Unexpected value: " + number);
    }
  }
}
