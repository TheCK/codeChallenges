package org.ck.leetcode.problems.problem1757;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseMySqlTest;
import org.junit.jupiter.api.Test;

public class SolutionTest extends BaseMySqlTest {
  @Test
  void test00() throws Exception {
    prepareDb("00");

    final String result = queryDb(Solution.SQL);

    assertEquals(getFileAsResultNoNewLine("00"), result);
  }
}
