package org.ck.projecteuler.solutions.problem099;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class LargestExponentialTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    LargestExponential.main(getFileAsArgs("00"));

    assertEquals(getResult("709"), this.output.toString());
  }
}
