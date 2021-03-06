package org.ck.hackerRank.languages.java.exceptionhandling.trycatch;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SolutionTest extends BaseTest {
  @ParameterizedTest
  @ValueSource(strings = {"00", "01", "02", "03"})
  public void test(String name) throws Exception {
    runFileAsStdIn(Solution.class, name);
  }
}
