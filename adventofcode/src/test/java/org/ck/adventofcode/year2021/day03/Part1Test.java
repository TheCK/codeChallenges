package org.ck.adventofcode.year2021.day03;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Part1Test extends BaseTest {
  @ParameterizedTest
  @ValueSource(strings = {"01", "01a"})
  public void test(String name) throws Exception {
    runFileAsStdIn(Part1.class, name);
  }
}
