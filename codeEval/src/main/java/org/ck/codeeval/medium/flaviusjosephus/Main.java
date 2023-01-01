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

        int size = Integer.parseInt(arguments[0]);
        int n = Integer.parseInt(arguments[1]);

        int index = 0;
        int value = 0;
        int count = 0;

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
        for (int i = 0; i < size; ++i) {
          for (int j = 0; j < size; ++j) {
            if (array[j] == i) {
              builder.append(j).append(" ");
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
