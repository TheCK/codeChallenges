package org.ck.adventofcode.year2015;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.api.Test;

class Day16Test extends BaseAOCTest {
  @Test
  void testPartOne() throws Exception {
    runEncryptedTest(new Day16()::partOne, "day16/01");
  }

  @Test
  void testPartTwo() throws Exception {
    runEncryptedTest(new Day16()::partTwo, "day16/02");
  }
}
