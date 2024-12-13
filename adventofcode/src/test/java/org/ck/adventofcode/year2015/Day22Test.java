package org.ck.adventofcode.year2015;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.api.Test;

class Day22Test extends BaseAOCTest {
  @Test
  void testPartOne() throws Exception {
    runEncryptedTest(new Day22()::partOne, "day22/01");
  }

  @Test
  void testPartTwo() throws Exception {
    runEncryptedTest(new Day22()::partTwo, "day22/02");
  }
}
