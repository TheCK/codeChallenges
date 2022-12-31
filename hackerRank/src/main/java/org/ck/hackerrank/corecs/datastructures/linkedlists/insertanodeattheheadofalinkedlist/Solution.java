package org.ck.hackerrank.corecs.datastructures.linkedlists.insertanodeattheheadofalinkedlist;

@org.ck.codechallengelib.annotation.Solution(
    id = 20203,
    name = "Insert a node at the head of a linked list",
    url = "https://www.hackerrank.com/challenges/insert-a-node-at-the-head-of-a-linked-list",
    category = "Data Structures",
    subCategory = "Linked Lists")
public class Solution {
  Node Insert(Node head, int data) {
    Node newNode = new Node();
    newNode.data = data;
    newNode.next = head;

    return newNode;
  }

  static class Node {
    int data;
    Node next;
  }
}
