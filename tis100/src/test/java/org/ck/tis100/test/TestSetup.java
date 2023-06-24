package org.ck.tis100.test;

import java.util.List;
import org.ck.tis100.core.RunResult;

public record TestSetup(
    List<List<Integer>> inputs,
    List<List<Integer>> expectedOutputs,
    RunResult expectedResultForOptimalCycles,
    RunResult expectedResultForOptimalNodes,
    RunResult expectedResultForOptimalLines) {}
