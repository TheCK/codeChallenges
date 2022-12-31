package org.ck.projecteuler.solutions.problem038;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class PandigitalMultiplesTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    PandigitalMultiples.main(null);

    assertEquals(getResult("932718654"), this.output.toString());
  }
}
