package org.ck.codeeval.easy.queryboard;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(getResult("5118", "34", "1792", "3571"), this.output.toString());
  }
}
