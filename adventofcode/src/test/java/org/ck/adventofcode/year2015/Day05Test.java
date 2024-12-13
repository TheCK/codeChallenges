package org.ck.adventofcode.year2015;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Day05Test extends BaseAOCTest {
  @ParameterizedTest
  @ValueSource(strings = {"01a", "01b", "01c", "01d", "01e"})
  void testPartOneExamples(String name) throws Exception {
    runTest(new Day05()::partOne, "day05/%s".formatted(name));
  }

  @Test
  void testPartOne() throws Exception {
    runEncryptedTest(new Day05()::partOne, "day05/01");
  }

  @ParameterizedTest
  @ValueSource(strings = {"02a", "02b", "02c", "02d"})
  void testPartTwoExamples(String name) throws Exception {
    runTest(new Day05()::partTwo, "day05/%s".formatted(name));
  }

  @Test
  void testPartTwo() throws Exception {
    runEncryptedTest(new Day05()::partTwo, "day05/02");
  }
}
