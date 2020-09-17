package org.ck.codeEval.hard.playWithDNA;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(getFileAsResult("00"), this.output.toString());
  }

  @Test
  public void testCustom00() throws Exception {
    Main.main(getFileAsArgs("custom00"));

    assertEquals(getFileAsResult("custom00"), this.output.toString());
  }

  @Test
  public void testCustom01() throws Exception {
    Main.main(getFileAsArgs("custom01"));

    assertEquals(getFileAsResult("custom01"), this.output.toString());
  }
}
