package org.ck.codeeval.easy.timetoeat;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(
        getResult("14:44:45 09:53:27 02:26:31", "21:25:41 05:33:44"), this.output.toString());
  }
}
