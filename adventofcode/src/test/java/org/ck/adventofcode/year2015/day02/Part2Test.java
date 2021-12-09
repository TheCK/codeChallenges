package org.ck.adventofcode.year2015.day02;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Part2Test extends BaseTest {
  @ParameterizedTest
  @ValueSource(strings = {"02", "02a", "02b"})
  public void test(String name) throws Exception {
    runFileAsStdIn(Part2.class, name);
  }
}