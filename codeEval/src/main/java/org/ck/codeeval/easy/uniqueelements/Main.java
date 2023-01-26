package org.ck.codeeval.easy.uniqueelements;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Set;
import java.util.TreeSet;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 29,
    name = "Unique Elements",
    description = "Extract unique list from a sorted list of numbers.",
    url = "https://www.codeeval.com/open_challenges/29/",
    category = "Easy challenges")
public class Main {
  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        String[] numbers = line.split(",");

        Set<Integer> set = new TreeSet<>();

        for (String number : numbers) {
          set.add(Integer.valueOf(number));
        }

        StringBuilder builder = new StringBuilder();
        for (Integer number : set) {
          builder.append(number);
          builder.append(',');
        }
        builder.deleteCharAt(builder.length() - 1);

        System.out.println(builder);
      }
    }
  }
}
