package org.ck.codeEval.easy.swapCase;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(
        getResult("hELLO WORLD!", "jAVAsCRIPT LANGUAGE 1.8", "a LETTER"), this.output.toString());
  }
}
