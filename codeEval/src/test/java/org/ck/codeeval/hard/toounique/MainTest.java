package org.ck.codeeval.hard.toounique;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(
        getResult(
            "rzqicaiiae**",
            "ccwnulljyb**",
            "jxtx***uwu**",
            "oqik****zp**",
            "vbla****bd**",
            "ahje****cl**"),
        this.output.toString());
  }
}
