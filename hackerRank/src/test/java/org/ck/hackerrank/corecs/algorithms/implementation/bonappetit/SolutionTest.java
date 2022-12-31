package org.ck.hackerrank.corecs.algorithms.implementation.bonappetit;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    pipeResource("00");

    Solution.main(null);

    assertEquals(getResult("5"), this.output.toString());
  }

  @Test
  public void test01() throws Exception {
    pipeResource("01");

    Solution.main(null);

    assertEquals(getResult("Bon Appetit"), this.output.toString());
  }
}
