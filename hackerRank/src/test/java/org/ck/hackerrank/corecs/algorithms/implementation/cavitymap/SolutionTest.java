package org.ck.hackerrank.corecs.algorithms.implementation.cavitymap;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    pipeResource("00");

    Solution.main(null);

    assertEquals(getResult("1112", "1X12", "18X2", "1234"), this.output.toString());
  }
}
