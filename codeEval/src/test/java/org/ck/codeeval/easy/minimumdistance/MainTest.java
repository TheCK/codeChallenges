package org.ck.codeeval.easy.minimumdistance;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(getResult("6", "20"), this.output.toString());
  }

  @Test
  public void test01() throws Exception {
    Main.main(getFileAsArgs("01"));

    assertEquals(
        getResult(
            "234910", "84553", "1889", "20", "5628", "111537", "62447", "6", "24357", "188841"),
        this.output.toString());
  }
}
