package org.ck.projecteuler.solutions.problem104;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class PandigitalFibonacciEndsTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    PandigitalFibonacciEnds.main(null);

    assertEquals(getResult("329468"), this.output.toString());
  }
}
