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

  private final Segment segment;
  private final List<List<Integer>> inputs;
  private final List<List<Integer>> expectedOutputs;

  private final RunResult expectedResultForOptimalCycles;
  private final RunResult expectedResultForOptimalNodes;
  private final RunResult expectedResultForOptimalLines;

  public BaseTest(
      final Class<? extends Segment> testClass,
      final List<List<Integer>> inputs,
      final List<List<Integer>> expectedOutputs,
      final RunResult expectedResultForOptimalCycles,
      final RunResult expectedResultForOptimalNodes,
      final RunResult expectedResultForOptimalLines)
      throws Exception {
    segment = testClass.getDeclaredConstructor().newInstance();

    this.inputs = inputs;
    this.expectedOutputs = expectedOutputs;
    this.expectedResultForOptimalCycles = expectedResultForOptimalCycles;
    this.expectedResultForOptimalNodes = expectedResultForOptimalNodes;
    this.expectedResultForOptimalLines = expectedResultForOptimalLines;
  }

  @Test
  public void runTestForOptimalCycles() {
    List<List<Integer>> outputs =
        List.of(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

    final Level level =
        segment.getSolutionForOptimalCycles(
            inputs.stream().map(ArrayDeque::new).map(x -> (Queue<Integer>) x).toList(), outputs);

    final RunResult result = level.run(500);

    assertEquals(expectedResultForOptimalCycles, result);
    assertEquals(expectedOutputs, outputs);
  }

  @Test
  public void runTestForOptimalNodes() {
    List<List<Integer>> outputs =
        List.of(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

    final Level level =
        segment.getSolutionForOptimalNodes(
            inputs.stream().map(ArrayDeque::new).map(x -> (Queue<Integer>) x).toList(), outputs);

    final RunResult result = level.run(500);

    assertEquals(expectedResultForOptimalNodes, result);
    assertEquals(expectedOutputs, outputs);
  }

  @Test
  public void runTestForOptimalLines() {
    List<List<Integer>> outputs =
        List.of(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

    final Level level =
        segment.getSolutionForOptimalLinesOfCode(
            inputs.stream().map(ArrayDeque::new).map(x -> (Queue<Integer>) x).toList(), outputs);

    final RunResult result = level.run(500);

    assertEquals(expectedResultForOptimalLines, result);
    assertEquals(expectedOutputs, outputs);
  }
}
