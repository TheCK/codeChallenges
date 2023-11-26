package org.ck.adventofcode.year2015;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Day05Test extends BaseAOCTest {
  @ParameterizedTest
  @ValueSource(strings = {"01", "01a", "01b", "01c", "01d", "01e"})
  void testOne(String name) throws Exception {
    runTest(new Day05()::partOne, "day05/%s".formatted(name));
  }

  @ParameterizedTest
  @ValueSource(strings = {"02", "02a", "02b", "02c", "02d"})
  void testTwo(String name) throws Exception {
    runTest(new Day05()::partTwo, "day05/%s".formatted(name));
  }
}
