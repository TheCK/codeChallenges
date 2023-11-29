package org.ck.adventofcode.year2015;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Day12Test extends BaseAOCTest {
  @ParameterizedTest
  @ValueSource(strings = {"01", "01a", "01b", "01c", "01d", "01e", "01f", "01g", "01h"})
  void testOne(String name) throws Exception {
    runTest(new Day12()::partOne, "day12/%s".formatted(name));
  }

  @ParameterizedTest
  @ValueSource(strings = {"02", "02a", "02b", "02c", "02d"})
  void testTwo(String name) throws Exception {
    runTest(new Day12()::partTwo, "day12/%s".formatted(name));
  }
}
