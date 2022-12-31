package org.ck.codility.lessons.countingelements.permcheck;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest extends BaseTest {
  @Test
  @Timeout(10)
  public void test00() throws Exception {
    int result = new Solution().solution(new int[] {4, 1, 3, 2});

    assertEquals(1, result);
  }

  @Test
  @Timeout(10)
  public void test01() throws Exception {
    int result = new Solution().solution(new int[] {4, 1, 3});

    assertEquals(0, result);
  }
}
