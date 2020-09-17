package org.ck.projectEuler.solutions.problem104;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PandigitalFibonacciEndsTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    PandigitalFibonacciEnds.main(null);

    assertEquals(getResult("329468"), this.output.toString());
  }
}
