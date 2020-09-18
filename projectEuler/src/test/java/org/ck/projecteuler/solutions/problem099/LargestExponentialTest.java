package org.ck.projecteuler.solutions.problem099;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LargestExponentialTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    LargestExponential.main(getFileAsArgs("00"));

    assertEquals(getResult("709"), this.output.toString());
  }
}
