package org.ck.projecteuler.solutions.problem027;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProblemTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Problem.main(null);

    assertEquals(getResult("-59231"), this.output.toString());
  }
}
