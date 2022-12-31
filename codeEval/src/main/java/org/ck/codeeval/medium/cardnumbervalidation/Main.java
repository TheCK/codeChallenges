package org.ck.codeeval.medium.cardnumbervalidation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 172,
    name = "Card number validation",
    description = "Check if bank card numbers are valid.",
    url = "https://www.codeeval.com/open_challenges/172/",
    category = "Moderate challenges")
public class Main {
  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim().replaceAll(" ", "");

        Integer sum = 0;
        Integer count = 1;
        for (Integer i = line.length() - 1; i >= 0; --i) {
          if (count++ % 2 == 0) {
            Integer temp = 2 * Integer.valueOf(line.substring(i, i + 1));

            sum += (temp / 10) + (temp % 10);
          } else {
            sum += Integer.valueOf(line.substring(i, i + 1));
          }
        }

        System.out.println(sum % 10 == 0 ? 1 : 0);
      }
    }
  }
}
