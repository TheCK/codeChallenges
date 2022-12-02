package org.ck.codingame.practice.easy.temperatures;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SolutionTest extends BaseTest {
  @ParameterizedTest
  @ValueSource(
      strings = {
        "simpleTestCase",
        "onlyNegativeNumbers",
        "chooseTheRightTemperature",
        "chooseTheRightTemperature2",
        "complexTestCase",
        "noTemperature"
      })
  public void test(String name) throws Exception {
    runFileAsStdInIgnoreExceptions(Solution.class, name);
  }
}
