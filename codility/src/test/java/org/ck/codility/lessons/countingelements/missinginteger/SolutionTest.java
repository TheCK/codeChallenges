package org.ck.codility.lessons.countingelements.missinginteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class SolutionTest extends BaseTest {
  @Test
  @Timeout(10)
  public void test00() throws Exception {
    int result = new Solution().solution(new int[] {1, 3, 6, 4, 1, 2});

    assertEquals(5, result);
  }

  @Test
  @Timeout(10)
  public void test01() throws Exception {
    int result = new Solution().solution(new int[] {1});

    assertEquals(2, result);
  }
}
