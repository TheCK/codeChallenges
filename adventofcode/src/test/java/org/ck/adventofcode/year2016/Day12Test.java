package org.ck.adventofcode.year2016;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Day12Test extends BaseAOCTest {
  @ParameterizedTest
  @ValueSource(strings = {"01", "01a"})
  @Disabled
  void testOne(String name) throws Exception {
    runTest(new Day12()::partOne, "day12/%s".formatted(name));
  }

  @ParameterizedTest
  @ValueSource(strings = {"02"})
  @Disabled
  void testTwo(String name) throws Exception {
    runTest(new Day12()::partTwo, "day12/%s".formatted(name));
  }
}
