package org.ck.codeeval.medium.meetcocktailsort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 231,
    name = "Meet Cocktail sort",
    description = "Learn more about cocktail sort algorithm.",
    url = "https://www.codeeval.com/open_challenges/231/",
    category = "Moderate challenges")
public class Main {
  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        String[] arguments = line.split("\\|");

        List<Integer> array =
            Arrays.stream(arguments[0].trim().split(" "))
                .map(x -> Integer.valueOf(x))
                .collect(Collectors.toList());

        for (int i = 0; i < Integer.valueOf(arguments[1].trim()); ++i) {
          for (int j = 0; j < array.size() - 1; ++j) {
            if (array.get(j).compareTo(array.get(j + 1)) > 0) {
              Integer temp = array.get(j);
              array.set(j, array.get(j + 1));
              array.set(j + 1, temp);
            }
          }

          for (int j = array.size() - 2; j >= 0; --j) {
            if (array.get(j).compareTo(array.get(j + 1)) > 0) {
              Integer temp = array.get(j);
              array.set(j, array.get(j + 1));
              array.set(j + 1, temp);
            }
          }
        }

        System.out.println(array.stream().map(x -> x.toString()).collect(Collectors.joining(" ")));
      }
    }
  }
}
