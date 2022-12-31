package org.ck.codeeval.medium.flaviusJosephus;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(getResult("2 5 8 1 6 0 7 4 9 3", "1 3 0 4 2"), this.output.toString());
  }
}
