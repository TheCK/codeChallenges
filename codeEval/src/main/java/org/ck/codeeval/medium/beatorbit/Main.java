package org.ck.codeeval.medium.beatorbit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 236,
    name = "Beat or bit",
    description = "Learn more about the Gray code algorithm.",
    url = "https://www.codeeval.com/open_challenges/236/",
    category = "Moderate challenges")
public class Main {
  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        String[] numbers = line.split(" \\| ");

        System.out.println(
            Arrays.asList(numbers).stream()
                .map(Main::grayToDecimal)
                .map(decimal -> decimal.toString())
                .collect(Collectors.joining(" | ")));
      }
    }
  }

  private static Integer grayToDecimal(String gray) {
    if (gray.length() == 0) {
      return 0;
    }

    if (gray.charAt(0) == '1') {
      return (int) Math.pow(2, gray.length()) - grayToDecimal(gray.substring(1, gray.length())) - 1;
    }

    return grayToDecimal(gray.substring(1, gray.length()));
  }
}
