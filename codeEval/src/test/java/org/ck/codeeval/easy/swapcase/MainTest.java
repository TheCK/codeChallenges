package org.ck.codeeval.easy.swapcase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(
        getResult("hELLO WORLD!", "jAVAsCRIPT LANGUAGE 1.8", "a LETTER"), this.output.toString());
  }
}
