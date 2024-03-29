package org.ck.adventofcode.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;

public abstract class BaseAOCTest extends BaseTest {
  protected void runTest(Runnable solution, String name) throws Exception {
    pipeResource(name);

    solution.run();

    assertEquals(getFileAsResult(name), this.output.toString());
  }
}
