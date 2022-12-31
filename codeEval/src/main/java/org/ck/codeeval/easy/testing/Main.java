package org.ck.codeeval.easy.testing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 225,
    name = "Testing",
    description = "Wanna try to be a tester?",
    url = "https://www.codeeval.com/open_challenges/225/",
    category = "Easy challenges")
public class Main {
  public static void main(String[] args) throws IOException {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        String[] arguments = line.split("\\|");

        String current = arguments[0].trim();
        String expected = arguments[1].trim();

        int bugs = 0;
        for (int i = 0; i < current.length(); ++i) {
          if (current.charAt(i) != expected.charAt(i)) {
            ++bugs;
          }
        }

        if (bugs == 0) {
          System.out.println("Done");
        } else if (bugs <= 2) {
          System.out.println("Low");
        } else if (bugs <= 4) {
          System.out.println("Medium");
        } else if (bugs <= 6) {
          System.out.println("High");
        } else {
          System.out.println("Critical");
        }
      }
    }
  }
}
