package org.ck.codility.lessons.prefixsums.minavgtwoslice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class SolutionTest extends BaseTest {
  @Disabled
  @Test
  @Timeout(10)
  public void test00() throws Exception {
    int result = new Solution().solution(new int[] {4, 2, 2, 5, 1, 5, 8});

    assertEquals(1, result);
  }
}
