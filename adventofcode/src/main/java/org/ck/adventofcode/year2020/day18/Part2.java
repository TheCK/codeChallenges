package org.ck.adventofcode.year2020.day18;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import org.ck.codeChallengeLib.annotation.Solution;

@Solution(
    id = 20201802,
    name = "Day 18: Operation Order - Part 2",
    url = "https://adventofcode.com/2020/day/18",
    category = "2020")
public class Part2 {
  public static void main(String[] args) {
    long result = 0;

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String line = in.nextLine();

        Queue<Object> rpn = new ArrayDeque<>();
        Stack<Character> stack = new Stack<>();

        for (char character : line.trim().toCharArray()) {
          switch (character) {
            case ' ':
              break;
            case '+':
            case '*':
              while (!stack.isEmpty() && stack.peek() != '(') {
                if (character <= stack.peek()) {
                  rpn.add(stack.pop());
                  continue;
                }
                break;
              }
              stack.push(character);
              break;
            case '(':
              stack.push(character);
              break;
            case ')':
              while (!stack.isEmpty() && stack.peek() != '(') {
                rpn.add(stack.pop());
              }
              stack.pop();
              break;
            default:
              rpn.add((long) character - '0');
              break;
          }
        }

        while (!stack.empty()) {
          rpn.add(stack.pop());
        }

        Stack<Object> rpnStack = new Stack<>();
        for (Object token : rpn) {
          if (token instanceof Long) {
            rpnStack.push(token);
          } else if (token instanceof Character) {
            if ((Character) token == '+') {
              rpnStack.push((Long) rpnStack.pop() + (Long) rpnStack.pop());
            } else {
              rpnStack.push((Long) rpnStack.pop() * (Long) rpnStack.pop());
            }
          }
        }

        result += (Long) rpnStack.pop();
      }
    }

    System.out.println(result);
  }
}
