package org.ck.tis100;

import java.util.*;
import org.ck.codechallengelib.annotation.Solution;
import org.ck.tis100.core.Level;
import org.ck.tis100.core.Segment;

@Solution(
    id = 20176,
    name = "Differential Converter",
    url = "https://www.zachtronics.com/tis-100/",
    category = "")
public class Segment20176 extends Segment {
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
            new Level.NodeDefinition(Level.NodeType.T21, List.of()),
            new Level.NodeDefinition(Level.NodeType.T21, List.of()),
            new Level.NodeDefinition(Level.NodeType.T21, List.of())
          },
          new Level.NodeDefinition[] {
            new Level.NodeDefinition(Level.NodeType.T21, List.of("MOV UP, RIGHT")),
            new Level.NodeDefinition(
                Level.NodeType.T21, List.of("MOV RIGHT, ACC", "NEG", "MOV ACC, DOWN")),
            new Level.NodeDefinition(Level.NodeType.T21, List.of("MOV UP, DOWN"))
          },
          new Level.NodeDefinition[] {
            new Level.NodeDefinition(
                Level.NodeType.T21, List.of("MOV UP, ACC", "SUB LEFT", "MOV ACC, DOWN")),
            new Level.NodeDefinition(
                Level.NodeType.T21, List.of("MOV UP, ACC", "MOV ACC, LEFT", "MOV ACC, DOWN")),
            new Level.NodeDefinition(Level.NodeType.T21, List.of("MOV UP, DOWN"))
          },
          new Level.NodeDefinition[] {
            new Level.NodeDefinition(Level.NodeType.T21, List.of()),
            new Level.NodeDefinition(Level.NodeType.NONE, null),
            new Level.NodeDefinition(Level.NodeType.T21, List.of())
          }
        },
        inputs,
        outputs);
  }
}
