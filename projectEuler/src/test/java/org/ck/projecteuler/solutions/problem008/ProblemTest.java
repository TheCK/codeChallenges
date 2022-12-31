package org.ck.projecteuler.solutions.problem008;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class ProblemTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Problem.main(null);

    assertEquals(getResult("23514624000"), this.output.toString());
  }
}
