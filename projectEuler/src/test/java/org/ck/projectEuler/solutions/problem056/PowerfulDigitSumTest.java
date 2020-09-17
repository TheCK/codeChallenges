package org.ck.projectEuler.solutions.problem056;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PowerfulDigitSumTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    PowerfulDigitSum.main(null);

    assertEquals(getResult("972"), this.output.toString());
  }
}
