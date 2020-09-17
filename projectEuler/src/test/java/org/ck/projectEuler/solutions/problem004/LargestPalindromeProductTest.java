package org.ck.projectEuler.solutions.problem004;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LargestPalindromeProductTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    LargestPalindromeProduct.main(null);

    assertEquals(getResult("906609"), this.output.toString());
  }
}
