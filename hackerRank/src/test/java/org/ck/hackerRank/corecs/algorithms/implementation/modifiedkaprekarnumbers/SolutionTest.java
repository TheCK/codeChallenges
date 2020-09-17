package org.ck.hackerRank.corecs.algorithms.implementation.modifiedkaprekarnumbers;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    pipeResource("00");

    Solution.main(null);

    assertEquals(getResult("1 9 45 55 99"), this.output.toString());
  }

  @Test
  public void test01() throws Exception {
    pipeResource("01");

    Solution.main(null);

    assertEquals(getResult("297"), this.output.toString());
  }
}
