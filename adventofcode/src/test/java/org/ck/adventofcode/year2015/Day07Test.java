package org.ck.adventofcode.year2015;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.api.Test;

class Day07Test extends BaseAOCTest {
  @Test
  void testPartOne() throws Exception {
    runEncryptedTest(new Day07()::partOne, "day07/01");
  }

  @Test
  void testPartTwo() throws Exception {
    runEncryptedTest(new Day07()::partTwo, "day07/02");
  }
}
