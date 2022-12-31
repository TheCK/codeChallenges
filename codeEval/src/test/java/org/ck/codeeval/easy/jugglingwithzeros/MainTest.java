package org.ck.codeeval.easy.jugglingwithzeros;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(getResult("9", "1", "9208", "3"), this.output.toString());
  }

  @Test
  public void test01() throws Exception {
    Main.main(getFileAsArgs("01"));

    assertEquals(
        getResult(
            "5609",
            "0",
            "1",
            "9207",
            "80188471",
            "3",
            "4024",
            "1904409139",
            "5148",
            "780784224",
            "3783681916",
            "10",
            "28950142",
            "3029573849",
            "9693",
            "1730",
            "44489260",
            "0",
            "99597203",
            "77856860",
            "8170957",
            "60012616",
            "423699388",
            "9208",
            "5",
            "1",
            "5049",
            "8",
            "8193",
            "5034",
            "3070",
            "2111",
            "1177938625",
            "2639",
            "2839563197",
            "322559879",
            "2742008496",
            "8",
            "8517",
            "1177197551"),
        this.output.toString());
  }
}
