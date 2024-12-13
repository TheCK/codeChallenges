package org.ck.adventofcode.year2015;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Day03Test extends BaseAOCTest {
  @ParameterizedTest
  @ValueSource(strings = {"01a", "01b", "01c"})
  void testPartOneExamples(String name) throws Exception {
    runTest(new Day03()::partOne, "day03/%s".formatted(name));
  }

  @Test
  void testPartOne() throws Exception {
    runEncryptedTest(new Day03()::partOne, "day03/01");
  }

  @ParameterizedTest
  @ValueSource(strings = {"02a", "02b", "02c"})
  void testPartTwoExamples(String name) throws Exception {
    runTest(new Day03()::partTwo, "day03/%s".formatted(name));
  }

  @Test
  void testPartTwo() throws Exception {
    runEncryptedTest(new Day03()::partTwo, "day03/02");
  }
}
