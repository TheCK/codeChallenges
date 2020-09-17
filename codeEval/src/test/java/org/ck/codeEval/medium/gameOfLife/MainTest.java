package org.ck.codeEval.medium.gameOfLife;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(
        getResult(
            "..........",
            "...*......",
            "..*.*.....",
            "..*.*.....",
            "...*......",
            "..........",
            "..........",
            "..........",
            "..........",
            ".........."),
        this.output.toString());
  }
}
