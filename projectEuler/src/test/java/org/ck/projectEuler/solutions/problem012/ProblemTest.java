package org.ck.projectEuler.solutions.problem012;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProblemTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Problem.main(null);

    assertEquals(getResult("76576500"), this.output.toString());
  }
}
