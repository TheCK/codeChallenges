package org.ck.hackerrank.corecs.algorithms.implementation.encryption;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 10238,
    name = "Encryption",
    url = "https://www.hackerrank.com/challenges/encryption",
    category = "Algorithms",
    subCategory = "Implementation")
public class Solution {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      String text = in.nextLine();

      int minLength = (int) Math.floor(Math.sqrt(text.length()));

      int rows = minLength;
      int columns = minLength;

      if (rows * columns < text.length()) {
        ++columns;
      }

      if (rows * columns < text.length()) {
        ++rows;
      }

      char[][] array = new char[rows][columns];
      for (int i = 0; i < rows; ++i) {
        for (int j = 0; j < columns; ++j) {
          if (columns * i + j < text.length()) {
            array[i][j] = text.charAt(columns * i + j);
          } else {
            array[i][j] = '\0';
          }
        }
      }

      StringBuilder encrypted = new StringBuilder();
      for (int j = 0; j < columns; ++j) {
        for (int i = 0; i < rows; ++i) {
          if (array[i][j] != '\0') {
            encrypted.append(array[i][j]);
          }
        }

        if (j < columns - 1) {
          encrypted.append(' ');
        }
      }

      System.out.println(encrypted);
    }
  }
}
