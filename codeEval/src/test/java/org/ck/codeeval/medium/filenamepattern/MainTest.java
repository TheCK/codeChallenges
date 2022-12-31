package org.ck.codeeval.medium.filenamepattern;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(
        getResult(
            "bh1770.h",
            "IBM1008_420.so",
            "menu_no_no.utf-8.vim",
            "-",
            "groff-base.conffiles",
            "46b2fd3b.0 libip6t_frag.so"),
        this.output.toString());
  }
}
