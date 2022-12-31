package org.ck.codeeval.easy.evennumbers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 100,
    name = "Even Numbers",
    description = "Determine if a number is even or not",
    url = "https://www.codeeval.com/open_challenges/100/",
    category = "Easy challenges")
public class Main {

  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();

        System.out.println(Integer.valueOf(line) % 2 == 0 ? 1 : 0);
      }
    }
  }
}
