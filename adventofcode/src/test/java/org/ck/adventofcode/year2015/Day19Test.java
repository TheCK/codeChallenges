package org.ck.adventofcode.year2015;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Day19Test extends BaseAOCTest {
  @ParameterizedTest
  @ValueSource(strings = {"01a"})
  void testPartOneExamples(final String name) throws Exception {
    runTest(new Day19()::partOne, "day19/%s".formatted(name));
  }

  @ParameterizedTest
  @ValueSource(strings = {"02a", "02b"})
  void testPartTwoExamples(final String name) throws Exception {
    runTest(new Day19()::partTwo, "day19/%s".formatted(name));
  }
}
