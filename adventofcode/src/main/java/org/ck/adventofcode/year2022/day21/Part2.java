package org.ck.adventofcode.year2022.day21;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BinaryOperator;

@Solution(
    id = 20222102,
    name = "Day 21: Monkey Math - Part 2",
    url = "https://adventofcode.com/2022/day/21#part2",
    category = "2022")
public class Part2 {
  public static void main(String[] args) {
    Map<String, Operation> operations = new HashMap<>();
    Map<String, Long> values = new HashMap<>();
    try (Scanner in = new Scanner(System.in)) {
      while (in.hasNextLine()) {
        String[] line = in.nextLine().split(" ");

        if (line.length == 2) {
          values.put(line[0].substring(0, 4), Long.parseLong(line[1]));
        } else {
          operations.put(
              line[0].substring(0, 4),
              new Operation(
                  line[1],
                  line[2].charAt(0),
                  line[3],
                  getOperation(line[2]),
                  getSolveForOne(line[2]),
                  getSolveForTwo(line[2])));
        }
      }
    }

    Operation oldRoot = operations.get("root");
    operations.put(
        "root",
        new Operation(
            oldRoot.operandOne(),
            '=',
            oldRoot.operandTwo(),
            (one, two) -> one.equals(two) ? 1L : 0L,
            (result, two) -> two,
            (result, one) -> one));
    values.remove("humn");

    boolean calculatedValue = true;
    while (calculatedValue) {
      calculatedValue = false;
      Iterator<String> iterator = operations.keySet().iterator();
      while (iterator.hasNext()) {
        String monkey = iterator.next();
        Operation operation = operations.get(monkey);

        if (values.containsKey(operation.operandOne())
            && values.containsKey(operation.operandTwo())) {
          calculatedValue = true;
          values.put(
              monkey,
              operation.calculate(
                  values.get(operation.operandOne()), values.get(operation.operandTwo())));
          iterator.remove();
        }
      }
    }

    values.put("root", 1L);

    boolean solvedForValue = true;
    while (solvedForValue) {
      solvedForValue = false;
      Iterator<String> iterator = operations.keySet().iterator();
      while (iterator.hasNext()) {
        String monkey = iterator.next();
        Operation operation = operations.get(monkey);

        if (values.containsKey(monkey) && values.containsKey(operation.operandOne())) {
          solvedForValue = true;
          values.put(
              operation.operandTwo(),
              operation.solveForTwo(values.get(monkey), values.get(operation.operandOne())));
          iterator.remove();
        } else if (values.containsKey(monkey) && values.containsKey(operation.operandTwo())) {
          solvedForValue = true;
          values.put(
              operation.operandOne(),
              operation.solveForOne(values.get(monkey), values.get(operation.operandTwo())));
          iterator.remove();
        }
      }
    }

    System.out.println(values.get("humn"));
  }

  private static BinaryOperator<Long> getOperation(final String symbol) {
    return switch (symbol) {
      case "+" -> Long::sum;
      case "-" -> (one, two) -> one - two;
      case "*" -> (one, two) -> one * two;
      case "/" -> (one, two) -> one / two;
      default -> throw new UnsupportedOperationException();
    };
  }

  private static BinaryOperator<Long> getSolveForOne(final String symbol) {
    return switch (symbol) {
      case "+" -> (result, two) -> result - two;
      case "-" -> Long::sum;
      case "*" -> (result, two) -> result / two;
      case "/" -> (result, two) -> result * two;
      default -> throw new UnsupportedOperationException();
    };
  }

  private static BinaryOperator<Long> getSolveForTwo(final String symbol) {
    return switch (symbol) {
      case "+" -> (result, one) -> result - one;
      case "-" -> (result, one) -> one - result;
      case "*" -> (result, one) -> result / one;
      case "/" -> (result, one) -> one / result;
      default -> throw new UnsupportedOperationException();
    };
  }

  private record Operation(
      String operandOne,
      char op,
      String operandTwo,
      BinaryOperator<Long> operation,
      BinaryOperator<Long> solveForOne,
      BinaryOperator<Long> solveForTwo) {
    public long calculate(long valueOne, long valueTwo) {
      return operation.apply(valueOne, valueTwo);
    }

    public long solveForOne(long result, long valueTwo) {
      return solveForOne.apply(result, valueTwo);
    }

    public long solveForTwo(long result, long valueOne) {
      return solveForTwo.apply(result, valueOne);
    }

    @Override
    public String toString() {
      return "Operation[ " + operandOne + " " + op + " " + operandTwo + " ]";
    }
  }
}
