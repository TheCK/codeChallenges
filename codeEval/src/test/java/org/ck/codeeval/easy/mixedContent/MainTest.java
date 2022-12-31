package org.ck.codeeval.easy.mixedContent;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(
        getResult("melon,apricot,peach,pineapple|8,33,21,0,16,50,37,0,7,17,21", "24,13,14,43,41"),
        this.output.toString());
  }

  @Test
  public void testCustom00() throws Exception {
    Main.main(getFileAsArgs("custom00"));

    assertEquals(getResult("melon,apricot"), this.output.toString());
  }
}
