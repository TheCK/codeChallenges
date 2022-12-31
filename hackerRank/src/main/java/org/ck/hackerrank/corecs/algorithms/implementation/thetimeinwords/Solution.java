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
      } else if (minutes > 30) {
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

      System.out.println(builder.toString());
    }
  }

  private static void printNumber(StringBuilder builder, int number) {
    switch (number) {
      case 1:
        builder.append("one");
        break;
      case 2:
        builder.append("two");
        break;
      case 3:
        builder.append("three");
        break;
      case 4:
        builder.append("four");
        break;
      case 5:
        builder.append("five");
        break;
      case 6:
        builder.append("six");
        break;
      case 7:
        builder.append("seven");
        break;
      case 8:
        builder.append("eight");
        break;
      case 9:
        builder.append("nine");
        break;
      case 10:
        builder.append("ten");
        break;
      case 11:
        builder.append("eleven");
        break;
      case 12:
        builder.append("twelve");
        break;
      case 13:
        builder.append("thirteen");
        break;
      case 14:
        builder.append("fourteen");
        break;
      case 15:
        builder.append("quarter");
        break;
      case 16:
        builder.append("sixteen");
        break;
      case 17:
        builder.append("seventeen");
        break;
      case 18:
        builder.append("eighteen");
        break;
      case 19:
        builder.append("nineteen");
        break;
      case 20:
        builder.append("twenty");
        break;
      case 21:
        builder.append("twenty one");
        break;
      case 22:
        builder.append("twenty two");
        break;
      case 23:
        builder.append("twenty three");
        break;
      case 24:
        builder.append("twenty four");
        break;
      case 25:
        builder.append("twenty five");
        break;
      case 26:
        builder.append("twenty six");
        break;
      case 27:
        builder.append("twenty seven");
        break;
      case 28:
        builder.append("twenty eight");
        break;
      case 29:
        builder.append("twenty nine");
        break;
    }
  }
}
