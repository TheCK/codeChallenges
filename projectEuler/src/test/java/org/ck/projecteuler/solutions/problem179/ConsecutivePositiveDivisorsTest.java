package org.ck.projecteuler.solutions.problem179;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ConsecutivePositiveDivisorsTest extends BaseTest {
  @Test
  @Disabled
  public void test00() throws Exception {
    ConsecutivePositiveDivisors.main(null);

    assertEquals(getResult("986262"), this.output.toString());
  }
}
