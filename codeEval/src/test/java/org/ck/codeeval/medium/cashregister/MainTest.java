package org.ck.codeeval.medium.cashregister;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(getResult("NICKEL,PENNY", "ERROR", "ZERO", "FIVE"), this.output.toString());
  }
}
