package org.ck.codeeval.easy.simpleSorting;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(
        getResult(
            "-38.797 7.581 14.354 70.920 90.374 99.323",
            "-55.552 -37.507 -3.263 27.999 40.079 65.213"),
        this.output.toString());
  }
}
