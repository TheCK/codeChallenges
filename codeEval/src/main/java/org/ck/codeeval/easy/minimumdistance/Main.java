package org.ck.codeeval.easy.minimumdistance;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 189,
    name = "Minimum Distance",
    description = "Find a point with the smallest sum of distances to every given point.",
    url = "https://www.codeeval.com/open_challenges/189/",
    category = "Easy challenges")
public class Main {

  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();

        Pattern p = Pattern.compile("(\\-?\\d+)");
        Matcher m = p.matcher(line);

        m.find();
        int count = Integer.valueOf(m.group());

        int[] numbers = new int[count];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < count; ++i) {
          m.find();
          numbers[i] = Integer.valueOf(m.group());

          min = Math.min(min, numbers[i]);
          max = Math.max(max, numbers[i]);
        }

        int idealSum = Integer.MAX_VALUE;
        for (int i = min; i <= max; ++i) {
          int sum = 0;

          for (int number : numbers) {
            sum += Math.abs(i - number);
          }

          idealSum = Math.min(sum, idealSum);
        }

        System.out.println(idealSum);
      }
    }
  }
}
