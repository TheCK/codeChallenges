package org.ck.tis100;

import java.util.*;
import org.ck.codechallengelib.annotation.Solution;
import org.ck.tis100.core.Level;
import org.ck.tis100.core.Segment;

@Solution(
    id = 10981,
    name = "Signal Amplifier",
    url = "https://www.zachtronics.com/tis-100/",
    category = "")
public class Segment10981 extends Segment {
  @Override
  public Level getSolutionForOptimalCycles(
      List<Queue<Integer>> inputs, List<List<Integer>> outputs) {
    return new Level(
        new Level.NodeDefinition[][] {
          new Level.NodeDefinition[] {
            new Level.NodeDefinition(Level.NodeType.T21, List.of()),
            new Level.NodeDefinition(Level.NodeType.T21, List.of()),
            new Level.NodeDefinition(Level.NodeType.NONE, null)
          },
          new Level.NodeDefinition[] {
            new Level.NodeDefinition(
                Level.NodeType.T21,
                List.of(
                    "MOV UP, DOWN",
                    "MOV UP, RIGHT") /* List.of("MOV UP, ANY") */), // TODO write to any is broken
            new Level.NodeDefinition(
                Level.NodeType.T21, List.of("MOV UP, ACC", "ADD ACC", "MOV ACC, DOWN")),
            new Level.NodeDefinition(Level.NodeType.T21, List.of("MOV UP, RIGHT"))
          },
          new Level.NodeDefinition[] {
            new Level.NodeDefinition(
                Level.NodeType.T21, List.of("MOV LEFT, ACC", "ADD ACC", "MOV ACC, DOWN")),
            new Level.NodeDefinition(Level.NodeType.T21, List.of("MOV UP, DOWN")),
            new Level.NodeDefinition(Level.NodeType.T21, List.of("MOV ANY, DOWN"))
          },
          new Level.NodeDefinition[] {
            new Level.NodeDefinition(Level.NodeType.NONE, null),
            new Level.NodeDefinition(Level.NodeType.T21, List.of()),
            new Level.NodeDefinition(Level.NodeType.T21, List.of())
          }
        },
        inputs,
        outputs);
  }

  @Override
  public Level getSolutionForOptimalNodes(
      List<Queue<Integer>> inputs, List<List<Integer>> outputs) {
    return getSolution(inputs, outputs);
  }

  @Override
  public Level getSolutionForOptimalLinesOfCode(
      List<Queue<Integer>> inputs, List<List<Integer>> outputs) {
    return getSolution(inputs, outputs);
  }

  private Level getSolution(List<Queue<Integer>> inputs, List<List<Integer>> outputs) {
    return new Level(
        new Level.NodeDefinition[][] {
          new Level.NodeDefinition[] {
            new Level.NodeDefinition(Level.NodeType.T21, List.of()),
            new Level.NodeDefinition(Level.NodeType.T21, List.of()),
            new Level.NodeDefinition(Level.NodeType.NONE, null)
          },
          new Level.NodeDefinition[] {
            new Level.NodeDefinition(
                Level.NodeType.T21, List.of("MOV UP, ACC", "ADD ACC", "MOV ACC, DOWN")),
            new Level.NodeDefinition(Level.NodeType.T21, List.of("MOV UP, DOWN")),
            new Level.NodeDefinition(Level.NodeType.T21, List.of("MOV UP, RIGHT"))
          },
          new Level.NodeDefinition[] {
            new Level.NodeDefinition(Level.NodeType.T21, List.of()),
            new Level.NodeDefinition(Level.NodeType.T21, List.of()),
            new Level.NodeDefinition(Level.NodeType.T21, List.of("MOV LEFT, DOWN"))
          },
          new Level.NodeDefinition[] {
            new Level.NodeDefinition(Level.NodeType.NONE, null),
            new Level.NodeDefinition(Level.NodeType.T21, List.of()),
            new Level.NodeDefinition(Level.NodeType.T21, List.of())
          }
        },
        inputs,
        outputs);
  }
}
