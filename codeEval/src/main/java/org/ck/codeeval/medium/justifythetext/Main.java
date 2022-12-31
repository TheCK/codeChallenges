package org.ck.codeeval.medium.justifythetext;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 177,
    name = "Justify the Text",
    description = "Align the text to the specified width.",
    url = "https://www.codeeval.com/open_challenges/177/",
    category = "Moderate challenges")
public class Main {
  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        List<String> words = Arrays.asList(line.split(" "));

        StringBuilder builder = new StringBuilder();
        for (String word : words) {
          if (builder.length() + word.length() <= 80) {
            builder.append(word + " ");
          } else {
            builder.deleteCharAt(builder.length() - 1);

            int missing = 80 - builder.length();
            int spaces = builder.toString().split(" ").length - 1;
            int perSpace = missing / spaces;
            int surplus = missing % spaces;
            int start = 0;

            for (int j = 0; j < spaces; ++j) {
              int spacePos = builder.indexOf(" ", start);

              int spacesHere = perSpace + (surplus > j ? 1 : 0);

              for (int i = 0; i < spacesHere; ++i) {
                builder.insert(spacePos, " ");
              }

              start = spacePos + spacesHere + 2;
            }

            System.out.println(builder);
            builder = new StringBuilder(word + " ");
          }
        }

        if (builder.length() > 0) {
          builder.deleteCharAt(builder.length() - 1);
          System.out.println(builder);
        }
      }
    }
  }
}
