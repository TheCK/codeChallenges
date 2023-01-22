package org.ck.cses.contests.datatähti2023alku;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BCowsTest extends BaseTest {
  @ParameterizedTest
  @ValueSource(strings = {"b_cows_01"})
  public void test(String name) throws Exception {
    runFileAsStdIn(BCows.class, name);
  }
}
