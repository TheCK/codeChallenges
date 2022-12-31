package org.ck.codeeval.medium.justifythetext;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseTest {
  @Test
  public void test00() throws Exception {
    Main.main(getFileAsArgs("00"));

    assertEquals(
        getResult(
            "Hello, World!",
            "The         precise         50-digits        value        of        Pi        is",
            "3.14159265358979323846264338327950288419716939937510.",
            "But  he  who would be a great man ought to regard, not himself or his interests,",
            "but what is just, whether the just act be his own or that of another. Next as to",
            "habitations. Such is the tradition."),
        this.output.toString());
  }
}
