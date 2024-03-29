package org.ck.codility.lessons.prefixsums.countdiv;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ck.codechallengelib.testhelper.BaseTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class SolutionTest extends BaseTest {
  @Test
  @Timeout(10)
  public void test00() throws Exception {
    int result = new Solution().solution(6, 11, 2);

    assertEquals(3, result);
  }

  @Disabled
  @Test
  @Timeout(10)
  public void test00b() throws Exception {
    int result = new Solution().solution(6, 12, 2);

    assertEquals(4, result);
  }

  @Disabled
  @Test
  @Timeout(10)
  public void test01() throws Exception {
    int result = new Solution().solution(11, 345, 17);

    assertEquals(20, result);
  }

  @Test
  @Timeout(10)
  public void test02() throws Exception {
    int result = new Solution().solution(0, 0, 11);

    assertEquals(1, result);
  }

  @Test
  @Timeout(10)
  public void test03() throws Exception {
    int result = new Solution().solution(1, 1, 11);

    assertEquals(0, result);
  }

  @Test
  @Timeout(10)
  public void test04() throws Exception {
    int result = new Solution().solution(10, 10, 5);

    assertEquals(1, result);
  }

  @Test
  @Timeout(10)
  public void test05() throws Exception {
    int result = new Solution().solution(10, 10, 7);

    assertEquals(0, result);
  }

  @Test
  @Timeout(10)
  public void test06() throws Exception {
    int result = new Solution().solution(10, 10, 20);

    assertEquals(0, result);
  }

  @Disabled
  @Test
  @Timeout(10)
  public void test07() throws Exception {
    int result = new Solution().solution(0, Integer.MAX_VALUE, 1);

    assertEquals(0, result);
  }

  @Disabled
  @Test
  @Timeout(10)
  public void test08() throws Exception {
    int result = new Solution().solution(0, Integer.MAX_VALUE, Integer.MAX_VALUE);

    assertEquals(0, result);
  }
}
