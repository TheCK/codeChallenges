package org.ck.codingame.practice.easy.asciiart;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SolutionTest extends BaseTest {
  @ParameterizedTest
  @ValueSource(
      strings = {
        "e",
        "manhattan",
        "manhattanCamelCase",
        "m@nh@tt@n",
        "manhattanOther",
        "man_hat_tan"
      })
  public void test(String name) throws Exception {
    runFileAsStdInIgnoreExceptions(Solution.class, name);
  }
}
