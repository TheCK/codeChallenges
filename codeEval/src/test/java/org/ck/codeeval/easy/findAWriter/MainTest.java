package org.ck.codeeval.easy.findAWriter;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(getResult("Stephen King 1947", "Kyotaro Nishimura 1930"), this.output.toString());
  }
}
