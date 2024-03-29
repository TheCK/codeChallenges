package org.ck.codeeval.easy.swapelements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(getResult("9 2 3 4 5 6 7 8 1", "2 4 3 1 5 6 7 8 9 10"), this.output.toString());
  }
}
