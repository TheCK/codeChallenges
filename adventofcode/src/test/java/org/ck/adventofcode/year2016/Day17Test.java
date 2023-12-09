package org.ck.adventofcode.year2016;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Day17Test extends BaseAOCTest {
  @ParameterizedTest
  @ValueSource(strings = {"01", "01a", "01b", "01c"})
  @Disabled
  void testOne(String name) throws Exception {
    runTest(new Day17()::partOne, "day17/%s".formatted(name));
  }

  @ParameterizedTest
  @ValueSource(strings = {"02", "02a", "02b", "02c"})
  @Disabled
  void testTwo(String name) throws Exception {
    runTest(new Day17()::partTwo, "day17/%s".formatted(name));
  }
}
