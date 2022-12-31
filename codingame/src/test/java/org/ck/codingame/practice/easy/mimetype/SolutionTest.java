package org.ck.codingame.practice.easy.mimetype;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SolutionTest extends BaseTest {
  @ParameterizedTest
  @ValueSource(strings = {"simple", "unknown", "correctDivision", "case"})
  public void test(String name) throws Exception {
    runFileAsStdIn(Solution.class, name);
  }
}
