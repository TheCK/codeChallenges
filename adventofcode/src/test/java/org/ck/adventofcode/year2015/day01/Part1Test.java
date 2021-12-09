package org.ck.adventofcode.year2015.day01;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Part1Test extends BaseTest {
  @ParameterizedTest
  @ValueSource(strings = {"01", "01a", "01b", "01c", "01d", "01e", "01f", "01g", "01h", "01i"})
  public void test(String name) throws Exception {
    runFileAsStdIn(Part1.class, name);
  }
}