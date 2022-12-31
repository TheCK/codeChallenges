package org.ck.codeeval.easy.beautifulstrings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 83,
    name = "Beautiful Strings",
    description = "Facebook Hacker Cup 2013 problem.",
    url = "https://www.codeeval.com/open_challenges/83/",
    category = "Easy challenges")
public class Main {
  public static void main(String[] args) throws IOException {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();

        Map<String, Integer> letterCounts = new HashMap<>();
        for (int i = 0; i < line.length(); ++i) {
          String letter = line.substring(i, i + 1).toLowerCase();

          if (letter.matches("[a-z]")) {
            if (letterCounts.containsKey(letter)) {
              letterCounts.put(letter, letterCounts.get(letter) + 1);
            } else {
              letterCounts.put(letter, 1);
            }
          }
        }

        List<Integer> counts = new ArrayList<>();
        counts.addAll(letterCounts.values());

        Collections.sort(counts);
        Collections.reverse(counts);

        Integer currentMax = 26;
        Integer sum = 0;
        for (Integer count : counts) {
          sum += count * currentMax--;
        }

        System.out.println(sum);
      }
    }
  }
}
