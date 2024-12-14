package org.ck.adventofcode.year2023;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Day10Test extends BaseAOCTest {
  @ParameterizedTest
  @ValueSource(strings = {"01a", "01b"})
  void testPartOneExamples(final String name) throws Exception {
    runTest(new Day10()::partOne, "day10/%s".formatted(name));
  }

  @ParameterizedTest
  @ValueSource(strings = {"02a", "02b", "02c", "02d"})
  void testPartTwoExamples(final String name) throws Exception {
    runTest(new Day10()::partTwo, "day10/%s".formatted(name));
  }
}
