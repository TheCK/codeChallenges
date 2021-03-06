package org.ck.codeEval.medium.carRace;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(
        getResult(
            "10 241.05",
            "6 244.98",
            "7 247.32",
            "1 254.07",
            "8 258.67",
            "3 273.02",
            "9 283.52",
            "5 298.28",
            "4 309.22",
            "2 375.86"),
        this.output.toString());
  }
}
