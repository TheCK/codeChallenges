package org.ck.projecteuler.solutions.problem041;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class PandigitalPrimeTest extends BaseTest {
  @Test
  @Disabled("for travis for now")
  public void test00() throws Exception {
    PandigitalPrime.main(null);

    assertEquals(getResult("7652413"), this.output.toString());
  }
}
