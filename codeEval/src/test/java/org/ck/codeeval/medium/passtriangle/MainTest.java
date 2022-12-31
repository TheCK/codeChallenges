package org.ck.codeeval.medium.passtriangle;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(getResult("27"), this.output.toString());
  }

  @Test
  public void test01() throws Exception {
    Main.main(getFileAsArgs("01"));

    assertEquals(getResult("732506"), this.output.toString());
  }
}
