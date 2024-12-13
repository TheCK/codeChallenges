package org.ck.adventofcode.year2015;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Day02Test extends BaseAOCTest {
  @ParameterizedTest
  @ValueSource(strings = {"01a", "01b"})
  void testPartOneExamples(String name) throws Exception {
    runTest(new Day02()::partOne, "day02/%s".formatted(name));
  }

  @Test
  void testPartOne() throws Exception {
    runEncryptedTest(new Day02()::partOne, "day02/01");
  }

  @ParameterizedTest
  @ValueSource(strings = {"02a", "02b"})
  void testPartTwoExamples(String name) throws Exception {
    runTest(new Day02()::partTwo, "day02/%s".formatted(name));
  }

  @Test
  void testPartTwo() throws Exception {
    runEncryptedTest(new Day02()::partTwo, "day02/02");
  }
}
