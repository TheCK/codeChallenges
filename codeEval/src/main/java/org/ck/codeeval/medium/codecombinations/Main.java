package org.ck.codeeval.medium.codecombinations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 238,
    name = "Code combinations",
    description = "Check whether you can make words from the given letters.",
    url = "https://www.codeeval.com/open_challenges/238/",
    category = "Moderate challenges")
public class Main {
  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        String[] arrayLines = line.split("\\|");

        for (int i = 0; i < arrayLines.length; ++i) {
          arrayLines[i] = arrayLines[i].trim();
        }

        int codesInArray = 0;

        for (int i = 0; i < arrayLines.length - 1; ++i) {
          for (int j = 0; j < arrayLines[0].length() - 1; ++j) {
            Set<String> lettersFound = new HashSet<>();

            lettersFound.add(arrayLines[i].substring(j, j + 1));
            lettersFound.add(arrayLines[i + 1].substring(j, j + 1));
            lettersFound.add(arrayLines[i].substring(j + 1, j + 2));
            lettersFound.add(arrayLines[i + 1].substring(j + 1, j + 2));

            if (lettersFound.size() == 4
                && lettersFound.contains("c")
                && lettersFound.contains("o")
                && lettersFound.contains("d")
                && lettersFound.contains("e")) {
              ++codesInArray;
            }
          }
        }

        System.out.println(codesInArray);
      }
    }
  }
}
