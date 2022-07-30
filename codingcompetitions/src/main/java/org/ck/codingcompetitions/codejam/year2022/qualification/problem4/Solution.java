package org.ck.codingcompetitions.codejam.year2022.qualification.problem4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@org.ck.codeChallengeLib.annotation.Solution(
    id = 220220004,
    name = "Qualification Round - 4 - Chain Reactions",
    url =
        "https://codingcompetitions.withgoogle.com/codejam/round/0000000000876ff1/0000000000a45ef7",
    category = "Code Jam",
    subCategory = "2022")
public class Solution {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int tests = in.nextInt();

      for (int test = 1; test <= tests; ++test) {
        int modules = in.nextInt();
        int[] funs = new int[modules];

        for (int module = 0; module < modules; ++module) {
          funs[module] = in.nextInt();
        }

        List<Integer>[] connections = new List[modules];
        boolean[] chainEnd = new boolean[modules];
        for (int module = 0; module < modules; ++module) {
          int pointsTo = in.nextInt() - 1;

          if (pointsTo >= 0) {
            if (connections[pointsTo] == null) {
              connections[pointsTo] = new ArrayList<>();
            }
            connections[pointsTo].add(module);
          } else {
            chainEnd[module] = true;
          }
        }

        long fun = 0;
        for (int module = 0; module < modules; ++module) {
          if (chainEnd[module]) {
            fun += findFuns(module, funs, connections).getFun();
          }
        }

        System.out.printf("Case #%d: %d%n", test, fun);
      }
    }
  }

  private static Fun findFuns(
      final int module, final int[] funs, final List<Integer>[] connections) {
    if (connections[module] == null) {
      return new Fun(funs[module]);
    }

    List<Fun> funsSoFar = new ArrayList<>();
    for (Integer connection : connections[module]) {
      funsSoFar.add(findFuns(connection, funs, connections));
    }

    long fun = funsSoFar.stream().mapToLong(Fun::getFun).sum();
    long min = funsSoFar.stream().mapToLong(Fun::getMin).min().getAsLong();

    if (funs[module] > min) {
      fun += funs[module] - min;
      min = funs[module];
    }

    return new Fun(fun, min);
  }

  private static class Fun {
    private long fun;
    private long min;

    public Fun(final long fun) {
      this.fun = fun;
      this.min = fun;
    }

    public Fun(final long fun, final long min) {
      this.fun = fun;
      this.min = min;
    }

    public long getFun() {
      return fun;
    }

    public long getMin() {
      return min;
    }
  }
}
