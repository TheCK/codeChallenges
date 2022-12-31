package org.ck.codeeval.easy.sumofintegersfromfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 24,
    name = "Sum of Integers from File",
    description = "Print the sum of integers read from a file.",
    url = "https://www.codeeval.com/open_challenges/24/",
    category = "Easy challenges")
public class Main {

  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      Integer sum = 0;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();

        sum += Integer.valueOf(line);
      }

      System.out.println(sum);
    }
  }
}
