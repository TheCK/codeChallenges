package org.ck.codeeval.medium.lowestcommonancestor;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(getResult("30", "8"), this.output.toString());
  }

  @Test
  public void test01() throws Exception {
    Main.main(getFileAsArgs("01"));

    assertEquals(
        getResult(
            "8", "8", "30", "8", "20", "8", "8", "8", "30", "8", "30", "20", "20", "20", "30", "8",
            "30", "30", "8", "8"),
        this.output.toString());
  }
}
