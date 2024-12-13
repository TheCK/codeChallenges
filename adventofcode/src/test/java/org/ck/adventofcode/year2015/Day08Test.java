package org.ck.adventofcode.year2015;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Day08Test extends BaseAOCTest {
  @ParameterizedTest
  @ValueSource(strings = {"01a"})
  void testPartOneExamples(String name) throws Exception {
    runTest(new Day08()::partOne, "day08/%s".formatted(name));
  }

  @Test
  void testPartOne() throws Exception {
    runEncryptedTest(new Day08()::partOne, "day08/01");
  }

  @ParameterizedTest
  @ValueSource(strings = {"02a"})
  void testPartTwoExamples(String name) throws Exception {
    runTest(new Day08()::partTwo, "day08/%s".formatted(name));
  }

  @Test
  void testPartTwo() throws Exception {
    runEncryptedTest(new Day08()::partTwo, "day08/02");
  }
}
