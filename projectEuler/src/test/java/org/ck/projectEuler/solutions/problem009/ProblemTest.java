package org.ck.projectEuler.solutions.problem009;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProblemTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Problem.main(null);

    assertEquals(getResult("31875000"), this.output.toString());
  }
}
