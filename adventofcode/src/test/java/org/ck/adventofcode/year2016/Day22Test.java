package org.ck.adventofcode.year2016;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Day22Test extends BaseAOCTest {
  @ParameterizedTest
  @ValueSource(strings = {"01"})
  @Disabled
  void testOne(String name) throws Exception {
    runTest(new Day22()::partOne, "day22/%s".formatted(name));
  }

  @ParameterizedTest
  @ValueSource(strings = {"02"})
  @Disabled
  void testTwo(String name) throws Exception {
    runTest(new Day22()::partTwo, "day22/%s".formatted(name));
  }
}
