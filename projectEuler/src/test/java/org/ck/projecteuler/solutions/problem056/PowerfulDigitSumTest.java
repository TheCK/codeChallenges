package org.ck.projecteuler.solutions.problem056;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class PowerfulDigitSumTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    PowerfulDigitSum.main(null);

    assertEquals(getResult("972"), this.output.toString());
  }
}
