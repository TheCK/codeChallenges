package org.ck.adventofcode.year2017;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Day01Test extends BaseAOCTest {
  @ParameterizedTest
  @ValueSource(strings = {"01", "01a", "01b", "01c", "01d"})
  void testOne(String name) throws Exception {
    runTest(new Day01()::partOne, "day01/%s".formatted(name));
  }

  @ParameterizedTest
  @ValueSource(strings = {"02", "02a", "02b", "02c", "02d", "02e"})
  void testTwo(String name) throws Exception {
    runTest(new Day01()::partTwo, "day01/%s".formatted(name));
  }
}
