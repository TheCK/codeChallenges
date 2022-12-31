package org.ck.codeeval.medium.twentyFortyEight;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(
        getResult("0 0 4 2|0 0 0 8|0 4 2 4|0 2 4 4", "4 2 2 4|0 16 0 8|0 0 0 16|0 0 0 0"),
        this.output.toString());
  }
}
