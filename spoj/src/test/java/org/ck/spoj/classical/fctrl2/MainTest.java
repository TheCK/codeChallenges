package org.ck.spoj.classical.fctrl2;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MainTest extends BaseTest {
  @ParameterizedTest
  @ValueSource(strings = {"01"})
  public void test(String name) throws Exception {
    runFileAsStdIn(Main.class, name);
  }
}
