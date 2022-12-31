package org.ck.projecteuler.solutions.problem050;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsecutivePrimeSumTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    ConsecutivePrimeSum.main(null);

    assertEquals(getResult("997651"), this.output.toString());
  }
}
