package org.ck.codeEval.easy.sumOfPrimes;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(null);

    assertEquals(getResult("3682913"), this.output.toString());
  }
}
