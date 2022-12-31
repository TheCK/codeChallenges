package org.ck.codeeval.hard.stringsubstitution;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class MainTest extends BaseTest {
  @Test
  @Timeout(10)
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(getResult("11100110"), this.output.toString());
  }
}
