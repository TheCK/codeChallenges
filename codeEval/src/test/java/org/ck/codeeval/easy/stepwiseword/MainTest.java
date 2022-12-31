package org.ck.codeeval.easy.stepwiseword;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(
        getResult(
            "h *e **l ***l ****o",
            "f *o **o ***t ****b *****a ******l *******l",
            "m *u **s ***i ****c"),
        this.output.toString());
  }
}
