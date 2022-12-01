package org.ck.codingame.practice.easy.powerofthor1;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerTest extends BaseTest {
  @ParameterizedTest
  @ValueSource(strings = {"straightLine", "up", "easyAngle", "optimalAngle"})
  public void test(String name) throws Exception {
    runFileAsStdInIgnoreExceptions(Player.class, name);
  }
}
