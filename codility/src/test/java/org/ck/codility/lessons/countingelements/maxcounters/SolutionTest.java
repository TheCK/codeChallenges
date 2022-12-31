package org.ck.codility.lessons.countingelements.maxcounters;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class SolutionTest extends BaseTest {
  @Test
  @Timeout(10)
  public void test00() throws Exception {
    int[] result = new Solution().solution(5, new int[] {3, 4, 4, 6, 1, 4, 4});

    assertArrayEquals(new int[] {3, 2, 2, 4, 2}, result);
  }
}
