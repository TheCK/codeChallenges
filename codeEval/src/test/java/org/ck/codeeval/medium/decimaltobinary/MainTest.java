package org.ck.codeeval.medium.decimaltobinary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(getResult("10", "1010", "1000011"), this.output.toString());
  }
}
