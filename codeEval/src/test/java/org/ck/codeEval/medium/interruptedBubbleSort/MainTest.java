package org.ck.codeEval.medium.interruptedBubbleSort;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(
        getResult(
            "36 47 28 20 78 79 16 8 45 72 69 81 66 60 8 3 86 87 90 90",
            "40 42 24 16 52 66 69",
            "0 15 25 18 34 5 21 46 47 48 48 1 43 50 53 29 54 62 74 74 76 78",
            "5 48 18 51 61",
            "55 31 59 4 1 25 26 19 60 0 68 73"),
        this.output.toString());
  }
}
