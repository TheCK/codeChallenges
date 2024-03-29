package org.ck.codility.lessons.prefixsums.passingcars;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class SolutionTest extends BaseTest {
  @Test
  @Timeout(10)
  public void test00() throws Exception {
    int result = new Solution().solution(new int[] {0, 1, 0, 1, 1});

    assertEquals(5, result);
  }
}
