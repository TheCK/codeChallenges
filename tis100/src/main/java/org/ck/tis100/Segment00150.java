package org.ck.tis100;

import java.util.*;
import org.ck.tis100.core.Level;
import org.ck.tis100.core.Segment;

public class Segment00150 extends Segment {
  @Override
  public Level getSolutionForOptimalCycles(
      final List<Queue<Integer>> inputs, final List<List<Integer>> outputs) {
    return getSolution(inputs, outputs);
  }

  @Override
  public Level getSolutionForOptimalNodes(
      final List<Queue<Integer>> inputs, final List<List<Integer>> outputs) {
    return getSolution(inputs, outputs);
  }

  @Override
  public Level getSolutionForOptimalLinesOfCode(
      final List<Queue<Integer>> inputs, final List<List<Integer>> outputs) {
    return getSolution(inputs, outputs);
  }

  private Level getSolution(final List<Queue<Integer>> inputs, final List<List<Integer>> outputs) {
    return new Level(
        new Level.NodeDefinition[][] {
          new Level.NodeDefinition[] {
            new Level.NodeDefinition(Level.NodeType.T21, List.of("MOV UP, DOWN")),
            new Level.NodeDefinition(Level.NodeType.T21, List.of("MOV UP, DOWN")),
            new Level.NodeDefinition(Level.NodeType.T21, List.of("MOV UP, DOWN"))
          },
          new Level.NodeDefinition[] {
            new Level.NodeDefinition(Level.NodeType.NONE, null),
            new Level.NodeDefinition(Level.NodeType.NONE, null),
            new Level.NodeDefinition(Level.NodeType.NONE, null)
          },
          new Level.NodeDefinition[] {
            new Level.NodeDefinition(Level.NodeType.T21, List.of("MOV RIGHT, DOWN")),
            new Level.NodeDefinition(Level.NodeType.T21, List.of("MOV UP, DOWN")),
            new Level.NodeDefinition(Level.NodeType.T21, List.of("MOV UP, RIGHT"))
          },
          new Level.NodeDefinition[] {
            new Level.NodeDefinition(Level.NodeType.T21, List.of("MOV UP, LEFT")),
            new Level.NodeDefinition(Level.NodeType.NONE, null),
            new Level.NodeDefinition(Level.NodeType.T21, List.of("MOV LEFT, DOWN"))
          }
        },
        inputs,
        outputs);
  }
}
