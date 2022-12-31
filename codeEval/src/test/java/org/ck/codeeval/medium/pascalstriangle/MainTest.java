package org.ck.codeeval.medium.pascalstriangle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(getResult("1 1 1 1 2 1 1 3 3 1 1 4 6 4 1 1 5 10 10 5 1"), this.output.toString());
  }
}
