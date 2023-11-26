package org.ck.adventofcode.year2015;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Day02Test extends BaseAOCTest {
  @ParameterizedTest
  @ValueSource(strings = {"01", "01a", "01b"})
  void testOne(String name) throws Exception {
    runTest(new Day02()::partOne, "day02/%s".formatted(name));
  }

  @ParameterizedTest
  @ValueSource(strings = {"02", "02a", "02b"})
  void testTwo(String name) throws Exception {
    runTest(new Day02()::partTwo, "day02/%s".formatted(name));
  }
}
