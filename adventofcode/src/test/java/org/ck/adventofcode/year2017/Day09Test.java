package org.ck.adventofcode.year2017;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Day09Test extends BaseAOCTest {
  @ParameterizedTest
  @ValueSource(strings = {"01", "01a", "01b", "01c", "01d", "01e", "01f", "01g", "01h"})
  void testOne(String name) throws Exception {
    runTest(new Day09()::partOne, "day09/%s".formatted(name));
  }

  @ParameterizedTest
  @ValueSource(strings = {"02", "02a", "02b", "02c", "02d", "02e", "02f", "02g", "02h"})
  void testTwo(String name) throws Exception {
    runTest(new Day09()::partTwo, "day09/%s".formatted(name));
  }
}
