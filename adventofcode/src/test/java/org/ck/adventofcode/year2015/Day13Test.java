package org.ck.adventofcode.year2015;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Day13Test extends BaseAOCTest {
  @ParameterizedTest
  @ValueSource(strings = {"01", "01a"})
  void testOne(String name) throws Exception {
    runTest(new Day13()::partOne, "day13/%s".formatted(name));
  }

  @ParameterizedTest
  @ValueSource(strings = {"02"})
  void testTwo(String name) throws Exception {
    runTest(new Day13()::partTwo, "day13/%s".formatted(name));
  }
}
