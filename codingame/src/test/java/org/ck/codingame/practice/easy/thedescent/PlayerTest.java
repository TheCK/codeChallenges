package org.ck.codingame.practice.easy.thedescent;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerTest extends BaseTest {
  @ParameterizedTest
  @ValueSource(
      strings = {
        "descendingMountains",
        "scatteredMountains",
        "strongMountains1",
        "strongMountains2",
        "oneMountain"
      })
  public void test(String name) throws Exception {
    runFileAsStdInIgnoreExceptions(Player.class, name);
  }
}
