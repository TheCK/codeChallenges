package org.ck.codeeval.easy.primepalindrome;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(null);

    assertEquals(getResult("929"), this.output.toString());
  }
}
