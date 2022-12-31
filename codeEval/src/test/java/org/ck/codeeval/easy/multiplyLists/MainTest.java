package org.ck.codeeval.easy.multiplyLists;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(getResult("135 0 54", "40", "13 16 225 14 120 10"), this.output.toString());
  }
}
