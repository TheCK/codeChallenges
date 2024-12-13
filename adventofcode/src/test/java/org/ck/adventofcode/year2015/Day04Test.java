package org.ck.adventofcode.year2015;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Day04Test extends BaseAOCTest {
  @ParameterizedTest
  @ValueSource(strings = {"01a", "01b"})
  void testPartOneExamples(String name) throws Exception {
    runTest(new Day04()::partOne, "day04/%s".formatted(name));
  }

  @Test
  void testPartOne() throws Exception {
    runEncryptedTest(new Day04()::partOne, "day04/01");
  }

  @Test
  void testPartTwo() throws Exception {
    runEncryptedTest(new Day04()::partTwo, "day04/02");
  }
}
