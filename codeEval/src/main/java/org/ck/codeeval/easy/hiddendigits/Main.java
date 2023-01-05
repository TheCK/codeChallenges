package org.ck.codeeval.easy.hiddendigits;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 122,
    name = "Hidden Digits",
    description = "Try to look behind the scenes",
    url = "https://www.codeeval.com/open_challenges/122/",
    category = "Easy challenges")
public class Main {
  public static void main(String[] args) throws IOException {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < line.length(); ++i) {
          if (line.charAt(i) == 'a') {
            builder.append("0");
          } else if (line.charAt(i) == 'b') {
            builder.append("1");
          } else if (line.charAt(i) == 'c') {
            builder.append("2");
          } else if (line.charAt(i) == 'd') {
            builder.append("3");
          } else if (line.charAt(i) == 'e') {
            builder.append("4");
          } else if (line.charAt(i) == 'f') {
            builder.append("5");
          } else if (line.charAt(i) == 'g') {
            builder.append("6");
          } else if (line.charAt(i) == 'h') {
            builder.append("7");
          } else if (line.charAt(i) == 'i') {
            builder.append("8");
          } else if (line.charAt(i) == 'j') {
            builder.append("9");
          } else if (line.substring(i, i + 1).matches("\\d")) {
            builder.append(line.charAt(i));
          }
        }

        if (builder.length() == 0) {
          builder.append("NONE");
        }
        System.out.println(builder);
      }
    }
  }
}
