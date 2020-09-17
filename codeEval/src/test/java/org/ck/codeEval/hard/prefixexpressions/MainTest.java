package org.ck.codeEval.hard.prefixexpressions;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(getResult("20"), this.output.toString());
  }

  @Test
  public void test01() throws Exception {
    Main.main(getFileAsArgs("01"));

    assertEquals(
        getResult(
            "56", "1521", "0", "4", "0", "2", "5", "2", "344", "136", "9", "2601", "120", "0", "0",
            "10", "0", "22", "0", "14", "0", "1", "66627", "9", "7", "36", "9", "28", "42", "6321",
            "16", "14", "11", "20", "0", "4", "435", "8", "2868", "0"),
        this.output.toString());
  }
}
