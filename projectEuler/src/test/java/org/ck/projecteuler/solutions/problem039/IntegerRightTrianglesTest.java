package org.ck.projecteuler.solutions.problem039;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegerRightTrianglesTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    IntegerRightTriangles.main(null);

    assertEquals(getResult("840"), this.output.toString());
  }
}
