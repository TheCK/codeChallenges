package org.ck.hackerrank.corecs.algorithms.implementation.almostsorted;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    pipeResource("00");

    Solution.main(null);

    assertEquals(getResult("yes", "swap 1 2"), this.output.toString());
  }

  @Test
  public void test01() throws Exception {
    pipeResource("01");

    Solution.main(null);

    assertEquals(getResult("no"), this.output.toString());
  }

  @Test
  public void test02() throws Exception {
    pipeResource("02");

    Solution.main(null);

    assertEquals(getResult("yes", "reverse 2 5"), this.output.toString());
  }

  @Test
  public void test03() throws Exception {
    pipeResource("03");

    Solution.main(null);

    assertEquals(getResult("yes", "swap 12 95"), this.output.toString());
  }

  @Test
  public void test04() throws Exception {
    pipeResource("04");

    Solution.main(null);

    assertEquals(getResult("yes", "swap 3 4"), this.output.toString());
  }

  @Test
  public void testCustom00() throws Exception {
    pipeResource("custom00");

    Solution.main(null);

    assertEquals(getResult("yes"), this.output.toString());
  }
}
