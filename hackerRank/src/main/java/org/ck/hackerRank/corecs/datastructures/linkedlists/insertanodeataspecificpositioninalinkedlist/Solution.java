package org.ck.hackerRank.corecs.datastructures.linkedlists.insertanodeataspecificpositioninalinkedlist;

@org.ck.codeChallengeLib.annotation.Solution(
		id = 20204,
		name = "Insert a node at a specific position in a linked list",
		url = "https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list",
		category = "Data Structures",
		subCategory = "Linked Lists"
)
public class Solution
{
	Node InsertNth(Node head, int data, int position)
	{
		Node newNode = new Node();
		newNode.data = data;

		if (position == 0)
		{
			newNode.next = head;
			return newNode;
		}

		Node currentNode = head;
		for (int i = 0; i < position - 1; ++i)
		{
			currentNode = currentNode.next;
		}

		newNode.next = currentNode.next;
		currentNode.next = newNode;

		return head;
	}

	static class Node
	{
		int data;
		Node next;
	}
}