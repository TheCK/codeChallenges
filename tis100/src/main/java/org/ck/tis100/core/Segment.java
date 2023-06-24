package org.ck.tis100.core;

import java.util.List;
import java.util.Queue;
import org.ck.codechallengelib.annotation.Solution;

@Solution(
    id = 150,
    name = "Self-Test Diagnostic",
    url = "https://www.zachtronics.com/tis-100/",
    category = "")
public abstract class Segment {
  public abstract Level getSolutionForOptimalCycles(
      final List<Queue<Integer>> inputs, final List<List<Integer>> outputs);

  public abstract Level getSolutionForOptimalNodes(
      final List<Queue<Integer>> inputs, final List<List<Integer>> outputs);

  public abstract Level getSolutionForOptimalLinesOfCode(
      final List<Queue<Integer>> inputs, final List<List<Integer>> outputs);
}
