package org.ck.projecteuler.solutions.problem063;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class PowerfulDigitCountsTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    PowerfulDigitCounts.main(null);

    assertEquals(getResult("49"), this.output.toString());
  }
}
