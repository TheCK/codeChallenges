package org.ck.codingame.practice.easy.onboarding;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerTest extends BaseTest {
  @ParameterizedTest
  @ValueSource(strings = {"imminentDanger"})
  public void test(String name) throws Exception {
    runFileAsStdInIgnoreExceptions(Player.class, name);
  }
}
