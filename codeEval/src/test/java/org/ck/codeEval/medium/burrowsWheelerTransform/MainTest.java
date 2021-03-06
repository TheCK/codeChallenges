package org.ck.codeEval.medium.burrowsWheelerTransform;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(
        getResult(
            "Buffalo buffalo Buffalo buffalo buffalo buffalo Buffalo buffalo$",
            "James while John had had had had had had had had had had had a better effect on the teacher$",
            "Neko no ko koneko, shishi no ko kojishi$"),
        this.output.toString());
  }
}
