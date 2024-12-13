package org.ck.adventofcode.year2015;

import org.ck.adventofcode.util.BaseAOCTest;
import org.junit.jupiter.api.Test;

class Day25Test extends BaseAOCTest {
  @Test
  void testPartOne() throws Exception {
    runEncryptedTest(new Day25()::partOne, "day25/01");
  }
}
