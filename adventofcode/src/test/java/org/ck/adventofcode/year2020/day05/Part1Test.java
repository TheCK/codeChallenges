package org.ck.adventofcode.year2020.day05;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Part1Test extends BaseTest {
  @ParameterizedTest
  @ValueSource(strings = {"01a", "01b", "01c", "01d", "01"})
  public void test(String name) throws Exception {
    runFileAsStdIn(Part1.class, name);
  }
}
