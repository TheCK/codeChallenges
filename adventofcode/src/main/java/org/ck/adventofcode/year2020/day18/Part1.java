package org.ck.adventofcode.year2020.day18;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.Scanner;
import java.util.Stack;

@Solution(
    id = 20201801,
    name = "Day 18: Operation Order",
    url = "https://adventofcode.com/2020/day/18",
    category = "2020")
public class Part1 {
  public static void main(String[] args) {
    long result = 0;

    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String line = in.nextLine();

        long lineResult = 0;
        char operand = '\0';

        Stack<Character> operandStack = new Stack<>();
        Stack<Long> valueStack = new Stack<>();

        for (char character : line.trim().toCharArray()) {
          switch (character) {
            case ' ':
              break;
            case '+':
            case '*':
              operand = character;
              break;
            case '(':
              operandStack.push(operand);
              operand = '\0';
              valueStack.push(lineResult);
              lineResult = 0;
              break;
            case ')':
              switch (operandStack.pop()) {
                case '+':
                  lineResult += valueStack.pop();
                  break;
                case '*':
                  lineResult *= valueStack.pop();
                  break;
                default:
                  valueStack.pop();
                  lineResult = lineResult;
                  break;
              }
              break;
            default:
              switch (operand) {
                case '+':
                  lineResult += character - '0';
                  break;
                case '*':
                  lineResult *= character - '0';
                  break;
                default:
                  lineResult = character - '0';
                  break;
              }
              break;
          }
        }

        result += lineResult;
      }
    }

    System.out.println(result);
  }
}
