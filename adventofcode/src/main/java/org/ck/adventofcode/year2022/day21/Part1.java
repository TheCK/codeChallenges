package org.ck.adventofcode.year2022.day21;

import org.ck.codeChallengeLib.annotation.Solution;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;

@Solution(
    id = 20222101,
    name = "Day 22: Monkey Math",
    url = "https://adventofcode.com/2022/day/21",
    category = "2022")
public class Part1 {
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
              line[0].substring(0, 4), new Operation(line[1], line[3], getOperation(line[2])));
        }
      }
    }

    while (!values.containsKey("root")) {
      Iterator<String> iterator = operations.keySet().iterator();
      while (iterator.hasNext()) {
        String monkey = iterator.next();
        Operation operation = operations.get(monkey);

        if (values.containsKey(operation.getOperandOne())
            && values.containsKey(operation.getOperandTwo())) {
          values.put(
              monkey,
              operation.calculate(
                  values.get(operation.getOperandOne()), values.get(operation.getOperandTwo())));
          iterator.remove();
        }
      }
    }

    System.out.println(values.get("root"));
  }

  private static BiFunction<Long, Long, Long> getOperation(final String symbol) {
    return switch (symbol) {
      case "+" -> Long::sum;
      case "-" -> (one, two) -> one - two;
      case "*" -> (one, two) -> one * two;
      case "/" -> (one, two) -> one / two;
      default -> throw new UnsupportedOperationException();
    };
  }

  private static class Operation {
    private final String operandOne;
    private final String operandTwo;

    private final BiFunction<Long, Long, Long> operation;

    public Operation(
        final String operandOne,
        final String operandTwo,
        final BiFunction<Long, Long, Long> operation) {
      this.operandOne = operandOne;
      this.operandTwo = operandTwo;
      this.operation = operation;
    }

    public String getOperandOne() {
      return operandOne;
    }

    public String getOperandTwo() {
      return operandTwo;
    }

    public long calculate(long valueOne, long valueTwo) {
      return operation.apply(valueOne, valueTwo);
    }
  }
}
