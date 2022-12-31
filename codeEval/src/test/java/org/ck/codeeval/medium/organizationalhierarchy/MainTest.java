package org.ck.codeeval.medium.organizationalhierarchy;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(getResult("a [b [c], e]", "a [b [c [d, x [z]]], e]"), this.output.toString());
  }
}
