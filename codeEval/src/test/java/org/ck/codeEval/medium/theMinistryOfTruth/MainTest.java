package org.ck.codeEval.medium.theMinistryOfTruth;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(
        getResult("Hi____ mean___", "I cannot fix history", "______ two minutes", "____e_ _______"),
        this.output.toString());
  }
}
