package org.ck.codeeval.easy.realfake;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 227,
    name = "Real fake",
    description = "Check credit card numbers.",
    url = "https://www.codeeval.com/open_challenges/227/",
    category = "Easy challenges")
public class Main {
  public static void main(String[] args) throws IOException {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        line = line.replaceAll("\\s", "");
        char[] digits = line.toCharArray();

        int sum = 0;
        for (int i = 0; i < digits.length; i += 2) {
          sum += 2 * (digits[i] - 48);

          if (i + 1 < digits.length) {
            sum += (digits[i + 1] - 48);
          }
        }

        System.out.println(sum % 10 == 0 ? "Real" : "Fake");
      }
    }
  }
}
