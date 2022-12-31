package org.ck.codeeval.medium.magicnumbers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(
        getResult("13 15 17 19 31 35 37 39 51 53 57 59 71 73 75 79 91 93 95 97", "-1"),
        this.output.toString());
  }
}
