package org.ck.codeeval.easy.timetoeat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 214,
    name = "Time to eat",
    description = "Sort timestamps in the right order.",
    url = "https://www.codeeval.com/open_challenges/214/",
    category = "Easy challenges")
public class Main {
  public static void main(String[] args) throws IOException {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        List<String> times = Arrays.asList(line.split(" "));
        Collections.sort(times);
        Collections.reverse(times);

        StringBuilder builder = new StringBuilder();
        for (String time : times) {
          builder.append(time);
          builder.append(" ");
        }

        if (builder.length() > 0) {
          builder.deleteCharAt(builder.length() - 1);
        }
        System.out.println(builder);
      }
    }
  }
}
