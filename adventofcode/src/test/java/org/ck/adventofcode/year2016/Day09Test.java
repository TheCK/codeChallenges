package org.ck.adventofcode.year2016;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Day09Test extends BaseAOCTest {
  @ParameterizedTest
  @ValueSource(strings = {"01a"})
  void testPartOneExamples(final String name) throws Exception {
    runTest(new Day09()::partOne, "day09/%s".formatted(name));
  }

  @ParameterizedTest
  @ValueSource(strings = {"02a"})
  void testPartTwoExamples(final String name) throws Exception {
    runTest(new Day09()::partTwo, "day09/%s".formatted(name));
  }
}
