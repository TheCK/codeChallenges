package org.ck.adventofcode.year2015;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.api.Test;

class Day23Test extends BaseAOCTest {
  @Test
  void testPartOne() throws Exception {
    runEncryptedTest(new Day23()::partOne, "day23/01");
  }

  @Test
  void testPartTwo() throws Exception {
    runEncryptedTest(new Day23()::partTwo, "day23/02");
  }
}
