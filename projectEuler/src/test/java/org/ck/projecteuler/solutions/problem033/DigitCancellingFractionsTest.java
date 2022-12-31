package org.ck.projecteuler.solutions.problem033;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class DigitCancellingFractionsTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    DigitCancellingFractions.main(null);

    assertEquals(getResult("100"), this.output.toString());
  }
}
