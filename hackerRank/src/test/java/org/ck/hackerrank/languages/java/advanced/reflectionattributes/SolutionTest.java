package org.ck.hackerrank.languages.java.advanced.reflectionattributes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SolutionTest extends BaseTest {
  @ParameterizedTest
  @ValueSource(strings = {"00"})
  public void test(String name) throws Exception {
    Solution.main(null);

    assertEquals(getFileAsResult(name), this.output.toString());
  }
}
