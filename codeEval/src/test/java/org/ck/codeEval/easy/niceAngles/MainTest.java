package org.ck.codeEval.easy.niceAngles;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(
        getResult("330.23'59\"", "0.00'03\"", "14.38'43\"", "0.15'00\"", "254.10'11\""),
        this.output.toString());
  }
}
