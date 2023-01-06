package org.ck.hackerrank.languages.java.datastructures.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

@org.ck.codechallengelib.annotation.Solution(
    id = 40204008,
    name = "Java Stack",
    url = "https://www.hackerrank.com/challenges/java-stack",
    category = "Java",
    subCategory = "Data Structures")
public class Solution {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNext()) {
        String line = in.nextLine();

        boolean balanced = true;
        Deque<Character> stack = new ArrayDeque<>();
        for (char character : line.toCharArray()) {
          switch (character) {
            case '{', '(', '[' -> stack.push(character);
            case '}', ')', ']' -> {
              if (!stack.isEmpty()) {
                char match = stack.pop();
                if (match == '(' && character == ')' || character == match + 2) {
                  break;
                }
              }
              balanced = false;
            }
            default -> throw new IllegalStateException("Unexpected value: " + character);
          }

          if (!balanced) {
            break;
          }
        }

        System.out.println(balanced && stack.isEmpty());
      }
    }
  }
}
