package org.ck.adventofcode.year2023;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Day16Test extends BaseAOCTest {
  @ParameterizedTest
  @ValueSource(strings = {"01"})
  @Disabled
  void testOne(String name) throws Exception {
    runTest(new Day16()::partOne, "day16/%s".formatted(name));
  }

  @ParameterizedTest
  @ValueSource(strings = {"02"})
  @Disabled
  void testTwo(String name) throws Exception {
    runTest(new Day16()::partTwo, "day16/%s".formatted(name));
  }
}
