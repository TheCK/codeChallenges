package org.ck.projectEuler.solutions.problem031;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoinSumsTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    CoinSums.main(null);

    assertEquals(getResult("73682"), this.output.toString());
  }
}
