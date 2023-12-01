package org.ck.adventofcode.year2023;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Day07Test extends BaseAOCTest {
  @ParameterizedTest
  @ValueSource(strings = {"01", "01a"})
  @Disabled
  void testOne(String name) throws Exception {
    runTest(new Day07()::partOne, "day07/%s".formatted(name));
  }

  @ParameterizedTest
  @ValueSource(strings = {"02", "02a"})
  @Disabled
  void testTwo(String name) throws Exception {
    runTest(new Day07()::partTwo, "day07/%s".formatted(name));
  }
}
