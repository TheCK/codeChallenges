package org.ck.projectEuler.solutions.problem034;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DigitFactorialsTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    DigitFactorials.main(null);

    assertEquals(getResult("40730"), this.output.toString());
  }
}
