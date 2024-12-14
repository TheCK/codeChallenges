package org.ck.adventofcode.year2017;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Day03Test extends BaseAOCTest {
  @ParameterizedTest
  @ValueSource(strings = {"01a", "01b", "01c", "01d"})
  void testPartOneExamples(final String name) throws Exception {
    runTest(new Day03()::partOne, "day03/%s".formatted(name));
  }
}
