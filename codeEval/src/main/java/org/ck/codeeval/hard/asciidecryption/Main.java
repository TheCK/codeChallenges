package org.ck.codeeval.hard.asciidecryption;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 155,
    name = "ASCII Decryption",
    description = "Decrypt a message.",
    url = "https://www.codeeval.com/open_challenges/155/",
    category = "Hard challenges")
public class Main {
  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        String[] arguments = line.split("\\|");

        int length = Integer.parseInt(arguments[0].trim());
        char letter = arguments[1].trim().charAt(0);
        String[] coded = arguments[2].trim().split(" ");

        List<Integer> lastAscii = getLastAscii(coded, length);

        for (Integer candidate : lastAscii) {
          int diff = candidate - letter;

          StringBuilder builder = new StringBuilder();
          for (String codedLetter : coded) {
            int codedAscii = Integer.parseInt(codedLetter);
            int realAscii = codedAscii - diff;

            builder.append((char) realAscii);
          }

          String message = builder.toString();

          if (message.matches("[a-zA-Z0-9 \\.\\?!\\-]+")) {
            System.out.println(message);
            return;
          }
        }
      }
    }
  }

  private static List<Integer> getLastAscii(String[] coded, int length) {
    Map<String, Integer> groupCounts = new HashMap<>();

    for (int start = 0; start < coded.length - length; ++start) {
      StringBuilder builder = new StringBuilder();

      for (int current = start; current < start + length; ++current) {
        builder.append(coded[current] + " ");
      }

      if (builder.length() > 0) {
        builder.deleteCharAt(builder.length() - 1);
      }

      String groupString = builder.toString();

      if (groupCounts.containsKey(groupString)) {
        groupCounts.put(groupString, groupCounts.get(groupString) + 1);
      } else {
        groupCounts.put(groupString, 1);
      }
    }

    List<Integer> candidats = new ArrayList<>();

    for (String groupString : groupCounts.keySet()) {
      if (groupCounts.get(groupString).equals(2)) {
        String[] elements = groupString.split(" ");

        candidats.add(Integer.parseInt(elements[length - 1]));
      }
    }

    return candidats;
  }
}
