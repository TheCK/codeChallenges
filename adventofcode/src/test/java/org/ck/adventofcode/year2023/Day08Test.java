package org.ck.adventofcode.year2023;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Day08Test extends BaseAOCTest {
  @ParameterizedTest
  @ValueSource(strings = {"01a", "01b"})
  void testPartOneExamples(final String name) throws Exception {
    runTest(new Day08()::partOne, "day08/%s".formatted(name));
  }

  @ParameterizedTest
  @ValueSource(strings = {"02a"})
  void testPartTwoExamples(final String name) throws Exception {
    runTest(new Day08()::partTwo, "day08/%s".formatted(name));
  }
}
