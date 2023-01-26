package org.ck.codeeval.easy.slangflavor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 174,
    name = "Slang Flavor",
    description = "Add some slang to the text.",
    url = "https://www.codeeval.com/open_challenges/174/",
    category = "Easy challenges")
public class Main {
  public static void main(String[] args) throws IOException {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String[] inserts =
          new String[] {
            ", yeah!",
            ", this is crazy, I tell ya.",
            ", can U believe this?",
            ", eh?",
            ", aw yea.",
            ", yo.",
            "? No way!",
            ". Awesome!"
          };
      Integer insertsCounter = 0;
      Integer punktuationMarkCounter = 0;

      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();

        Pattern pattern = Pattern.compile(".*?[\\.\\?\\!]");
        Matcher matcher = pattern.matcher(line);

        StringBuilder builder = new StringBuilder();
        while (matcher.find()) {
          ++punktuationMarkCounter;
          String sentence = matcher.group().trim();

          if (punktuationMarkCounter % 2 == 0) {
            if (sentence.contains(".")) {
              sentence = sentence.replace(".", inserts[insertsCounter]);
            } else if (sentence.contains("!")) {
              sentence = sentence.replace("!", inserts[insertsCounter]);
            } else if (sentence.contains("?")) {
              sentence = sentence.replace("?", inserts[insertsCounter]);
            }
            builder.append(sentence);
            insertsCounter++;

            if (insertsCounter == inserts.length) {
              insertsCounter = 0;
            }
          } else {
            builder.append(sentence);
          }
          builder.append(' ');
        }
        builder.deleteCharAt(builder.length() - 1);

        System.out.println(builder);
      }
    }
  }
}
