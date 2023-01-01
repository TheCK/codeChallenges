package org.ck.codeeval.medium.sortmatrixcolums;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 200,
    name = "Sort matrix columns",
    description = "Sort matrix columns from lowest to highest numbers",
    url = "https://www.codeeval.com/open_challenges/200/",
    category = "Moderate challenges")
public class Main {
  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        String[] matrixLines = line.split("\\|");

        List<Vector> matrix = new ArrayList<>();

        for (String matrixLine : matrixLines) {
          String[] matrixValues = matrixLine.trim().split(" ");

          for (int i = 0; i < matrixValues.length; ++i) {
            if (matrix.size() <= i) {
              matrix.add(new Vector());
            }

            matrix.get(i).add(Integer.valueOf(matrixValues[i]));
          }
        }

        Collections.sort(matrix);
        print(matrix);
      }
    }
  }

  private static void print(List<Vector> matrix) {
    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < matrix.get(0).size(); ++i) {
      for (Vector integers : matrix) {
        builder.append(integers.get(i));
        builder.append(" ");
      }

      builder.append("| ");
    }

    if (builder.length() >= 3) {
      builder.deleteCharAt(builder.length() - 1);
      builder.deleteCharAt(builder.length() - 1);
      builder.deleteCharAt(builder.length() - 1);
    }
    System.out.println(builder);
  }

  private static class Vector extends ArrayList<Integer> implements Comparable<Vector> {
    @Override
    public int compareTo(Vector other) {
      int comparison = 0;
      int count = 0;

      while (comparison == 0 && count < this.size()) {
        comparison = this.get(count).compareTo(other.get(count));

        ++count;
      }

      return comparison;
    }
  }
}
