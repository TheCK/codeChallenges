package org.ck.codeeval.easy.findthehighestscore;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(
        getResult("100 250 150", "13 25 70 44", "100 200 300 400 500"), this.output.toString());
  }
}
