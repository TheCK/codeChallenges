package org.ck.projectEuler.solutions.problem033;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DigitCancellingFractionsTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    DigitCancellingFractions.main(null);

    assertEquals(getResult("100"), this.output.toString());
  }
}
