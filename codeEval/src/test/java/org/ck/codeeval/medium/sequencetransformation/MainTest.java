package org.ck.codeeval.medium.sequencetransformation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class MainTest extends BaseTest {
  @Test
  @Timeout(10)
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(getResult("Yes", "Yes", "Yes", "No"), this.output.toString());
  }

  @Test
  @Timeout(10)
  public void test01() throws Exception {
    Main.main(getFileAsArgs("01"));

    assertEquals(
        getResult(
            "Yes", "No", "No", "No", "No", "No", "Yes", "No", "Yes", "Yes", "No", "No", "Yes",
            "Yes", "No", "No", "No", "Yes", "Yes", "No", "Yes", "Yes", "Yes", "No", "No", "No",
            "No", "Yes", "No", "No", "No", "Yes", "Yes", "Yes", "No", "No", "No", "No", "No", "No",
            "No", "No", "Yes", "No", "No", "Yes", "No", "No", "No", "No"),
        this.output.toString());
  }
}
