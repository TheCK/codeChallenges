package org.ck.hackerRank.corecs.datastructures.arrays.arraymanipulation;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    pipeResource("00");

    Solution.main(null);

    assertEquals(getResult("200"), this.output.toString());
  }

  @Test
  public void test01() throws Exception {
    pipeResource("01");

    Solution.main(null);

    assertEquals(getResult("2497169732"), this.output.toString());
  }
}
