package org.ck.adventofcode.year2024;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.ck.adventofcode.util.AOCSolution;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 20242401,
    name = "Day 24: Crossed Wires",
    url = "https://adventofcode.com/2024/day/24",
    category = "2024")
@Solution(
    id = 20242402,
    name = "Day 24: Crossed Wires - Part 2",
    url = "https://adventofcode.com/2024/day/24#part2",
    category = "2024",
    solved = false)
public class Day24 extends AOCSolution {
  private static final Pattern PATTERN =
      Pattern.compile(
          "(?<one>[a-z0-9]+) (?<type>XOR|AND|OR) (?<two>[a-z0-9]+) -> (?<result>[a-z0-9]+)");

  @Override
  protected void runPartOne(final Scanner in) {
    run(in);
  }

  @Override
  protected void runPartTwo(final Scanner in) {
    run2(in);
  }

  private void run2(final Scanner in) {
    final Map<String, Boolean> initialValues = new HashMap<>();
    final Map<String, Boolean> outputs = new HashMap<>();
    final List<String> rawGates = new ArrayList<>();

    while (in.hasNextLine()) {
      final String[] line = in.nextLine().split(": ");

      if (line.length == 1) {
        break;
      }

      initialValues.put(line[0], "1".equals(line[1]));
    }

    final List<String> inputWires =
        initialValues.keySet().stream()
            .map(inputWire -> inputWire.substring(1))
            .sorted()
            .distinct()
            .toList();

    while (in.hasNextLine()) {
      rawGates.add(in.nextLine());
    }

    long x = 0;
    long y = 0;
    for (final String inputWire : inputWires) {
      x <<= 1;
      y <<= 1;

      x += Boolean.TRUE.equals(initialValues.get("x" + inputWire)) ? 1 : 0;
      y += Boolean.TRUE.equals(initialValues.get("y" + inputWire)) ? 1 : 0;
    }

    final long z = x + y;
    final String binaryZ = Long.toBinaryString(z);
    final Map<String, Boolean> zWires = new HashMap<>();
    final Queue<Swappable> swappables = new LinkedList<>();

    boolean numberIsCorrect = false;
    while (!numberIsCorrect) {
      final Swappable swappable = swappables.poll();

      final Map<String, List<Gate>> currentGates = generateGates(rawGates, outputs, swappable);
      numberIsCorrect = true;

      for (String inputWire : inputWires) {
        outputs.clear();

        final String xWire = "x" + inputWire;
        final String yWire = "y" + inputWire;
        final String zWire = "z" + inputWire;

        currentGates.get(xWire).forEach(gate -> gate.accept(initialValues.get(xWire)));
        currentGates.get(yWire).forEach(gate -> gate.accept(initialValues.get(yWire)));

        if (outputs.containsKey(zWire)) {
          zWires.put(zWire, outputs.get(zWire));

          if (!outputs
              .get(zWire)
              .equals(binaryZ.charAt(binaryZ.length() - Integer.parseInt(inputWire) - 1) == '1')) {

            Set<String> swapCandidates =
                outputs.keySet().stream()
                    .filter(wire -> !zWire.equals(wire))
                    .collect(Collectors.toSet());

            numberIsCorrect = false;
            break;
          }
        } else {
          // z wires don't seem to be swapped in my implementation, so I'll skip this
        }
      }
    }

    System.err.println(binaryZ);
    System.err.println(
        zWires.entrySet().stream()
            .sorted(Map.Entry.<String, Boolean>comparingByKey().reversed())
            .map(entry -> Boolean.TRUE.equals(entry.getValue()) ? "1" : "0")
            .collect(Collectors.joining()));
  }

  private Map<String, List<Gate>> generateGates(
      final List<String> rawGates, final Map<String, Boolean> outputs, final Swappable swappable) {
    final Map<String, List<Gate>> gates = new HashMap<>();

    for (final String rawGate : rawGates) {
      final Matcher matcher = PATTERN.matcher(rawGate);

      if (matcher.matches()) {
        final Gate gate =
            new Gate(matcher.group("result"), gates, outputs, getOperation(matcher.group("type")));

        gates.computeIfAbsent(matcher.group("one"), k -> new ArrayList<>()).add(gate);
        gates.computeIfAbsent(matcher.group("two"), k -> new ArrayList<>()).add(gate);
      }
    }

    return gates;
  }

  private void run(final Scanner in) {
    final Map<String, Boolean> initialValues = new HashMap<>();
    final Map<String, List<Gate>> gates = new HashMap<>();
    final Map<String, Boolean> outputs = new HashMap<>();

    while (in.hasNextLine()) {
      final String[] line = in.nextLine().split(": ");

      if (line.length == 1) {
        break;
      }

      initialValues.put(line[0], "1".equals(line[1]));
    }

    while (in.hasNextLine()) {
      final Matcher matcher = PATTERN.matcher(in.nextLine());

      if (matcher.matches()) {
        final Gate gate =
            new Gate(matcher.group("result"), gates, outputs, getOperation(matcher.group("type")));

        gates.computeIfAbsent(matcher.group("one"), k -> new ArrayList<>()).add(gate);
        gates.computeIfAbsent(matcher.group("two"), k -> new ArrayList<>()).add(gate);
      }
    }

    for (final String gate : initialValues.keySet()) {
      gates.get(gate).forEach(function -> function.accept(initialValues.get(gate)));
    }

    long result = 0;

    final List<String> outputGates =
        outputs.keySet().stream()
            .filter(gate -> gate.startsWith("z"))
            .sorted(Comparator.reverseOrder())
            .toList();
    for (final String gate : outputGates) {
      result <<= 1;
      if (Boolean.TRUE.equals(outputs.get(gate))) {
        ++result;
      }
    }

    print(result);
  }

  private BinaryOperator<Boolean> getOperation(final String type) {
    return switch (type) {
      case "AND" -> (one, two) -> one && two;
      case "OR" -> (one, two) -> one || two;
      case "XOR" -> (one, two) -> one ^ two;
      default -> throw new IllegalStateException("Unexpected operation: " + type);
    };
  }

  private static class Gate implements Consumer<Boolean> {
    private final String resultGate;
    private final Map<String, List<Gate>> gates;
    private final Map<String, Boolean> outputs;
    private final BinaryOperator<Boolean> operation;

    private Boolean one;

    public Gate(
        final String resultGate,
        final Map<String, List<Gate>> gates,
        final Map<String, Boolean> outputs,
        final BinaryOperator<Boolean> operation) {
      this.resultGate = resultGate;
      this.gates = gates;
      this.outputs = outputs;
      this.operation = operation;
    }

    @Override
    public void accept(final Boolean input) {
      if (one == null) {
        one = input;
      } else {
        final Boolean result = operation.apply(one, input);
        outputs.put(resultGate, result);

        if (gates.containsKey(resultGate)) {
          gates.get(resultGate).forEach(function -> function.accept(result));
        }
      }
    }
  }

  private record Swappable(String wireNumber, String one, String two) {}
}
