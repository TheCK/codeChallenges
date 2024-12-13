package org.ck.adventofcode.year2015;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Day10Test extends BaseAOCTest {
  @ParameterizedTest
  @ValueSource(strings = {"01a"})
  void testPartOneExamples(String name) throws Exception {
    runTest(new Day10()::partOne, "day10/%s".formatted(name));
  }

  @Test
  void testPartOne() throws Exception {
    runEncryptedTest(new Day10()::partOne, "day10/01");
  }

  @Test
  void testPartTwo() throws Exception {
    runEncryptedTest(new Day10()::partTwo, "day10/02");
  }
}
