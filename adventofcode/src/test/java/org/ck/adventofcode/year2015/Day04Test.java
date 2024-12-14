package org.ck.adventofcode.year2015;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Day04Test extends BaseAOCTest {
  @ParameterizedTest
  @ValueSource(strings = {"01a", "01b"})
  void testPartOneExamples(final String name) throws Exception {
    runTest(new Day04()::partOne, "day04/%s".formatted(name));
  }
}
