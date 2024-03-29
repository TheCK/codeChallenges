package org.ck.codeeval.hard.asciidecryption;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(
        getResult("The needs of the many outweigh the needs of the few. - Spock"),
        this.output.toString());
  }
}
