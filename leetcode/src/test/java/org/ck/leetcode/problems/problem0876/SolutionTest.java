package org.ck.leetcode.problems.problem0876;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
  @Test
  public void testOdd() throws Exception {
    Solution.ListNode head =
        new Solution.ListNode(
            1,
            new Solution.ListNode(
                2, new Solution.ListNode(3, new Solution.ListNode(4, new Solution.ListNode(5)))));

    final Solution.ListNode middle = new Solution().middleNode(head);

    assertEquals(3, middle.val);
  }

  @Test
  public void testEven() throws Exception {
    Solution.ListNode head =
        new Solution.ListNode(
            1,
            new Solution.ListNode(
                2,
                new Solution.ListNode(
                    3,
                    new Solution.ListNode(4, new Solution.ListNode(5, new Solution.ListNode(6))))));

    final Solution.ListNode middle = new Solution().middleNode(head);

    assertEquals(4, middle.val);
  }
}
