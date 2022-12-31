package org.ck.hackerrank.corecs.datastructures.linkedlists.insertanodeatthetailofalinkedlist;

@org.ck.codechallengelib.annotation.Solution(
		id = 20202,
		name = "Insert a Node at the Tail of a Linked List",
		url = "https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list",
		category = "Data Structures",
		subCategory = "Linked Lists"
)
public class Solution
{
	Node Insert(Node head, int data)
	{
		Node newNode = new Node();
		newNode.data = data;

		if (head == null)
		{
			return newNode;
		}

		Node node = head;
		while (node.next != null)
		{
			node = node.next;
		}

		node.next = newNode;

		return head;
	}

	static class Node
	{
		int data;
		Node next;
	}
}