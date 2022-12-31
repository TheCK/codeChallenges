package org.ck.codeeval.easy.onezerotwozeros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 217,
    name = "One zero, two zeros...",
    description = "Count zeros in a binary system.",
    url = "https://www.codeeval.com/open_challenges/217/",
    category = "Easy challenges")
public class Main {
  public static void main(String[] args) throws IOException {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        String[] arguments = line.split(" ");

        int wantedZeroCount = Integer.parseInt(arguments[0]);
        int max = Integer.parseInt(arguments[1]);

        int count = 0;
        for (int i = 1; i <= max; ++i) {
          int currentOneCount = Integer.bitCount(i);
          int binaryLength = Integer.toBinaryString(i).length();

          if (wantedZeroCount == (binaryLength - currentOneCount)) {
            ++count;
          }
        }

        System.out.println(count);
      }
    }
  }
}
