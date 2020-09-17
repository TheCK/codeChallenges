package org.ck.codeEval.medium.uriComparison;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(getResult("True"), this.output.toString());
  }

  @Test
  public void test01() throws Exception {
    Main.main(getFileAsArgs("01"));

    assertEquals(
        getResult(
            "True", "False", "True", "True", "False", "True", "True", "True", "False", "True",
            "True", "False", "False", "True", "True", "True", "False", "True", "True", "False"),
        this.output.toString());
  }
}
