package org.ck.codeeval.medium.meetcocktailsort;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(getResult("1 4 5 9 7 3 2 6 10", "1 2 3 6 5 4 7 8 9"), this.output.toString());
  }
}
