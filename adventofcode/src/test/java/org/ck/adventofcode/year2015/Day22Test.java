package org.ck.adventofcode.year2015;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Day22Test extends BaseAOCTest {
  @ParameterizedTest
  @ValueSource(strings = {"01"})
  void testOne(String name) throws Exception {
    runTest(new Day22()::partOne, "day22/%s".formatted(name));
  }

  @ParameterizedTest
  @ValueSource(strings = {"02"})
  void testTwo(String name) throws Exception {
    runTest(new Day22()::partTwo, "day22/%s".formatted(name));
  }
}
