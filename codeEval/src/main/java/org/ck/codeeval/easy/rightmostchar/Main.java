package org.ck.codeeval.easy.rightmostchar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 31,
    name = "Rightmost Char",
    description = "Print the position of the rightmost occurrence of a char.",
    url = "https://www.codeeval.com/open_challenges/31/",
    category = "Easy challenges")
public class Main {

  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        String[] lineArgs = line.split(",");

        System.out.println(lineArgs[0].lastIndexOf(lineArgs[1]));
      }
    }
  }
}
