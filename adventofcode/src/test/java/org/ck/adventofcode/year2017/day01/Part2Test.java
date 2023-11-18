package org.ck.adventofcode.year2017.day01;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Part2Test extends BaseTest {
  @ParameterizedTest
  @ValueSource(strings = {"02", "02a", "02b", "02c", "02d", "02e"})
  public void test(String name) throws Exception {
    runFileAsStdIn(Part2.class, name);
  }
}
