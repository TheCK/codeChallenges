package org.ck.adventofcode.year2015;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.api.Test;

class Day06Test extends BaseAOCTest {
  @Test
  void testPartOne() throws Exception {
    runEncryptedTest(new Day06()::partOne, "day06/01");
  }

  @Test
  void testPartTwo() throws Exception {
    runEncryptedTest(new Day06()::partTwo, "day06/02");
  }
}
