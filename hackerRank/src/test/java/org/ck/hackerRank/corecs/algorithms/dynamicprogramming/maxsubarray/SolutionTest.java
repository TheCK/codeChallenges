package org.ck.hackerRank.corecs.algorithms.dynamicprogramming.maxsubarray;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    pipeResource("00");

    Solution.main(null);

    assertEquals(getResult("10 10", "10 11"), this.output.toString());
  }

  @Test
  public void testCustom00() throws Exception {
    pipeResource("custom00");

    Solution.main(null);

    assertEquals(getResult("-9 -9"), this.output.toString());
  }
}
