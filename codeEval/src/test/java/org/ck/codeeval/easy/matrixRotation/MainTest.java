package org.ck.codeeval.easy.matrixRotation;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(
        getResult("c a d b", "m i e a n j f b o k g c p l h d", "g d a h e b i f c"),
        this.output.toString());
  }
}
