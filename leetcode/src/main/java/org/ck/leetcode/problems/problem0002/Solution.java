package org.ck.leetcode.problems.problem0002;

@org.ck.codechallengelib.annotation.Solution(
    id = 100002,
    name = "2. Add Two Numbers",
    url = "https://leetcode.com/problems/add-two-numbers/",
    category = "Problems",
    subCategory = "Medium",
    tags = {"Linked List", "Math", "Recursion"})
public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    final ListNode root = new ListNode(0);
    ListNode current = root;

    int carry = 0;

    while (l1 != null || l2 != null || carry != 0) {
      final int sum = getCurrentSum(l1, l2, carry);

      current.val = sum % 10;
      carry = sum / 10;

      if (l1 != null) {
        l1 = l1.next;
      }

      if (l2 != null) {
        l2 = l2.next;
      }

      if (l1 != null || l2 != null || carry != 0) {
        current.next = new ListNode(0);
        current = current.next;
      }
    }

    return root;
  }

  private int getCurrentSum(final ListNode l1, final ListNode l2, final int carry) {
    int sum = carry;

    if (l1 != null) {
      sum += l1.val;
    }

    if (l2 != null) {
      sum += l2.val;
    }

    return sum;
  }

  public static final class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(final int val) {
      this.val = val;
    }

    ListNode(final int val, final ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
