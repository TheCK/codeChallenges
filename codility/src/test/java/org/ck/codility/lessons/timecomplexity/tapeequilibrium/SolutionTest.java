package org.ck.codility.lessons.timecomplexity.tapeequilibrium;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest extends BaseTest {
  @Test
  @Timeout(10)
  public void test00() throws Exception {
    int result = new Solution().solution(new int[] {3, 1, 2, 4, 3});

    assertEquals(1, result);
  }

  @Test
  @Timeout(10)
  public void test01() throws Exception {
    int result = new Solution().solution(new int[] {3, 1});

    assertEquals(2, result);
  }

  @Test
  @Timeout(10)
  public void test02() throws Exception {
    int result = new Solution().solution(new int[] {3, -3});

    assertEquals(6, result);
  }
}
