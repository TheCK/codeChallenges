package org.ck.tis100;

import java.util.*;
import org.ck.codechallengelib.annotation.Solution;
import org.ck.tis100.core.Level;
import org.ck.tis100.core.Segment;

@Solution(
    id = 20340,
    name = "Signal Compactor",
    url = "https://www.zachtronics.com/tis-100/",
    category = "")
public class Segment20340 extends Segment {
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
            new Level.NodeDefinition(Level.NodeType.T21, List.of("MOV UP, RIGHT"))
          },
          new Level.NodeDefinition[] {
            new Level.NodeDefinition(Level.NodeType.T21, List.of()),
            new Level.NodeDefinition(Level.NodeType.NONE, null),
            new Level.NodeDefinition(
                Level.NodeType.T21,
                List.of(
                    "START:",
                    "MOV LEFT, ACC",
                    "MOV ACC, RIGHT",
                    "JGZ TRUE",
                    "MOV 0, DOWN",
                    "JMP START",
                    "TRUE:",
                    "MOV 1, DOWN"))
          },
          new Level.NodeDefinition[] {
            new Level.NodeDefinition(Level.NodeType.T21, List.of()),
            new Level.NodeDefinition(Level.NodeType.NONE, null),
            new Level.NodeDefinition(
                Level.NodeType.T21,
                List.of(
                    "START:",
                    "MOV LEFT, ACC",
                    "MOV ACC, RIGHT",
                    "JEZ TRUE",
                    "MOV 0, DOWN",
                    "JMP START",
                    "TRUE:",
                    "MOV 1, DOWN"))
          },
          new Level.NodeDefinition[] {
            new Level.NodeDefinition(Level.NodeType.T21, List.of()),
            new Level.NodeDefinition(Level.NodeType.NONE, null),
            new Level.NodeDefinition(
                Level.NodeType.T21,
                List.of(
                    "START:",
                    "MOV LEFT, ACC",
                    "JLZ TRUE",
                    "MOV 0, DOWN",
                    "JMP START",
                    "TRUE:",
                    "MOV 1, DOWN"))
          }
        },
        inputs,
        outputs);
  }
}
