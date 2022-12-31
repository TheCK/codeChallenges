package org.ck.codeeval.hard.toounique;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 162,
    name = "Too unique",
    description = "Find and mark the biggest submatrices of unique elements.",
    url = "https://www.codeeval.com/open_challenges/162/",
    category = "Hard challenges")
public class Main {
  private static List<Matrix> subMatrices = new LinkedList<>();
  private static int maxSize = 0;

  private static char[][] matrix;

  private static Set<Character> letters;

  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      List<String> input = new ArrayList<>();

      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();

        input.add(line);
      }

      matrix = new char[input.size()][];
      int y = 0;

      for (String toConvert : input) {
        matrix[y++] = toConvert.toCharArray();
      }

      walk();
      erase();
      print();
    }
  }

  private static void print() {
    for (int y = 0; y < matrix.length; ++y) {
      StringBuilder builder = new StringBuilder();

      for (int x = 0; x < matrix[0].length; ++x) {
        builder.append(matrix[y][x]);
      }

      System.out.println(builder);
    }
  }

  private static void erase() {
    for (Matrix toErase : subMatrices) {
      for (int i = toErase.getX(); i <= toErase.getX() + toErase.getWidth(); ++i) {
        for (int j = toErase.getY(); j <= toErase.getY() + toErase.getHeight(); ++j) {
          matrix[j][i] = '*';
        }
      }
    }
  }

  private static void walk() {
    for (int x = 0; x < matrix[0].length; ++x) {
      for (int y = 0; y < matrix.length; ++y) {
        for (int width = 0; width + x < matrix[0].length; ++width) {
          for (int height = 0; height + y < matrix.length; ++height) {
            int size = (width + 1) * (height + 1);

            if (size >= maxSize) {
              if (isUnique(x, y, width, height)) {
                if (size > maxSize) {
                  maxSize = size;
                  subMatrices = new LinkedList<>();
                }

                subMatrices.add(new Matrix(x, y, width, height));
              }
            }
          }
        }
      }
    }
  }

  private static boolean isUnique(int x, int y, int width, int height) {
    if (letters != null) {
      letters.clear();
    } else {
      letters = new HashSet<>();
    }

    for (int i = x; i <= x + width; ++i) {
      for (int j = y; j <= y + height; ++j) {
        if (!letters.contains(matrix[j][i])) {
          letters.add(matrix[j][i]);
        } else {
          return false;
        }
      }
    }

    return true;
  }

  private static class Matrix {
    int x;
    int y;

    int width;
    int height;

    public Matrix(int x, int y, int width, int height) {
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
    }

    public int getX() {
      return x;
    }

    public int getY() {
      return y;
    }

    public int getWidth() {
      return width;
    }

    public int getHeight() {
      return height;
    }

    public int getSize() {
      return (width + 1) * (height + 1);
    }
  }
}
