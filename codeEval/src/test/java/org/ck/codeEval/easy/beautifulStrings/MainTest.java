package org.ck.codeEval.easy.beautifulStrings;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MainTest extends BaseTest {
  @ParameterizedTest
  @ValueSource(strings = {"00"})
  public void test(String name) throws Exception {
    runFileAsArg(Main.class, name);
  }
}
