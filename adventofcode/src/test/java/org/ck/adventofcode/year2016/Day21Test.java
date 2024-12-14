package org.ck.adventofcode.year2016;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Day21Test extends BaseAOCTest {
  @ParameterizedTest
  @ValueSource(strings = {"01a"})
  void testPartOneExamples(final String name) throws Exception {
    runTest(new Day21()::partOne, "day21/%s".formatted(name));
  }

  @ParameterizedTest
  @ValueSource(strings = {"02a", "02b"})
  void testPartTwoExamples(final String name) throws Exception {
    runTest(new Day21()::partTwo, "day21/%s".formatted(name));
  }
}
