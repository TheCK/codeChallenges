package org.ck.codeeval.easy.happynumbers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 39,
    name = "Happy Numbers",
    description = "Determine if a number is a happy number or not",
    url = "https://www.codeeval.com/open_challenges/39/",
    category = "Easy challenges")
public class Main {

  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        Set<String> numbers = new HashSet<>();
        boolean happy = true;

        while (!"1".equals(line)) {
          line = happy(line);

          if (numbers.contains(line)) {
            happy = false;
            break;
          }

          numbers.add(line);
        }

        System.out.println(happy ? 1 : 0);
      }
    }
  }

  private static String happy(String line) {
    int sum = 0;

    for (int i = 0; i < line.length(); ++i) {
      int num = Integer.parseInt(line.substring(i, i + 1));

      sum += num * num;
    }

    return Integer.toString(sum);
  }
}
