package org.ck.codeeval.easy.lettercasepercentageratio;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(
        getResult(
            "lowercase: 50.00 uppercase: 50.00",
            "lowercase: 20.00 uppercase: 80.00",
            "lowercase: 0.00 uppercase: 100.00",
            "lowercase: 33.33 uppercase: 66.67"),
        this.output.toString());
  }
}
