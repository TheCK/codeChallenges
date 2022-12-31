package org.ck.codingame.practice.easy.unary;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SolutionTest extends BaseTest {
  @ParameterizedTest
  @ValueSource(strings = {"c", "cc", "percent", "chuckNorris"})
  public void test(String name) throws Exception {
    runFileAsStdIn(Solution.class, name);
  }
}
