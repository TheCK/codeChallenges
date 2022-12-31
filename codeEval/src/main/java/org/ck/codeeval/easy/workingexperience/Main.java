package org.ck.codeeval.easy.workingexperience;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 139,
    name = "Working experience",
    description = "Retrieve an actual value",
    url = "https://www.codeeval.com/open_challenges/139/",
    category = "Easy challenges")
public class Main {
  private static final Integer YEARS = 31;
  private static final Integer MONTHS = 12;

  public static void main(String[] args) throws Exception {
    compute(args);
  }

  private static void compute(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        String[] dates = line.split(";");

        boolean[][] months = new boolean[YEARS][MONTHS];

        for (String date : dates) {
          String[] borders = date.trim().split("-");
          String[] start = borders[0].trim().split(" ");
          String[] end = borders[1].trim().split(" ");

          Integer startMonth = getMonth(start[0]);
          Integer startYear = getYear(start[1]);

          Integer endMonth = getMonth(end[0]);
          Integer endYear = getYear(end[1]);

          while (true) {
            months[startYear][startMonth] = true;

            startMonth++;

            if (startMonth >= MONTHS) {
              startYear++;
              startMonth = 0;
            }

            if (startYear > endYear) {
              break;
            }
            if (startYear == endYear) {
              if (startMonth > endMonth) {
                break;
              }
            }
          }
        }

        Integer monthSum = 0;

        for (Integer year = 0; year < YEARS; ++year) {
          for (Integer month = 0; month < MONTHS; ++month) {
            if (months[year][month]) {
              monthSum++;
            }
          }
        }

        System.out.println(monthSum / 12);
      }
    }
  }

  private static Integer getYear(String year) {
    return Integer.valueOf(year) - 1990;
  }

  private static Integer getMonth(String month) {
    if ("Jan".equals(month)) {
      return 0;
    } else if ("Feb".equals(month)) {
      return 1;
    } else if ("Mar".equals(month)) {
      return 2;
    } else if ("Apr".equals(month)) {
      return 3;
    } else if ("May".equals(month)) {
      return 4;
    } else if ("Jun".equals(month)) {
      return 5;
    } else if ("Jul".equals(month)) {
      return 6;
    } else if ("Aug".equals(month)) {
      return 7;
    } else if ("Sep".equals(month)) {
      return 8;
    } else if ("Oct".equals(month)) {
      return 9;
    } else if ("Nov".equals(month)) {
      return 10;
    } else {
      return 11;
    }
  }
}
