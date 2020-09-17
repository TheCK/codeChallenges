package org.ck.hackerRank.corecs.algorithms.warmup.staircase;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    pipeResource("00");

    Solution.main(null);

    assertEquals(
        getResult("     #", "    ##", "   ###", "  ####", " #####", "######"),
        this.output.toString());
  }
}
