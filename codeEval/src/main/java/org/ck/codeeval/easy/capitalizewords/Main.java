package org.ck.codeeval.easy.capitalizewords;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 93,
    name = "Capitalize Words",
    description = "Capitalize words in a sentence",
    url = "https://www.codeeval.com/open_challenges/93/",
    category = "Easy challenges")
public class Main {

  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        String[] words = line.split(" ");

        StringBuilder builder = new StringBuilder();
        for (String word : words) {
          builder.append(capWord(word));
          builder.append(" ");
        }

        builder.deleteCharAt(builder.length() - 1);
        System.out.println(builder);
      }
    }
  }

  private static Object capWord(String word) {
    if (word.length() == 1) {
      return word.toUpperCase();
    }

    return word.substring(0, 1).toUpperCase() + word.substring(1);
  }
}
