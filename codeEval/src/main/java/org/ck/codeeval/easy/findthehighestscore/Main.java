package org.ck.codeeval.easy.findthehighestscore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 208,
    name = "Find the highest score",
    description = "Find the highest rate in the table",
    url = "https://www.codeeval.com/open_challenges/208/",
    category = "Easy challenges")
public class Main {
  public static void main(String[] args) throws IOException {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        String[] rows = line.split("\\|");

        List<Integer> highScores = new ArrayList<>();
        for (String row : rows) {
          String[] numbers = row.trim().split(" ");

          for (int i = 0; i < numbers.length; ++i) {
            Integer number = Integer.valueOf(numbers[i]);

            if (i == highScores.size()) {
              highScores.add(number);
            } else {
              if (highScores.get(i) < number) {
                highScores.set(i, number);
              }
            }
          }
        }

        StringBuilder builder = new StringBuilder();
        for (Integer highScore : highScores) {
          builder.append(highScore);
          builder.append(' ');
        }

        if (builder.length() > 0) {
          builder.deleteCharAt(builder.length() - 1);
        }
        System.out.println(builder);
      }
    }
  }
}
