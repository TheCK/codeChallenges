package org.ck.codeeval.medium.aPileOfBricks;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(getResult("1", "1,2", "-"), this.output.toString());
  }

  @Test
  public void test01() throws Exception {
    Main.main(getFileAsArgs("01"));

    assertEquals(
        getResult(
            "1",
            "-",
            "-",
            "-",
            "1,2,4",
            "4,5,6,7",
            "1",
            "-",
            "4",
            "2",
            "-",
            "1,5,8,10,11,13",
            "12",
            "-",
            "-",
            "1,3,5,9,10,11,12",
            "1,2,3",
            "1",
            "3,4",
            "6,7,13"),
        this.output.toString());
  }
}
