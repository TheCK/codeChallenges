package org.ck.codeeval.easy.withoutrepetitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(
        getResult(
            "But as he spake he drew the god sword from its scabard, and smote a heathen knight, Justin of the Iron Valey.",
            "No mater whom you chose, she declared, I wil abide by your decision.",
            "Wwhat is your wil?",
            "At his magic spech the ground opened and he began the path of descent.",
            "I should fly away and you would never se me again."),
        this.output.toString());
  }
}
