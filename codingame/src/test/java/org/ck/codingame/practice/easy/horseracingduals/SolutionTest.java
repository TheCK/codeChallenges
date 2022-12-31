package org.ck.codingame.practice.easy.horseracingduals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SolutionTest extends BaseTest {
  @ParameterizedTest
  @ValueSource(
      strings = {
        "simple",
        "anyOrder",
      })
  public void test(String name) throws Exception {
    runFileAsStdInIgnoreExceptions(Solution.class, name);
  }
}
