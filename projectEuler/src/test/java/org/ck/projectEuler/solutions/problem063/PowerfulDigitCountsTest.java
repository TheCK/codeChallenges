package org.ck.projectEuler.solutions.problem063;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PowerfulDigitCountsTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    PowerfulDigitCounts.main(null);

    assertEquals(getResult("49"), this.output.toString());
  }
}
