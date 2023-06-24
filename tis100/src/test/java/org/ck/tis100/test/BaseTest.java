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

  private final List<TestSetup> testSetups;

  public BaseTest(final Class<? extends Segment> testClass, final List<TestSetup> testSetups)
      throws Exception {
    this.segment = testClass.getDeclaredConstructor().newInstance();

    this.testSetups = testSetups;
  }

  @Test
  public void runTestsForOptimalCycles() {
    for (TestSetup testSetup : testSetups) {
      final List<List<Integer>> currentInputs = testSetup.inputs();
      final List<List<Integer>> currentExpectedOutputs = testSetup.expectedOutputs();
      final RunResult currentExpectedRunResult = testSetup.expectedResultForOptimalCycles();

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
    for (TestSetup testSetup : testSetups) {
      final List<List<Integer>> currentInputs = testSetup.inputs();
      final List<List<Integer>> currentExpectedOutputs = testSetup.expectedOutputs();
      final RunResult currentExpectedRunResult = testSetup.expectedResultForOptimalNodes();

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
    for (TestSetup testSetup : testSetups) {
      final List<List<Integer>> currentInputs = testSetup.inputs();
      final List<List<Integer>> currentExpectedOutputs = testSetup.expectedOutputs();
      final RunResult currentExpectedRunResult = testSetup.expectedResultForOptimalLines();

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
