package org.ck.codility.lessons.countingelements.frogeiverone;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest extends BaseTest {
  @Test
  @Timeout(10)
  public void test00() throws Exception {
    int result = new Solution().solution(5, new int[] {1, 3, 1, 4, 2, 3, 5, 4});

    assertEquals(6, result);
  }

  @Test
  @Timeout(10)
  public void test01() throws Exception {
    int result = new Solution().solution(5, new int[] {1, 3, 1, 4, 2, 3, 3, 4});

    assertEquals(-1, result);
  }
}
