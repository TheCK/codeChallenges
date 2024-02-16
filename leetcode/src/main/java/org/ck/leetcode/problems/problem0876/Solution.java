package org.ck.leetcode.problems.problem0876;

@org.ck.codechallengelib.annotation.Solution(
    id = 100876,
    name = "876. Middle of the Linked List",
    url = "https://leetcode.com/problems/middle-of-the-linked-list/",
    category = "Problems",
    subCategory = "Easy",
    tags = {"Linked List", "Two Pointers"})
public class Solution {
  public ListNode middleNode(final ListNode head) {
    if (head == null) {
      return null;
    }

    if (head.next == null) {
      return head;
    }

    if (head.next.next == null) {
      return head.next;
    }

    ListNode slow = head;
    ListNode fast = head;

    while (true) {
      if (fast == null || fast.next == null) {
        return slow;
      }

      fast = fast.next.next;
      slow = slow.next;
    }
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
