package org.ck.hackerrank.corecs.datastructures.linkedlists.deleteanode;

@org.ck.codechallengelib.annotation.Solution(
    id = 20205,
    name = "Delete a Node",
    url = "https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list",
    category = "Data Structures",
    subCategory = "Linked Lists")
public class Solution {
  Node Delete(Node head, int position) {
    if (position == 0) {
      return head.next;
    }

    Node currentNode = head;
    for (int i = 0; i < position - 1; ++i) {
      currentNode = currentNode.next;
    }

    currentNode.next = currentNode.next.next;

    return head;
  }

  static class Node {
    int data;
    Node next;
  }
}
