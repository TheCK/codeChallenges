package org.ck.projectEuler.solutions.problem027;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuadraticPrimesTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    QuadraticPrimes.main(null);

    assertEquals(getResult("-59231"), this.output.toString());
  }
}
