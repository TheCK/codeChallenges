package org.ck.codeeval.easy.fizzbuzz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 1,
    name = "Fizz Buzz",
    description = "A simple game involving divisibility tests.",
    url = "https://www.codeeval.com/open_challenges/1/",
    category = "Easy challenges")
public class Main {

  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        String[] numbers = line.split(" ");

        int firstDivider = Integer.parseInt(numbers[0]);
        int secondDivider = Integer.parseInt(numbers[1]);
        int maxCount = Integer.parseInt(numbers[2]);

        StringBuilder outputLine = new StringBuilder();
        for (int i = 1; i <= maxCount; ++i) {
          if (i % firstDivider == 0) {
            outputLine.append('F');
          }
          if (i % secondDivider == 0) {
            outputLine.append('B');
          }
          if (i % firstDivider != 0 && i % secondDivider != 0) {
            outputLine.append(i);
          }

          outputLine.append(' ');
        }

        outputLine.deleteCharAt(outputLine.length() - 1);
        System.out.println(outputLine);
      }
    }
  }
}
