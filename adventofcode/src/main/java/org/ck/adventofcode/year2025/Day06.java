package org.ck.adventofcode.year2025;

import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20250601,
    name = "Day 6: Trash Compactor",
    url = "https://adventofcode.com/2025/day/6",
    category = "2025")
@Solution(
    id = 20250602,
    name = "Day 6: Trash Compactor - Part 2",
    url = "https://adventofcode.com/2025/day/6#part2",
    category = "2025")
public class Day06 extends AOCSolution {

  @Override
  protected void runPartOne(final Scanner in) {
    run(in, strings -> Arrays.stream(strings).map(String::trim).map(Long::valueOf).toList());
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run(in, Day06::parseVertical);
  }

  private void run(final Scanner in, final Function<String[], List<Long>> numberParser) {
    final List<String> inputs = new ArrayList<>();

    while (in.hasNextLine()) {
      inputs.add(in.nextLine());
    }

    final List<Problem> problems = getProblems(inputs, numberParser);
    print(problems.stream().mapToLong(Problem::solve).sum());
  }

  private List<Problem> getProblems(
      final List<String> inputs, final Function<String[], List<Long>> numberParser) {
    final List<Integer> emptyColumns = getEmptyColumns(inputs);

    final String[][] inputArray = new String[emptyColumns.size() + 1][inputs.size()];
    for (int inputRow = 0; inputRow < inputs.size(); ++inputRow) {
      final String input = inputs.get(inputRow);

      int previousIndex = 0;
      for (int column = 0; column < emptyColumns.size(); ++column) {
        final int emptyColumnIndex = emptyColumns.get(column);
        inputArray[column][inputRow] = input.substring(previousIndex, emptyColumnIndex);

        previousIndex = emptyColumnIndex + 1;
      }

      inputArray[inputArray.length - 1][inputRow] = input.substring(previousIndex);
    }

    final List<Problem> problems = new ArrayList<>();
    for (int problemIndex = 0; problemIndex < emptyColumns.size() + 1; ++problemIndex) {
      problems.add(
          new Problem(
              numberParser.apply(
                  Arrays.copyOfRange(
                      inputArray[problemIndex], 0, inputArray[problemIndex].length - 1)),
              inputArray[problemIndex][inputArray[problemIndex].length - 1].startsWith("+")
                  ? new Operation.Addition()
                  : new Operation.Multiplication()));
    }

    return problems;
  }

  private static List<Integer> getEmptyColumns(final List<String> inputs) {
    final Set<Integer> emptyIndices =
        new HashSet<>(IntStream.range(0, inputs.getFirst().length()).boxed().toList());
    for (final String input : inputs) {
      final Set<Integer> emptyIndicesOnLine = new HashSet<>();

      for (int i = 0; i < input.length(); ++i) {
        if (' ' == input.charAt(i)) {
          emptyIndicesOnLine.add(i);
        }
      }

      emptyIndices.retainAll(emptyIndicesOnLine);
    }

    return emptyIndices.stream().sorted().toList();
  }

  private static List<Long> parseVertical(final String[] strings) {
    final List<Long> numbers = new ArrayList<>();
    for (int numberIndex = 0; numberIndex < strings[0].length(); ++numberIndex) {
      long number = 0;
      for (final String string : strings) {
        char current = string.charAt(numberIndex);

        if (current != ' ') {
          number = number * 10 + (current - '0');
        }
      }

      numbers.add(number);
    }

    return numbers;
  }

  private record Problem(List<Long> values, Operation operation) {
    public long solve() {
      values.forEach(operation::apply);

      return operation.getResult();
    }
  }

  private sealed interface Operation {
    void apply(Long value);

    long getResult();

    final class Multiplication implements Operation {
      private long result = 1;

      @Override
      public void apply(Long value) {
        result *= value;
      }

      @Override
      public long getResult() {
        return result;
      }
    }

    final class Addition implements Operation {
      private long result = 0;

      @Override
      public void apply(Long value) {
        result += value;
      }

      @Override
      public long getResult() {
        return result;
      }
    }
  }
}
