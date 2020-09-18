package org.ck.projecteuler.solutions.problem038;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PandigitalMultiplesTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    PandigitalMultiples.main(null);

    assertEquals(getResult("932718654"), this.output.toString());
  }
}
