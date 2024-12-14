package org.ck.adventofcode.year2015;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Day03Test extends BaseAOCTest {
  @ParameterizedTest
  @ValueSource(strings = {"01a", "01b", "01c"})
  void testPartOneExamples(final String name) throws Exception {
    runTest(new Day03()::partOne, "day03/%s".formatted(name));
  }

  @ParameterizedTest
  @ValueSource(strings = {"02a", "02b", "02c"})
  void testPartTwoExamples(final String name) throws Exception {
    runTest(new Day03()::partTwo, "day03/%s".formatted(name));
  }
}
