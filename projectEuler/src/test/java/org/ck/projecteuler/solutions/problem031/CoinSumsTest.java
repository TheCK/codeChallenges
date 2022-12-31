package org.ck.projecteuler.solutions.problem031;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class CoinSumsTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    CoinSums.main(null);

    assertEquals(getResult("73682"), this.output.toString());
  }
}
