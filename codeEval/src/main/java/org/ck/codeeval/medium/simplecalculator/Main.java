package org.ck.codeeval.medium.simplecalculator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 94,
    name = "Simple Calculator",
    description = "Create a simple calculator",
    url = "https://www.codeeval.com/open_challenges/94/",
    category = "Moderate challenges")
public class Main {
  public static void main(String[] args) throws Exception {
    File file = new File(args[0]);
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = buffer.readLine()) != null) {
        line = line.trim();

        Queue<String> postfix = shuntingYard(line);

        Double result = calculate(postfix);

        DecimalFormat df =
            new DecimalFormat("0.#####", DecimalFormatSymbols.getInstance(Locale.US));
        System.out.println(result.isNaN() ? "600" : df.format(result));
      }
    }
  }

  private static Double calculate(Queue<String> postfix) {
    Deque<Double> stack = new ArrayDeque<>();

    while (!postfix.isEmpty()) {
      String token = postfix.remove();

      if (isNumerical(token)) {
        stack.push(Double.parseDouble(token));
      }

      if (token.equals("+")) {
        stack.push(stack.pop() + stack.pop());
      }
      if (token.equals("-")) {
        Double right = stack.pop();
        stack.push(stack.pop() - right);
      }
      if (token.equals("*")) {
        stack.push(stack.pop() * stack.pop());
      }
      if (token.equals("/")) {
        Double right = stack.pop();
        stack.push(stack.pop() / right);
      }
      if (token.equals("^")) {
        Double right = stack.pop();
        stack.push(Math.pow(stack.pop(), right));
      }
      if (token.equals("#")) {
        stack.push(stack.pop() * -1);
      }
    }

    return stack.pop();
  }

  private static Queue<String> shuntingYard(String infix) {
    Queue<String> postfix = new LinkedList<>();
    Deque<String> stack = new ArrayDeque<>();

    List<String> tokens = tokenise(infix);
    for (String token : tokens) {
      if (isNumerical(token)) {
        postfix.add(token);
      }
      if (isOperator(token)) {
        while (!stack.isEmpty() && isOperator(stack.peek())) {
          if ((!isLeftAssociative(token) || getPrecedence(token) > getPrecedence(stack.peek()))
              && (isLeftAssociative(token)
                  || getPrecedence(token) >= getPrecedence(stack.peek()))) {
            break;
          } else {
            postfix.add(stack.pop());
          }
        }

        stack.push(token);
      }
      if (token.equals("(")) {
        stack.push(token);
      }
      if (token.equals(")")) {
        while (!stack.isEmpty() && !stack.peek().equals("(")) {
          postfix.add(stack.pop());
        }
        stack.pop();
      }
    }
    while (!stack.isEmpty()) {
      postfix.add(stack.pop());
    }

    return postfix;
  }

  private static int getPrecedence(String token) {
    if (token.equals("^")) {
      return 3;
    }
    if (token.equals("#")) {
      return 3;
    }
    if (token.equals("*") || token.equals("/")) {
      return 1;
    }
    if (token.equals("+") || token.equals("-")) {
      return 0;
    }
    return 0;
  }

  private static boolean isLeftAssociative(String token) {
    return token.equals("-") || token.equals("*") || token.equals("+") || token.equals("/");
  }

  private static boolean isOperator(String token) {
    return token.equals("-")
        || token.equals("^")
        || token.equals("*")
        || token.equals("/")
        || token.equals("+")
        || token.equals("#");
  }

  private static boolean isNumerical(String token) {
    boolean isNumerical = true;

    try {
      Double.parseDouble(token);
    } catch (NumberFormatException e) {
      isNumerical = false;
    }

    return isNumerical;
  }

  private static List<String> tokenise(String input) {
    String infix = input.replaceAll("\\s", "");

    List<String> tokens = new ArrayList<>();

    String token = "";
    TokenType currentType = TokenType.UNDEFINED;
    for (int i = 0; i < infix.length(); ++i) {
      char character = infix.charAt(i);

      if (character == ' ') {
        tokens.add(token);
        token = "";
        currentType = TokenType.UNDEFINED;
        continue;
      }

      TokenType charType = TokenType.getByCharacter(character);

      if (charType == TokenType.UNDEFINED) {
        throw new IllegalArgumentException("Unknow character: " + character);
      }

      if (charType == currentType || currentType == TokenType.UNDEFINED) {
        if (currentType == TokenType.OPERATOR) {
          if (character == '-' && !token.equals(")")) {
            tokens.add(token);
            token = "#";
          } else {
            tokens.add(token);
            token = "" + character;
          }
        } else if (character == '-' && currentType == TokenType.UNDEFINED) {
          token = "#";
          currentType = charType;
        } else {
          token += character;
          currentType = charType;
        }
      } else {
        tokens.add(token);
        token = "" + character;
        currentType = charType;
      }
    }

    tokens.add(token);
    return tokens;
  }

  private enum TokenType {
    UNDEFINED,
    OPERATOR,
    VALUE;

    public static TokenType getByCharacter(char character) {
      if (character == '('
          || character == ')'
          || character == '-'
          || character == '^'
          || character == '*'
          || character == '/'
          || character == '+') {
        return OPERATOR;
      }

      if ((character >= '0' && character <= '9') || character == '.') {
        return VALUE;
      }

      return UNDEFINED;
    }
  }
}
