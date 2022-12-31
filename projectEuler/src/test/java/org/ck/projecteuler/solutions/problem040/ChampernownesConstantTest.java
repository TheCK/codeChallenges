package org.ck.projecteuler.solutions.problem040;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class ChampernownesConstantTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    ChampernownesConstant.main(null);

    assertEquals(getResult("210"), this.output.toString());
  }
}
