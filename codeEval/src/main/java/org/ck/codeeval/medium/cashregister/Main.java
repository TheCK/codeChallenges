package org.ck.codeeval.medium.cashregister;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 54,
    name = "Cash Register",
    description = "Determine the amount of change to be returned",
    url = "https://www.codeeval.com/open_challenges/54/",
    category = "Moderate challenges")
public class Main {
  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        String[] arguments = line.split(";");

        Integer amount = (int) (Float.valueOf(arguments[0]) * 100);
        Integer payment = (int) (Float.valueOf(arguments[1]) * 100);

        Integer remainder = payment - amount;

        if (remainder < 0) {
          System.out.println("ERROR");
          continue;
        } else if (remainder == 0) {
          System.out.println("ZERO");
          continue;
        }

        StringBuilder builder = new StringBuilder();
        while (remainder != 0) {
          if (remainder >= 10000) {
            remainder -= 10000;
            builder.append("ONE HUNDRED,");
            continue;
          } else if (remainder >= 5000) {
            remainder -= 5000;
            builder.append("FIFTY,");
            continue;
          } else if (remainder >= 2000) {
            remainder -= 2000;
            builder.append("TWENTY,");
            continue;
          } else if (remainder >= 1000) {
            remainder -= 1000;
            builder.append("TEN,");
            continue;
          } else if (remainder >= 500) {
            remainder -= 500;
            builder.append("FIVE,");
            continue;
          } else if (remainder >= 200) {
            remainder -= 200;
            builder.append("TWO,");
            continue;
          } else if (remainder >= 100) {
            remainder -= 100;
            builder.append("ONE,");
            continue;
          } else if (remainder >= 50) {
            remainder -= 50;
            builder.append("HALF DOLLAR,");
            continue;
          } else if (remainder >= 25) {
            remainder -= 25;
            builder.append("QUARTER,");
            continue;
          } else if (remainder >= 10) {
            remainder -= 10;
            builder.append("DIME,");
            continue;
          } else if (remainder >= 5) {
            remainder -= 5;
            builder.append("NICKEL,");
            continue;
          } else if (remainder >= 1) {
            remainder -= 1;
            builder.append("PENNY,");
            continue;
          }
        }

        builder.deleteCharAt(builder.length() - 1);
        System.out.println(builder);
      }
    }
  }
}
