package org.ck.codeeval.easy.swapnumbers;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(
        getResult(
            "0Always4 8look5 9on4 2the7 8bright4 7side9 8of3 5life5",
            "5Nobody5 3expects7 4the5 4Spanish6 0inquisition9"),
        this.output.toString());
  }
}
