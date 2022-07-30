package org.ck.codingcompetitions.codejam.year2022.qualification.problem2;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SolutionTest extends BaseTest {
  @ParameterizedTest
  @ValueSource(strings = {"01"})
  public void test(String name) throws Exception {
    runFileAsStdIn(Solution.class, name);
  }
}
