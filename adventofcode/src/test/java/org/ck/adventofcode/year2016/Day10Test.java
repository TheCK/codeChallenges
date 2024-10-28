package org.ck.adventofcode.year2016;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Day10Test extends BaseAOCTest {
  @ParameterizedTest
  @ValueSource(strings = {"01", "01a"})
  void testOne(String name) throws Exception {
    runTest(new Day10()::partOne, "day10/%s".formatted(name));
  }

  @ParameterizedTest
  @ValueSource(strings = {"02", "02a"})
  void testTwo(String name) throws Exception {
    runTest(new Day10()::partTwo, "day10/%s".formatted(name));
  }
}
