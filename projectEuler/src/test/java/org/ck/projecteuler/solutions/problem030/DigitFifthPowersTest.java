package org.ck.projecteuler.solutions.problem030;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DigitFifthPowersTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    DigitFifthPowers.main(null);

    assertEquals(getResult("443839"), this.output.toString());
  }
}
