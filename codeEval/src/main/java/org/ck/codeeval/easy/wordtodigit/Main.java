package org.ck.codeeval.easy.wordtodigit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 104,
    name = "Word to Digit",
    description = "Substitute words to digits",
    url = "https://www.codeeval.com/open_challenges/104/",
    category = "Easy challenges")
public class Main {
  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        String[] numbers = line.split(";");

        StringBuilder builder = new StringBuilder();
        for (String number : numbers) {
          if ("zero".equals(number)) {
            builder.append(0);
          }
          if ("one".equals(number)) {
            builder.append(1);
          }
          if ("two".equals(number)) {
            builder.append(2);
          }
          if ("three".equals(number)) {
            builder.append(3);
          }
          if ("four".equals(number)) {
            builder.append(4);
          }
          if ("five".equals(number)) {
            builder.append(5);
          }
          if ("six".equals(number)) {
            builder.append(6);
          }
          if ("seven".equals(number)) {
            builder.append(7);
          }
          if ("eight".equals(number)) {
            builder.append(8);
          }
          if ("nine".equals(number)) {
            builder.append(9);
          }
        }

        System.out.println(builder);
      }
    }
  }
}
