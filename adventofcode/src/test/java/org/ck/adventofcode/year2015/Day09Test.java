package org.ck.adventofcode.year2015;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Day09Test extends BaseAOCTest {
  @ParameterizedTest
  @ValueSource(strings = {"01a"})
  void testPartOneExamples(String name) throws Exception {
    runTest(new Day09()::partOne, "day09/%s".formatted(name));
  }

  @Test
  void testPartOne() throws Exception {
    runEncryptedTest(new Day09()::partOne, "day09/01");
  }

  @ParameterizedTest
  @ValueSource(strings = {"02a"})
  void testPartTwoExamples(String name) throws Exception {
    runTest(new Day09()::partTwo, "day09/%s".formatted(name));
  }

  @Test
  void testPartTwo() throws Exception {
    runEncryptedTest(new Day09()::partTwo, "day09/02");
  }
}
