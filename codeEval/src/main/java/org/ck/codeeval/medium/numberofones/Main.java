package org.ck.codeeval.medium.numberofones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 16,
    name = "Number of Ones",
    description = "Determine the number of one bits in an integer.",
    url = "https://www.codeeval.com/open_challenges/16/",
    category = "Moderate challenges")
public class Main {
  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        Integer number = Integer.valueOf(line);

        System.out.println(Integer.bitCount(number));
      }
    }
  }
}
