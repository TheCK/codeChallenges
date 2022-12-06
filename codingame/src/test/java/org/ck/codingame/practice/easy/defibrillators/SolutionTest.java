package org.ck.codingame.practice.easy.defibrillators;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SolutionTest extends BaseTest {
  @ParameterizedTest
  @ValueSource(
      strings = {
        "example",
        "exactPosition",
      })
  public void test(String name) throws Exception {
    runFileAsStdInIgnoreExceptions(Solution.class, name);
  }
}
