package org.ck.projecteuler.solutions.problem179;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsecutivePositiveDivisorsTest extends BaseTest {
  @Test
  @Disabled
  public void test00() throws Exception {
    ConsecutivePositiveDivisors.main(null);

    assertEquals(getResult("986262"), this.output.toString());
  }
}
