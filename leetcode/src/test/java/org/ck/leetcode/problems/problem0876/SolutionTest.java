package org.ck.leetcode.problems.problem0876;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SolutionTest {
  @Test
  void testOdd() throws Exception {
    final Solution.ListNode head =
        new Solution.ListNode(
            1,
            new Solution.ListNode(
                2, new Solution.ListNode(3, new Solution.ListNode(4, new Solution.ListNode(5)))));

    final Solution.ListNode middle = new Solution().middleNode(head);

    assertEquals(3, middle.val);
  }

  @Test
  void testEven() throws Exception {
    final Solution.ListNode head =
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
