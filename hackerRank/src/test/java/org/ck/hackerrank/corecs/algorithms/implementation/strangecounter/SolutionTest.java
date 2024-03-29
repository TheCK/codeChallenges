package org.ck.hackerrank.corecs.algorithms.implementation.strangecounter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class SolutionTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    pipeResource("00");

    Solution.main(null);

    assertEquals(getResult("6"), this.output.toString());
  }

  @Test
  public void test02() throws Exception {
    pipeResource("02");

    Solution.main(null);

    assertEquals(getResult("649267441662"), this.output.toString());
  }

  @Test
  public void testCustom00() throws Exception {
    pipeResource("custom00");

    Solution.main(null);

    assertEquals(getResult("5"), this.output.toString());
  }

  @Test
  public void testCustom01() throws Exception {
    pipeResource("custom01");

    Solution.main(null);

    assertEquals(getResult("11"), this.output.toString());
  }

  @Test
  public void testCustom02() throws Exception {
    pipeResource("custom02");

    Solution.main(null);

    assertEquals(getResult("1"), this.output.toString());
  }
}
