package org.ck.projecteuler.solutions.problem032;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PandigitalProductsTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    PandigitalProducts.main(null);

    assertEquals(getResult("45228"), this.output.toString());
  }
}
