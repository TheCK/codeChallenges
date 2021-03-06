package org.ck.codility.lessons.timeComplexity.permMissingElem;

import org.ck.codeChallengeLib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest extends BaseTest {
  @Test
  @Timeout(10)
  public void test00() throws Exception {
    int result = new Solution().solution(new int[] {2, 3, 1, 5});

    assertEquals(4, result);
  }
}
