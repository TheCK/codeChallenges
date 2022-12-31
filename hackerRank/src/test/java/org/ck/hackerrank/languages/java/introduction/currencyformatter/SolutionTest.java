package org.ck.hackerrank.languages.java.introduction.currencyformatter;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SolutionTest extends BaseTest {
  @ParameterizedTest
  @ValueSource(strings = {"00"})
  @Disabled("Encoding mismatch")
  public void test(String name) throws Exception {
    runFileAsStdIn(Solution.class, name);
  }
}
