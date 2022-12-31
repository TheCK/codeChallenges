package org.ck.projecteuler.solutions.problem054;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ProblemTest extends BaseTest {
  @ParameterizedTest
  @ValueSource(strings = {"00", "01"})
  public void test(String name) throws Exception {
    runFileAsStdIn(Problem.class, name);
  }
}
