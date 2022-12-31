package org.ck.codeeval.medium.lostInTranslation;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(
        getResult(
            "the public is amazed by the quickness of the juggler",
            "we think that our language is impossible to understand",
            "so it is okay if you decided to quit"),
        this.output.toString());
  }
}
