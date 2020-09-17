package org.ck.codeEval.hard.robotMovements;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(null);

    assertEquals(getResult("184"), this.output.toString());
  }
}
