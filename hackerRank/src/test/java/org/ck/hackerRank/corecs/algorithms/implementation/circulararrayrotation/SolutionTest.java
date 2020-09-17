package org.ck.hackerRank.corecs.algorithms.implementation.circulararrayrotation;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    pipeResource("00");

    Solution.main(null);

    assertEquals(getResult("2", "3", "1"), this.output.toString());
  }
}
