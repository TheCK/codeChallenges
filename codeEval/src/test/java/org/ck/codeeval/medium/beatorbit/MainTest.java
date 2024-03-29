package org.ck.codeeval.medium.beatorbit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(getResult("10 | 11", "3 | 65 | 6"), this.output.toString());
  }

  @Test
  public void testCustom00() throws Exception {
    Main.main(getFileAsArgs("custom00"));

    assertEquals(
        getResult("0 | 1", "0 | 1 | 2 | 3", "0 | 1 | 2 | 3 | 4 | 5 | 6 | 7"),
        this.output.toString());
  }
}
