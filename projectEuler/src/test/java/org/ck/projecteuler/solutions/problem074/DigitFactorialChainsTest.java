package org.ck.projecteuler.solutions.problem074;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DigitFactorialChainsTest extends BaseTest {
  @Test
  @Disabled("ignored for travis ci")
  public void test00() throws Exception {
    DigitFactorialChains.main(null);

    assertEquals(getResult("402"), this.output.toString());
  }
}
