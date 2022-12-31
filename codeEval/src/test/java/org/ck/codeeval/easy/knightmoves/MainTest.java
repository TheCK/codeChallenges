package org.ck.codeeval.easy.knightmoves;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(
        getResult(
            "e1 e3 f4 h4",
            "b3 c2",
            "b5 b7 c4 c8 e4 e8 f5 f7",
            "c4 c6 d3 d7 f3 f7 g4 g6",
            "a3 c3 d2"),
        this.output.toString());
  }
}
