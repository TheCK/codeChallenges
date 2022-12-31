package org.ck.codeeval.easy.uniqueelements;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(getResult("1,2,3,4", "2,3,4,5"), this.output.toString());
  }

  @Test
  public void testCustom00() throws Exception {
    Main.main(getFileAsArgs("custom00"));

    assertEquals(getResult("3", "1,4,10"), this.output.toString());
  }
}
