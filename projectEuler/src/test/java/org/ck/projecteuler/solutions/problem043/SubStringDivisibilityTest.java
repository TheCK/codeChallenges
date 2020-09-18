package org.ck.projecteuler.solutions.problem043;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubStringDivisibilityTest extends BaseTest {
  @Test
  @Disabled("Solution takes 46 minutes to compute")
  public void test00() throws Exception {
    SubStringDivisibility.main(null);

    assertEquals(getResult("16695334890"), this.output.toString());
  }
}
