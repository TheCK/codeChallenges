package org.ck.adventofcode.year2024;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Day13Test extends BaseAOCTest {
  @ParameterizedTest
  @ValueSource(strings = {"01a"})
  void testOne(String name) throws Exception {
    runTest(new Day13()::partOne, "day13/%s".formatted(name));
  }

  @Test
  void testOne() throws Exception {
    runEncryptedTest(new Day13()::partOne, "day13/01");
  }

  @ParameterizedTest
  @ValueSource(strings = {"02a"})
  void testTwo(String name) throws Exception {
    runTest(new Day13()::partTwo, "day13/%s".formatted(name));
  }

  @Test
  void testTwo() throws Exception {
    runEncryptedTest(new Day13()::partTwo, "day13/02");
  }
}
