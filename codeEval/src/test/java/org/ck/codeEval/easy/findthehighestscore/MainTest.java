package org.ck.codeEval.easy.findthehighestscore;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(
        getResult("100 250 150", "13 25 70 44", "100 200 300 400 500"), this.output.toString());
  }
}
