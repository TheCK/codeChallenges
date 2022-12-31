package org.ck.codeeval.medium.reversegroups;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(getResult("2,1,4,3,5", "3,2,1,4,5"), this.output.toString());
  }
}
