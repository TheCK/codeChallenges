package org.ck.codeeval.hard.stringlist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Set;
import java.util.TreeSet;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 38,
    name = "String List",
    description = "Create a new string from constituent alphabets",
    url = "https://www.codeeval.com/open_challenges/38/",
    category = "Hard challenges")
public class Main {
  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        String[] arguments = line.split(",");

        int length = Integer.parseInt(arguments[0]);
        Set<String> alphabet = new TreeSet<>();

        for (int i = 0; i < arguments[1].length(); ++i) {
          alphabet.add(arguments[1].substring(i, i + 1));
        }

        Set<String> possibleWords = new TreeSet<>();

        buildWords(possibleWords, alphabet, length, "");

        StringBuilder builder = new StringBuilder();
        for (String word : possibleWords) {
          builder.append(word + ",");
        }

        if (builder.length() > 0) {
          builder.deleteCharAt(builder.length() - 1);
        }
        System.out.println(builder);
      }
    }
  }

  private static void buildWords(
      Set<String> possibleWords, Set<String> alphabet, int length, String soFar) {
    if (length == 0) {
      possibleWords.add(soFar);
      return;
    }

    for (String letter : alphabet) {
      buildWords(possibleWords, alphabet, length - 1, soFar + letter);
    }
  }
}
