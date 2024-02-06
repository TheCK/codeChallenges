package org.ck.leetcode.problems.problem2095;

@org.ck.codechallengelib.annotation.Solution(
    id = 102095,
    name = "2095. Delete the Middle Node of a Linked List",
    url = "https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/",
    category = "Problems",
    subCategory = "Medium",
    tags = {"Linked List", "Two Pointers"})
public class Solution {
  public ListNode deleteMiddle(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }

    if (head.next.next == null) {
      head.next = null;
      return head;
    }

    ListNode slow = head;
    ListNode fast = head.next.next;

    while (true) {
      if (fast == null || fast.next == null) {
        slow.next = slow.next.next;
        return head;
      }

      fast = fast.next.next;
      slow = slow.next;
    }
  }

  public static final class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
