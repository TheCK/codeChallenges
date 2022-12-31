package org.ck.codeeval.medium.romanAndArabic;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(getResult("3700", "-16"), this.output.toString());
  }

  @Test
  public void test01() throws Exception {
    Main.main(getFileAsArgs("01"));

    assertEquals(
        getResult(
            "68", "300", "3700", "20310", "14844", "800", "11962", "4002", "8992", "17991", "3500",
            "8020", "8750", "-16", "14549", "9825", "4993", "266", "2985", "1296", "1980", "19730",
            "1000", "517", "2202", "18764", "2000", "12997", "10", "120", "11500", "13350", "12975",
            "17945", "14870", "100", "128", "7344", "675", "9300"),
        this.output.toString());
  }
}
