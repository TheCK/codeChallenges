package org.ck.adventofcode.year2024;

import java.math.BigInteger;
import java.util.*;
import java.util.function.BinaryOperator;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20240701,
    name = "Day 7: Bridge Repair",
    url = "https://adventofcode.com/2024/day/7",
    category = "2024")
@Solution(
    id = 20240702,
    name = "Day 7: Bridge Repair - Part 2",
    url = "https://adventofcode.com/2024/day/7#part2",
    category = "2024")
public class Day07 extends AOCSolution {

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, List.of(Day07::add, Day07::multiply));
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(
        in,
        List.of(Day07::add, Day07::multiply, (one, two) -> new BigInteger(one.toString() + two)));
  }

  private void run(final Scanner in, List<BinaryOperator<BigInteger>> operations) {
    BigInteger sum = BigInteger.ZERO;

    while (in.hasNextLine()) {
      final String[] line = in.nextLine().split(": ");
      final BigInteger result = new BigInteger(line[0]);
      final List<BigInteger> operands =
          Arrays.stream(line[1].split(" ")).map(BigInteger::new).toList();

      Set<BigInteger> intermediateResults = new HashSet<>();
      intermediateResults.add(operands.getFirst());

      for (int i = 1; i < operands.size(); ++i) {
        intermediateResults =
            getNextIntermediateResults(intermediateResults, result, operations, operands.get(i));
        getNextIntermediateResults(intermediateResults, result, operations, operands.get(i));
      }

      if (intermediateResults.contains(result)) {
        sum = sum.add(result);
      }
    }

    print(sum);
  }

  private static Set<BigInteger> getNextIntermediateResults(
      final Set<BigInteger> intermediateResults,
      final BigInteger result,
      final List<BinaryOperator<BigInteger>> operations,
      final BigInteger operand) {
    final Set<BigInteger> newResults = new HashSet<>();

    for (BigInteger intermediateResult : intermediateResults) {
      for (BinaryOperator<BigInteger> operation : operations) {
        final BigInteger newResult = operation.apply(intermediateResult, operand);

        if (newResult.compareTo(result) <= 0) {
          newResults.add(newResult);
        }
      }
    }

    return newResults;
  }

  private static BigInteger add(BigInteger one, BigInteger two) {
    return one.add(two);
  }

  private static BigInteger multiply(BigInteger one, BigInteger two) {
    return one.multiply(two);
  }
}
