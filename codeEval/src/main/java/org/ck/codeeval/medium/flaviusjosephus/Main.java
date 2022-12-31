package org.ck.codeeval.medium.flaviusjosephus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 75,
    name = "Flavius Josephus",
    description = "Eliminate every i'th item from a circular list.",
    url = "https://www.codeeval.com/open_challenges/75/",
    category = "Moderate challenges")
public class Main {
  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        String[] arguments = line.split(",");

        Integer size = Integer.valueOf(arguments[0]);
        Integer n = Integer.valueOf(arguments[1]);

        Integer index = 0;
        Integer value = 0;
        Integer count = 0;

        Integer[] array = new Integer[size];
        while (value < size) {
          if (array[index] == null) {
            count++;
            if (count == n) {
              count = 0;
            }
          }

          if (count == 0 && array[index] == null) {
            array[index] = value++;
          }

          ++index;
          if (index % size == 0) {
            index = 0;
          }
        }

        StringBuilder builder = new StringBuilder();
        for (Integer i = 0; i < size; ++i) {
          for (Integer j = 0; j < size; ++j) {
            if (array[j] == i) {
              builder.append(j + " ");
              break;
            }
          }
        }

        if (builder.length() > 0) {
          builder.deleteCharAt(builder.length() - 1);
        }
        System.out.println(builder);
      }
    }
  }
}
