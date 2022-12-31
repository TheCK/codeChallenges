package org.ck.codility.challenges.alpha2010;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class SolutionTest extends BaseTest {
  @Test
  @Timeout(10)
  public void test00() throws Exception {
    int result = new Solution().solution(new int[] {2, 2, 1, 0, 1});

    assertEquals(3, result);
  }
}
