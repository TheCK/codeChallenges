package org.ck.codingame.practice.easy.unary;

import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 101007,
    name = "Unary",
    url = "https://www.codingame.com/ide/puzzle/unary",
    category = "Practice",
    subCategory = "Easy")
public class Solution {
  public static void main(String args[]) {
    try (Scanner in = new Scanner(System.in)) {
      String message = in.nextLine();

      StringBuilder binary = new StringBuilder();
      for (char character : message.toCharArray()) {
        final String binaryChar = Integer.toString(character, 2);
        binary.append("0".repeat(7 - binaryChar.length())).append(binaryChar);
      }

      StringBuilder output = new StringBuilder();
      char last = ' ';
      int count = 0;
      for (int i = 0; i < binary.length(); ++i) {
        if (last == binary.charAt(i)) {
          ++count;
          continue;
        }

        if (count > 0) {
          output.append(last == '1' ? "0 " : "00 ").append("0".repeat(count)).append(' ');
        }

        count = 1;
        last = binary.charAt(i);
      }
      output.append(last == '1' ? "0 " : "00 ").append("0".repeat(count));

      System.out.println(output);
    }
  }
}
