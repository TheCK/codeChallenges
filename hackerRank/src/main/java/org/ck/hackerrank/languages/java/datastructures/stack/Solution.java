package org.ck.hackerrank.languages.java.datastructures.stack;

import java.util.Scanner;
import java.util.Stack;

@org.ck.codeChallengeLib.annotation.Solution(
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
        Stack<Character> stack = new Stack<>();
        for (char character : line.toCharArray()) {
          switch (character) {
            case '{':
            case '(':
            case '[':
              stack.push(character);
              break;
            case '}':
            case ')':
            case ']':
              if (!stack.isEmpty()) {
                char match = stack.pop();
                if (match == '(' && character == ')' || character == match + 2) {
                  break;
                }
              }
              balanced = false;
              break;
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
