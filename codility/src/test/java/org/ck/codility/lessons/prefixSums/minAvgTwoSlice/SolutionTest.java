package org.ck.codility.lessons.prefixSums.minAvgTwoSlice;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest extends BaseTest {
  @Disabled
  @Test
  @Timeout(10)
  public void test00() throws Exception {
    int result = new Solution().solution(new int[] {4, 2, 2, 5, 1, 5, 8});

    assertEquals(1, result);
  }
}
