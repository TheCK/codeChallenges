package org.ck.tis100.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import org.ck.tis100.core.Level;
import org.ck.tis100.core.RunResult;
import org.ck.tis100.core.Segment;
import org.junit.jupiter.api.Test;

public abstract class BaseTest {

  public static final List<Integer> NO_VALUES = List.of();

  private final Segment segment;
  private final List<List<List<Integer>>> inputs;
  private final List<List<List<Integer>>> expectedOutputs;

  private final List<RunResult> expectedResultForOptimalCycles;
  private final List<RunResult> expectedResultForOptimalNodes;
  private final List<RunResult> expectedResultForOptimalLines;

  public BaseTest(
      final Class<? extends Segment> testClass,
      final List<List<List<Integer>>> inputs,
      final List<List<List<Integer>>> expectedOutputs,
      final List<RunResult> expectedResultForOptimalCycles,
      final List<RunResult> expectedResultForOptimalNodes,
      final List<RunResult> expectedResultForOptimalLines)
      throws Exception {
    if (inputs.size() != expectedOutputs.size()
        || inputs.size() != expectedResultForOptimalCycles.size()
        || inputs.size() != expectedResultForOptimalNodes.size()
        || inputs.size() != expectedResultForOptimalLines.size()) {
      throw new IllegalArgumentException();
    }
    segment = testClass.getDeclaredConstructor().newInstance();

    this.inputs = inputs;
    this.expectedOutputs = expectedOutputs;
    this.expectedResultForOptimalCycles = expectedResultForOptimalCycles;
    this.expectedResultForOptimalNodes = expectedResultForOptimalNodes;
    this.expectedResultForOptimalLines = expectedResultForOptimalLines;
  }

  @Test
  public void runTestsForOptimalCycles() {
    for (int i = 0; i < inputs.size(); ++i) {
      final List<List<Integer>> currentInputs = inputs.get(i);
      final List<List<Integer>> currentExpectedOutputs = expectedOutputs.get(i);
      final RunResult currentExpectedRunResult = expectedResultForOptimalCycles.get(i);

      final List<List<Integer>> outputs =
          List.of(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

      final Level level =
          segment.getSolutionForOptimalCycles(
              currentInputs.stream().map(ArrayDeque::new).map(x -> (Queue<Integer>) x).toList(),
              outputs);

      final RunResult result = level.run(currentExpectedOutputs.stream().map(List::size).toList());

      assertEquals(currentExpectedRunResult, result);
      assertEquals(currentExpectedOutputs, outputs);
    }
  }

  @Test
  public void runTestsForOptimalNodes() {
    for (int i = 0; i < inputs.size(); ++i) {
      final List<List<Integer>> currentInputs = inputs.get(i);
      final List<List<Integer>> currentExpectedOutputs = expectedOutputs.get(i);
      final RunResult currentExpectedRunResult = expectedResultForOptimalNodes.get(i);

      final List<List<Integer>> outputs =
          List.of(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

      final Level level =
          segment.getSolutionForOptimalNodes(
              currentInputs.stream().map(ArrayDeque::new).map(x -> (Queue<Integer>) x).toList(),
              outputs);

      final RunResult result = level.run(currentExpectedOutputs.stream().map(List::size).toList());

      assertEquals(currentExpectedRunResult, result);
      assertEquals(currentExpectedOutputs, outputs);
    }
  }

  @Test
  public void runTestsForOptimalLines() {
    for (int i = 0; i < inputs.size(); ++i) {
      final List<List<Integer>> currentInputs = inputs.get(i);
      final List<List<Integer>> currentExpectedOutputs = expectedOutputs.get(i);
      final RunResult currentExpectedRunResult = expectedResultForOptimalLines.get(i);

      final List<List<Integer>> outputs =
          List.of(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

      final Level level =
          segment.getSolutionForOptimalLinesOfCode(
              currentInputs.stream().map(ArrayDeque::new).map(x -> (Queue<Integer>) x).toList(),
              outputs);

      final RunResult result = level.run(currentExpectedOutputs.stream().map(List::size).toList());

      assertEquals(currentExpectedRunResult, result);
      assertEquals(currentExpectedOutputs, outputs);
    }
  }
}
