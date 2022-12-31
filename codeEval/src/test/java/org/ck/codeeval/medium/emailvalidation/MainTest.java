package org.ck.codeeval.medium.emailvalidation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(getResult("true", "false", "false", "true"), this.output.toString());
  }

  @Test
  public void test01() throws Exception {
    Main.main(getFileAsArgs("01"));

    assertEquals(
        getResult(
            "false", "true", "true", "true", "true", "false", "true", "false", "false", "true",
            "false", "false", "true", // ?????
            "false", "true", "true", "false", "false", "false", "true"),
        this.output.toString());
  }

  @Test
  public void testCustom00() throws Exception {
    Main.main(getFileAsArgs("custom00"));

    assertEquals(getResult("true", "false"), this.output.toString());
  }
}
