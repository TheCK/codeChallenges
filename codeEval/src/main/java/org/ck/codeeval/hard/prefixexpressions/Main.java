package org.ck.codeeval.hard.prefixexpressions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 7,
    name = "Prefix expressions",
    description = "Evaluating a prefix expression.",
    url = "https://www.codeeval.com/open_challenges/7/",
    category = "Hard challenges")
public class Main {
  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();
        String[] arguments = line.split(" ");

        Deque<String> operators = new ArrayDeque<>();
        LinkedList<Double> operands = new LinkedList<>();

        for (String argument : arguments) {
          if ("+".equals(argument) || "*".equals(argument) || "/".equals(argument)) {
            operators.push(argument);
          } else {
            operands.add(Double.valueOf(argument));
          }
        }

        while (operands.size() > 1) {
          Double operand1 = operands.removeFirst();
          Double operand2 = operands.removeFirst();

          double result =
              switch (operators.pop()) {
                case "+" -> operand1 + operand2;
                case "*" -> operand1 * operand2;
                case "/" -> operand1 / operand2;
                default -> 0D;
              };

          operands.push(result);
        }

        System.out.println((int) (double) operands.pop());
      }
    }
  }
}
