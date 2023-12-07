package org.ck.adventofcode.year2015;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Day25Test extends BaseAOCTest {
  @ParameterizedTest
  @ValueSource(strings = {"01"})
  void testOne(String name) throws Exception {
    runTest(new Day25()::partOne, "day25/%s".formatted(name));
  }
}
