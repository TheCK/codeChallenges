package org.ck.adventofcode.year2024;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Disabled
class Day14Test extends BaseAOCTest {
  @ParameterizedTest
  @ValueSource(strings = {"01a"})
  void testPartOneExamples(String name) throws Exception {
    runTest(new Day14()::partOne, "day14/%s".formatted(name));
  }

  @Test
  void testPartOne() throws Exception {
    runEncryptedTest(new Day14()::partOne, "day14/01");
  }

  @Test
  void testPartTwo() throws Exception {
    runEncryptedTest(new Day14()::partTwo, "day14/02");
  }
}
