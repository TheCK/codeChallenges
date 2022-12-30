package org.ck.hackerrank.corecs.datastructures.linkedlists.reversealinkedlist;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 20207,
		name = "Reverse a linked list",
		url = "https://www.hackerrank.com/challenges/reverse-a-linked-list",
		category = "Data Structures",
		subCategory = "Linked Lists"
)
public class Solution
{
	Node Reverse(Node head)
	{
		if (head != null && head.next != null)
		{
			Node newHead = Reverse(head.next);

			Node currentNode = newHead;
			while (currentNode.next != null)
			{
				currentNode = currentNode.next;
			}
			currentNode.next = head;
			head.next = null;

			return newHead;
		}

		return head;
	}

	static class Node
	{
		int data;
		Node next;
	}
}