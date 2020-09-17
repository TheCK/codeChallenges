package org.ck.hackerRank.corecs.algorithms.implementation.savetheprisoner;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    pipeResource("00");

    Solution.main(null);

    assertEquals(getResult("2"), this.output.toString());
  }

  @Test
  public void test01() throws Exception {
    pipeResource("01");

    Solution.main(null);

    assertEquals(getFileAsResult("01"), this.output.toString());
  }
}
