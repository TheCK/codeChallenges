package org.ck.adventofcode.year2024;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Day24Test extends BaseAOCTest {
  @ParameterizedTest
  @ValueSource(strings = {"01a", "01b"})
  void testPartOneExamples(final String name) throws Exception {
    runTest(new Day24()::partOne, "day24/%s".formatted(name));
  }

  @Test
  @Disabled
  void testPartTwo() throws Exception {
    // not working yet
  }
}
