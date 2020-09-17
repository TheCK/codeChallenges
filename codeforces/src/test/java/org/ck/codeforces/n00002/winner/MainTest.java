package org.ck.codeforces.n00002.winner;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MainTest extends BaseTest {
  @ParameterizedTest
  @ValueSource(strings = {"01", "02", "03", "04", "05", "06", "08", "custom01"})
  public void test(String name) throws Exception {
    runFileAsStdIn(Main.class, name);
  }
}
