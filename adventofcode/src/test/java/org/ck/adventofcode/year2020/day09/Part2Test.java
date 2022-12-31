package org.ck.adventofcode.year2020.day09;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Part2Test extends BaseTest {
  @ParameterizedTest
  @ValueSource(strings = {"02a", "02"})
  public void test(String name) throws Exception {
    runFileAsStdIn(Part2.class, name);
  }
}
