package org.ck.adventofcode.year2015;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Day05Test extends BaseAOCTest {
  @ParameterizedTest
  @ValueSource(strings = {"01a", "01b", "01c", "01d", "01e"})
  void testPartOneExamples(final String name) throws Exception {
    runTest(new Day05()::partOne, "day05/%s".formatted(name));
  }

  @ParameterizedTest
  @ValueSource(strings = {"02a", "02b", "02c", "02d"})
  void testPartTwoExamples(final String name) throws Exception {
    runTest(new Day05()::partTwo, "day05/%s".formatted(name));
  }
}
