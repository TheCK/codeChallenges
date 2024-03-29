package org.ck.codeeval.medium.numberpairs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(getResult("1,4;2,3", "5,15;9,11", "NULL"), this.output.toString());
  }
}
