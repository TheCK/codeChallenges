package org.ck.codeeval.easy.jugglingwithzeros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 149,
    name = "Juggling With Zeros",
    description = "Convert a zero-based number into integer.",
    url = "https://www.codeeval.com/open_challenges/149/",
    category = "Easy challenges")
public class Main {

  public static void main(String[] args) throws IOException {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        String[] numbers = line.split(" ");

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numbers.length; i += 2) {
          if ("0".equals(numbers[i])) {
            builder.append(numbers[i + 1]);
          }
          if ("00".equals(numbers[i])) {
            builder.append(numbers[i + 1].replace('0', '1'));
          }
        }

        System.out.println(Long.valueOf(builder.toString(), 2));
      }
    }
  }
}
