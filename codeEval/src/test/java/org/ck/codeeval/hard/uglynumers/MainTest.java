package org.ck.codeeval.hard.uglynumers;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(getResult("0", "1", "6", "64"), this.output.toString());
  }

  @Test
  @Disabled
  public void test01() throws Exception {
    Main.main(getFileAsArgs("01"));

    assertEquals(getResult("0", "1", "6", "64"), this.output.toString());
  }
}
